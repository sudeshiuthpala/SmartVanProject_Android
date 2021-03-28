package com.example.smartvanproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class PaidPayment extends AppCompatActivity {
    String p,q,r,s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paid_payment);

        Intent i2 = getIntent();
        Bundle b2 = i2.getExtras();
        if (b2 != null) {
            p=(String)b2.get("vanId");
            q=(String)b2.get("year");
            r =(String)b2.get("month");
            s=(String) b2.get("name");// text.setText(r);
        }
        PaidPaymentBackgroundWorker bg=new PaidPaymentBackgroundWorker(this);
        bg.execute(p,q,r,s);
    }
}
