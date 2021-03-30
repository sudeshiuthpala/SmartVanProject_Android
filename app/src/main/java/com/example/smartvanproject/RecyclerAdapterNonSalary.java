package com.example.smartvanproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartvanproject.NonSalaryPayment;
import com.example.smartvanproject.R;

import java.util.ArrayList;

public class RecyclerAdapterNonSalary extends RecyclerView.Adapter <RecyclerAdapterNonSalary.NonSalaryRecyclerViewHolder> {
            private final int TYPE_HEAD = 0;
            private  final int TYPE_LIST = 1;
            //private RecyclerViewClickListener listener;
            ArrayList<NonSalaryPayment> arrayList;
            Context context;

            public RecyclerAdapterNonSalary(ArrayList<NonSalaryPayment> arrayList, Context context) {
                this.arrayList = arrayList;
                this.context = context;
                //this.listener=listener;
            }
            @NonNull
            @Override
            public RecyclerAdapterNonSalary.NonSalaryRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.non_salary_row_layout, parent, false);
                RecyclerAdapterNonSalary.NonSalaryRecyclerViewHolder nonfeesrecycleHolder = new RecyclerAdapterNonSalary.NonSalaryRecyclerViewHolder(view);
                return nonfeesrecycleHolder;
                //return null;
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onBindViewHolder(@NonNull RecyclerAdapterNonSalary.NonSalaryRecyclerViewHolder holder, final int position) {
                //if(holder.viewType==TYPE_LIST){
                final NonSalaryPayment nonfee = arrayList.get(position);

                holder.driverId.setText(nonfee.getDriverId());
                holder.fname.setText(nonfee.getFname());
                holder.lname.setText(nonfee.getLname());


        //        holder.reject.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //                Intent i7=new Intent(context,RequestRejectAction.class);
        //                i7.putExtra("requestId",Integer.toString(request.getRequestId()));
        //                context.startActivity(i7);
        //            }
        //        });


            }

            @Override
            public int getItemCount() {
                return arrayList.size();
            }





        //    @NonNull
        //    @Override
        //    public RecycleHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        ////        if(viewType==TYPE_HEAD){
        ////            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.request_header_layout,parent,false);
        ////            RecycleHolder recycleHolder=new RecycleHolder(view,viewType);
        ////            return recycleHolder;
        ////        }
        //        // context=parent.getContext();
        ////        if (viewType==TYPE_LIST){
        //        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.request_row_layout, parent, false);
        //        RecycleHolder recycleHolder = new RecycleHolder(view);
        //        return recycleHolder;
        //        //}
        //        // return null;
        //    }








            //meka api hadanna ona
            public class  NonSalaryRecyclerViewHolder extends RecyclerView.ViewHolder {
                TextView driverId,fname,lname;
                int viewType;
                //Button delete;

                // private RecycleAdapter.RecyclerViewClickListener listener;
                //private RecycleHolder listener;
                //constructor
                public NonSalaryRecyclerViewHolder(View view) {
                    super(view);

                    //if(viewType==TYPE_LIST){
                    //

                    driverId=view.findViewById(R.id.driverid8);
                    fname = view.findViewById(R.id.driverfname8);
                    lname = view.findViewById(R.id.driverlname8);

                    // this.viewType=viewType;
                    //view.setOnClickListener(this);
        //                accept.setOnClickListener(new View.OnClickListener() {
        //                    @Override
        //                    public void onClick(View v) {
        //                        Intent i=new Intent(v.getContext(),RequestAcceptAction.class);
        //                        i.putExtra("requestId",RecycleAdapter.arrayList.get(getAdapterPosition()));
        //                    }
        //                });
                }
        //            else if (viewType==TYPE_HEAD){
        //                this.viewType=TYPE_HEAD;
        //
        //            }


        //           view.setOnClickListener(new View.OnClickListener() {
        //               @Override
        //               public void onClick(View v) {
        //                   RecyclerViewClickListener.select()
        //               }
        //           });
            }
        }

