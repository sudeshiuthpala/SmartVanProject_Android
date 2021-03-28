package com.example.smartvanproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChildRemoveAction extends AppCompatActivity {
    String j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_remove_action);
        Intent ii=getIntent();
        Bundle b=ii.getExtras();
        if(b!=null){
            j=(String)b.get("childId");

            //text1.setText(j);
            //text2.setText(k);
            //text3.setText(l);
        }
    }
    public void onRemoveChild(View view) {
        DriverRemoveActionBackend bg=new DriverRemoveActionBackend(this);
        bg.execute(j);

    }
}