package com.example.smartvanproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class MorningRoutingVanListBackend extends AsyncTask<String,MorningTrip,Void> {
    String json_string="http://192.168.1.102/smartvan/morningVan.php";
    Context context;
    Activity activity;
    AlertDialog alertDialog;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<MorningTrip> arrayList=new ArrayList<>();
    ProgressDialog progressDialog;
    //private RecycleAdapter.RecyclerViewClickListener listener;
    MorningRoutingVanListBackend(Context ctx){
        context=ctx;
        activity=(Activity)ctx;
    }
    @Override
    protected Void doInBackground(String... params) {
        try {
            String Nic=params[0];
            String date=params[1];
            URL url= new URL(json_string);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
            String post_data= URLEncoder.encode("Nic","UTF-8")+"="+URLEncoder.encode(Nic,"UTF-8")+"&"+
                    URLEncoder.encode("date","UTF-8")+"="+URLEncoder.encode(date,"UTF-8") ;
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder result= new StringBuilder();
            String line;
            while ((line=bufferedReader.readLine())!=null){
                result.append(line).append("\n");

            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            String json_strings=result.toString().trim();
            //JSONObject jsonObject1=new JSONObject(Nic);
            JSONObject jsonObject=new JSONObject(json_strings);
            JSONArray jsonArray=jsonObject.getJSONArray("Server_response");
            int count=0;
            while (count<jsonArray.length()){
                JSONObject jo=jsonArray.getJSONObject(count);
                count++;
                MorningTrip fee=new MorningTrip(jo.getInt("tripid"),jo.getString("vanId"),jo.getString("route"),jo.getString("startdatetime"),jo.getString("enddatetime"),jo.getString("date"));
                publishProgress(fee);
                Thread.sleep(1000);

            }
            Log.d("JSON STRING",json_strings);
            //return result.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    protected void onPreExecute() {
        recyclerView=(RecyclerView)activity.findViewById(R.id.recyclerviewmorningvan);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter=new RecyclerAdapterTrip(arrayList,context);
        recyclerView.setAdapter(adapter);
        progressDialog=new ProgressDialog(context);
        progressDialog.setTitle("Please wait...");
        progressDialog.setMessage("List is Loading....");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        // progressDialog.show();

        //super.onPreExecute();
    }
//    private void setOnclickListner() {
//        listener=new RecycleAdapter.RecyclerViewClickListener() {
//            @Override
//            public void select(View v, int pos) {
//                Intent i=new Intent(context,RequestAcceptAction.class);
//                //i.putExtra("requestId",arrayList.get(pos).getRequestId());
//                activity.startActivity(i);
//            }
//        };
    //}

    @Override
    protected void onPostExecute(Void aVoid) {
        progressDialog.dismiss();
        //setOnclickListner();
        //setOnclickListner();
        // super.onPostExecute(aVoid);
    }

//    private void setOnclickListner() {
//        listener=new RecycleAdapter.RecyclerViewClickListener() {
//            @Override
//            public void select(View v, int pos) {
//                Intent i=
//            }
//        }
//    }
//    @Override
//    protected void onPostExecute() {
//       progressDialog.dismiss();
//        //super.onPostExecute(aVoid);
//    }


    @Override
    protected void onProgressUpdate(MorningTrip... values) {
        arrayList.add(values[0]);
        adapter.notifyDataSetChanged();
        //super.onProgressUpdate(values);
    }
}
