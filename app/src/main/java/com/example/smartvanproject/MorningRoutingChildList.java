package com.example.smartvanproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

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

public class MorningRoutingChildList extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String j;
    Spinner van;
    EditText etdate;
    String selected,location,monthselect;
    ArrayList<String> listitem=new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morning_routing_child_list);
        Intent ii = getIntent();
        Bundle b = ii.getExtras();
        if (b != null) {
            j = (String) b.get("name");
            // text.setText(j);
        }
        etdate=findViewById(R.id.date4);

        van = findViewById(R.id.vanlist7);
        adapter = new ArrayAdapter<>(this, R.layout.spinnerlayout, R.id.vanText, listitem);
        van.setAdapter(adapter);
        van.setOnItemSelectedListener(this);


    }
    protected void onStart() {
        super.onStart();
        MorningRoutingChildList.BackTask bt=new MorningRoutingChildList.BackTask();
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
    public void onShowChild(View view) {
        String date=etdate.getText().toString();
        MorningRoutingChildListBackend bg=new MorningRoutingChildListBackend(this);
        bg.execute(date,selected);
    }
}