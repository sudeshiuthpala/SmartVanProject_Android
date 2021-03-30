package com.example.smartvanproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MorningRoutingHome extends AppCompatActivity {
    String j;
    Button vanlist,childlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morning_routing_home);
        Intent ii = getIntent();
        Bundle b = ii.getExtras();
        if (b != null) {
            j = (String) b.get("name");
            // text.setText(j);
        }
        vanlist=findViewById(R.id.morningvanList);
        childlist=findViewById(R.id.morningStudentList);
        vanlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MorningRoutingHome.this,MorningRoutingVanList.class);
                i.putExtra("name",j);
                startActivity(i);
            }
        });
        childlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MorningRoutingHome.this,MorningRoutingChildList.class);
                i.putExtra("name",j);
                startActivity(i);
            }
        });
    }
}