package com.example.smartvanproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OwnerReports extends AppCompatActivity {
    CardView salary,van;
    String j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_reports);
        Intent ii=getIntent();
        Bundle b=ii.getExtras();
        if(b!=null){
            j=(String)b.get("name");
            // text.setText(j);
        }
        salary=findViewById(R.id.salaryReport);
        van=findViewById(R.id.vanReport);
        salary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(OwnerReports.this,SalaryReport.class);
                i.putExtra("name",j);
                startActivity(i);
            }
        });
        van.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(OwnerReports.this,VanReport.class);
                i.putExtra("name",j);
                startActivity(i);
            }
        });
    }
}