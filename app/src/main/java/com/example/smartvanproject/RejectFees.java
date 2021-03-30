package com.example.smartvanproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RejectFees extends AppCompatActivity {
    String j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reject_fees);
        Intent ii=getIntent();
        Bundle b=ii.getExtras();
        if(b!=null){
            j=(String)b.get("paymentid");
//            k=(String)b.get("vanId");
//            l=(String)b.get("childId");
            //text1.setText(j);
            //text2.setText(k);
            //text3.setText(l);
        }
    }

    public void onRejectFees(View view) {
        RejectFeesBackend bg=new RejectFeesBackend(this);
        bg.execute(j);
    }
}