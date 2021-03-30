package com.example.smartvanproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class SalaryReport extends AppCompatActivity {
    String j;
    TabLayout tabLayout;
    TabItem tabItem1,tabItem2;
    ViewPager viewPager;
    //PageAdapter pageAdapter;
    Spinner van,year,month;
    String selected,location,monthselect;
    ArrayList<String> listitem=new ArrayList<>();
    ArrayAdapter<String> adapter;
    String yearl;
    Button paid , nonpaid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_report);
        Intent ii=getIntent();
        Bundle b=ii.getExtras();
        if(b!=null){
            j=(String)b.get("name");
            // text.setText(j);
        }
        year = findViewById(R.id.yearlist7);
        ArrayList<String> yearList= new ArrayList<>();
        yearList.add("Select Year :");

        yearList.add("2001");yearList.add("2002");
        yearList.add("2003");yearList.add("2004");
        yearList.add("2005");yearList.add("2006");
        yearList.add("2021");yearList.add("2022");yearList.add("2023");yearList.add("2024");yearList.add("2025");
        yearList.add("2026");yearList.add("2027");yearList.add("2028");yearList.add("2029");yearList.add("2030");
        yearList.add("2031");yearList.add("2032");yearList.add("2033");yearList.add("2034");yearList.add("2035");yearList.add("2036");
        yearList.add("2037");yearList.add("2038");yearList.add("2039");yearList.add("2040");

        year.setAdapter(new ArrayAdapter<>(SalaryReport.this,android.R.layout.simple_spinner_dropdown_item,yearList));
        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    //Toast.makeText(getApplicationContext(),"please Select Location",Toast.LENGTH_SHORT).show();
                }
                else{
                    yearl=parent.getItemAtPosition(position).toString();
                    //Toast.makeText(getApplicationContext(),location,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"Please Select the policy type !!", Toast.LENGTH_LONG).show();
            }
        });

        month = findViewById(R.id.monthlist7);
        ArrayList<String> monthList= new ArrayList<>();
        monthList.add("Select Month :");

        monthList.add("January");monthList.add("February");
        monthList.add("March");monthList.add("April");
        monthList.add("May");monthList.add("June");
        monthList.add("July");monthList.add("August");monthList.add("September");monthList.add("October");monthList.add("November");
        monthList.add("December");

        month.setAdapter(new ArrayAdapter<>(SalaryReport.this,android.R.layout.simple_spinner_dropdown_item,monthList));
        month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    //Toast.makeText(getApplicationContext(),"please Select Location",Toast.LENGTH_SHORT).show();
                }
                else{
                    monthselect=parent.getItemAtPosition(position).toString();
                    //Toast.makeText(getApplicationContext(),location,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"Please Select the policy type !!", Toast.LENGTH_LONG).show();
            }
        });
        paid=findViewById(R.id.paidsalary);
        nonpaid=findViewById(R.id.nonpaidsalary);
        paid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SalaryReport.this,PaidSalaryReport.class);
                i.putExtra("year",yearl);
                i.putExtra("month",monthselect);
                i.putExtra("name",j);
                startActivity(i);
            }
        });
        nonpaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SalaryReport.this,NonPaidSalaryReport.class);
                i.putExtra("year",yearl);
                i.putExtra("month",monthselect);
                i.putExtra("name",j);
                startActivity(i);
            }
        });
    }
}