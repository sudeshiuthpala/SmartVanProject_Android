package com.example.smartvanproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Payments extends AppCompatActivity {
    CardView fees,salary,notify;
    String r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);
        fees=findViewById(R.id.fees);
        salary=findViewById(R.id.salary);
        notify=findViewById(R.id.notify);
        Intent i2=getIntent();
        Bundle b2=i2.getExtras();
        if(b2!=null){
            r=(String)b2.get("name");
            // text.setText(r);
        }
        fees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Payments.this,FeesPayment.class);
                i.putExtra("name",r);
                startActivity(i);
            }
        });
        salary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Payments.this,SalaryPayment.class);
                i.putExtra("name",r);
                startActivity(i);
            }
        });
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Payments.this,FeesPaymentNotification.class);
                i.putExtra("name",r);
                startActivity(i);
            }
        });
    }
}