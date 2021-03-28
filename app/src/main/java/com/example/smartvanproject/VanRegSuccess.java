package com.example.smartvanproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VanRegSuccess extends AppCompatActivity {
    Button show,mng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_van_reg_success);

        show=findViewById(R.id.button10);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(VanRegSuccess.this,ViewVan.class);
                startActivity(i);
            }
        });

        mng=findViewById(R.id.button11);
        mng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(VanRegSuccess.this,DriverManagement.class);
                startActivity(j);
            }
        });


    }
}