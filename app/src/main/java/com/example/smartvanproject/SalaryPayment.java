package com.example.smartvanproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class SalaryPayment extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner salary,month;
    EditText etamount;
    String j,selected,date;
    ArrayList<String> listitem=new ArrayList<>();
    ArrayAdapter<String> adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_payment);
        salary=findViewById(R.id.driverList);
        month=findViewById(R.id.paymonthlist);
        etamount=findViewById(R.id.amountentry);
        Intent i2 = getIntent();
        Bundle b2 = i2.getExtras();
        if (b2 != null) {
            j=(String) b2.get("name");// text.setText(r);
        }
        adapter1 = new ArrayAdapter<>(this, R.layout.spinnerlayout, R.id.vanText, listitem);
        salary.setAdapter(adapter1);
        salary.setOnItemSelectedListener(this);

        ArrayList<String> monthList= new ArrayList<>();
        monthList.add("Select Month :");

        monthList.add("January");monthList.add("February");
        monthList.add("March");monthList.add("April");
        monthList.add("May");monthList.add("June");
        monthList.add("July");monthList.add("August");monthList.add("September");monthList.add("October");monthList.add("November");
        monthList.add("December");

        month.setAdapter(new ArrayAdapter<>(SalaryPayment.this,android.R.layout.simple_spinner_dropdown_item,monthList));
        month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    //Toast.makeText(getApplicationContext(),"please Select Location",Toast.LENGTH_SHORT).show();
                }
                else{
                    date=parent.getItemAtPosition(position).toString();
                    //Toast.makeText(getApplicationContext(),location,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"Please Select the policy type !!", Toast.LENGTH_LONG).show();
            }
        });


    }

    public void onPaySalary(View view) {
        String driver=selected;
        String amount=etamount.getText().toString();
        SalaryPaymentBackend bg=new SalaryPaymentBackend(this);
        bg.execute(driver,j,date,amount);
    }
    protected void onStart() {
        super.onStart();
        SalaryPayment.BackTask bt=new SalaryPayment.BackTask();
        bt.execute(j);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        selected=parent.getItemAtPosition(pos).toString();
        //Toast.makeText(getApplicationContext(),selected,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private class BackTask extends AsyncTask<String,Void,Void> {
        ArrayList<String> list;
        String json_string="http://192.168.1.102/smartvan/getDriverID.php";


        @Override
        protected Void doInBackground(String... params) {
            try {
                String Nic=params[0];
                URL url= new URL(json_string);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
                String post_data= URLEncoder.encode("Nic","UTF-8")+"="+URLEncoder.encode(Nic,"UTF-8") ;
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                String result="";
                String line;
                while ((line=bufferedReader.readLine())!=null){
                    result+=line;

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                //  String json_strings=result.toString().trim();
                //JSONObject jsonObject1=new JSONObject(Nic);
                JSONObject jsonObject=new JSONObject(result);
                JSONArray jsonArray=jsonObject.getJSONArray("Server_response");
                int count=0;
                while (count<jsonArray.length()){
                    JSONObject jo=jsonArray.getJSONObject(count);
                    list.add(jo.getString("driver_NIC"));
                    count++;
                    // Request request=new Request(jo.getInt("RequestID"),jo.getString("RequestDate"),jo.getString("Request Van ID"),jo.getInt("Child ID"),jo.getString("Child First Name"),jo.getString("Child Last Name"),jo.getString("Child Location"),jo.getString("Child School"));
                    //publishProgress(request);
                    //Thread.sleep(1000);

                }
                //Log.d("JSON STRING",result);
                //return result.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            list=new ArrayList<>();
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            listitem.addAll(list);
            adapter1.notifyDataSetChanged();
            //super.onPostExecute(aVoid);
        }
    }
}