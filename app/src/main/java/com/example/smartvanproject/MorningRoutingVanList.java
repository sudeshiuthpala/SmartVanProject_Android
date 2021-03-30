package com.example.smartvanproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MorningRoutingVanList extends AppCompatActivity {
    String j;
    EditText etdate;
    Button btnshow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morning_routing_van_list);
        Intent ii = getIntent();
        Bundle b = ii.getExtras();
        if (b != null) {
            j = (String) b.get("name");
            // text.setText(j);
        }
        etdate=findViewById(R.id.vanDate);
//        btnshow=findViewById(R.id.showvanlist);
//        btnshow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String date=etdate.getText().toString();
//                MorningRoutingVanListBackend bg=new MorningRoutingVanListBackend(MorningRoutingVanList.this);
//                bg.execute(j);
//            }
//        });
    }

    public void showVan(View view) {
        String date=etdate.getText().toString();
        MorningRoutingVanListBackend bg=new MorningRoutingVanListBackend(MorningRoutingVanList.this);
        bg.execute(j,date);

    }
}