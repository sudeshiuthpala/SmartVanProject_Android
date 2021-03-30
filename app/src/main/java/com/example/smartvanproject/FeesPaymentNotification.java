package com.example.smartvanproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

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

public class FeesPaymentNotification extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    TabLayout tabLayout;
    TabItem tabItem1,tabItem2;
    ViewPager viewPager;
    //PageAdapter pageAdapter;
    Spinner van,year,month;
    String selected,location,monthselect;
    ArrayList<String> listitem=new ArrayList<>();
    ArrayAdapter<String> adapter;
    String r,yearl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees_payment_notification);
        Intent i2=getIntent();
        Bundle b2=i2.getExtras();
        if(b2!=null){
            r=(String)b2.get("name");
            // text.setText(r);
        }
        van = findViewById(R.id.vanlist6);
        adapter = new ArrayAdapter<>(this, R.layout.spinnerlayout, R.id.vanText, listitem);
        van.setAdapter(adapter);
        van.setOnItemSelectedListener(this);

        year = findViewById(R.id.yearlist6);
        ArrayList<String> yearList= new ArrayList<>();
        yearList.add("Select Year :");

        yearList.add("2001");yearList.add("2002");
        yearList.add("2003");yearList.add("2004");
        yearList.add("2005");yearList.add("2006");
        yearList.add("2021");yearList.add("2022");yearList.add("2023");yearList.add("2024");yearList.add("2025");
        yearList.add("2026");yearList.add("2027");yearList.add("2028");yearList.add("2029");yearList.add("2030");
        yearList.add("2031");yearList.add("2032");yearList.add("2033");yearList.add("2034");yearList.add("2035");yearList.add("2036");
        yearList.add("2037");yearList.add("2038");yearList.add("2039");yearList.add("2040");

        year.setAdapter(new ArrayAdapter<>(FeesPaymentNotification.this,android.R.layout.simple_spinner_dropdown_item,yearList));
        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    //Toast.makeText(getApplicationContext(),"please Select Location",Toast.LENGTH_SHORT).show();
                }
                else{
                    yearl=parent.getItemAtPosition(position).toString();
                    //Toast.makeText(getApplicationContext(),location,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"Please Select the policy type !!", Toast.LENGTH_LONG).show();
            }
        });

        month = findViewById(R.id.monthlist6);
        ArrayList<String> monthList= new ArrayList<>();
        monthList.add("Select Month :");

        monthList.add("January");monthList.add("February");
        monthList.add("March");monthList.add("April");
        monthList.add("May");monthList.add("June");
        monthList.add("July");monthList.add("August");monthList.add("September");monthList.add("October");monthList.add("November");
        monthList.add("December");

        month.setAdapter(new ArrayAdapter<>(FeesPaymentNotification.this,android.R.layout.simple_spinner_dropdown_item,monthList));
        month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    //Toast.makeText(getApplicationContext(),"please Select Location",Toast.LENGTH_SHORT).show();
                }
                else{
                    monthselect=parent.getItemAtPosition(position).toString();
                    //Toast.makeText(getApplicationContext(),location,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"Please Select the policy type !!", Toast.LENGTH_LONG).show();
            }
        });

//        FeesPaymentNotificationBackend bg=new FeesPaymentNotificationBackend(this);
//        bg.execute(selected,yearl,monthselect,r);
    }



    protected void onStart() {
        super.onStart();
        FeesPaymentNotification.BackTask bt=new FeesPaymentNotification.BackTask();
        bt.execute(r);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        selected=parent.getItemAtPosition(pos).toString();
        //Toast.makeText(getApplicationContext(),selected,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onFees(View view) {
        FeesPaymentNotificationBackend bg=new FeesPaymentNotificationBackend(this);
        bg.execute(selected,yearl,monthselect,r);
    }

    private class BackTask extends AsyncTask<String,Void,Void> {
        ArrayList<String> list;
        String json_string="http://192.168.1.102/smartvan/getVanId.php";
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            list=new ArrayList<>();
        }

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
                String post_data= URLEncoder.encode("Nic","UTF-8")+"="+URLEncoder.encode(Nic,"UTF-8");
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
                    list.add(jo.getString("vanID"));
                    count++;
                    // Request request=new Request(jo.getInt("RequestID"),jo.getString("RequestDate"),jo.getString("Request Van ID"),jo.getInt("Child ID"),jo.getString("Child First Name"),jo.getString("Child Last Name"),jo.getString("Child Location"),jo.getString("Child School"));
                    //publishProgress(request);
                    //Thread.sleep(1000);

                }
                Log.d("JSON STRING",result);
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
        protected void onPostExecute(Void aVoid) {
            listitem.addAll(list);
            adapter.notifyDataSetChanged();
            //super.onPostExecute(aVoid);
        }
    }
//    public void onPaidList(View view) {
//
//        String van=selected;
//        String year=location;
//        String month=monthselect;
//        String nic=r;
//        PaidBackgroundWorker bg=new PaidBackgroundWorker(this);
//        bg.execute(van,year,month,nic);
//
//    }
//
//    public void onNonPaidList(View view) {
//        String van=selected;
//        String year=location;
//        String month=monthselect;
//        String nic=r;
//        NonPaidBackgroundWorker bg=new NonPaidBackgroundWorker(this);
//        bg.execute(van,year,month,nic);
//    }
//    public onFees(){
//        FeesPaymentNotificationBackend bg=new FeesPaymentNotificationBackend(this);
//        bg.execute(selected,yearl,monthselect,r);
//    }


}