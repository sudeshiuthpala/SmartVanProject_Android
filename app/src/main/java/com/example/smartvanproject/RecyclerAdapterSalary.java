package com.example.smartvanproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapterSalary extends RecyclerView.Adapter <RecyclerAdapterSalary.SalaryRecyclerViewHolder> {
    private static final int TYPE_HEAD = 0;
    private static final int TYPE_LIST = 1;
    //private RecyclerViewClickListener listener;
    ArrayList<SalaryPaymentClass> arrayList;
    Context context;
    public RecyclerAdapterSalary(ArrayList<SalaryPaymentClass> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        //this.listener=listener;
    }
    @NonNull
    @Override
    public RecyclerAdapterSalary.SalaryRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.salary_row_layout, parent, false);
        RecyclerAdapterSalary.SalaryRecyclerViewHolder feesrecycleHolder = new RecyclerAdapterSalary.SalaryRecyclerViewHolder(view);
        return feesrecycleHolder;
        //return null;
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterSalary.SalaryRecyclerViewHolder holder, final int position) {
        //if(holder.viewType==TYPE_LIST){
        final SalaryPaymentClass fee = arrayList.get(position);
        holder.paymentId.setText(Integer.toString(fee.getPaymentId()));
        holder.driverId.setText(fee.getDriverId());
        holder.fname.setText(fee.getDriverfname());
        holder.lname.setText(fee.getDriverlname());
        holder.amount.setText(fee.getAmount());
        holder.paymentdate.setText(fee.getPayment_date());

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

    public class SalaryRecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView paymentId,driverId,fname,lname,amount,paymentdate;
        int viewType;
        //Button delete;

        // private RecycleAdapter.RecyclerViewClickListener listener;
        //private RecycleHolder listener;
        //constructor
        public SalaryRecyclerViewHolder(View view) {
            super(view);

            //if(viewType==TYPE_LIST){
            //
            paymentId = view.findViewById(R.id.paymentid7);
            driverId=view.findViewById(R.id.driverid7);
            fname = view.findViewById(R.id.driverfname7);
            lname = view.findViewById(R.id.driverlname7);
            amount=view.findViewById(R.id.amount7);
            paymentdate=view.findViewById(R.id.paymentdate7);
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
