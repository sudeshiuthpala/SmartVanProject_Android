package com.example.smartvanproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapterFeesNotify extends RecyclerView.Adapter <RecyclerAdapterFeesNotify.NotifyFeesRecyclerViewHolder> {
    private static final int TYPE_HEAD = 0;
    private static final int TYPE_LIST = 1;
    //private RecyclerViewClickListener listener;
    ArrayList<FeePayment> arrayList;
    Context context;

    public RecyclerAdapterFeesNotify(ArrayList<FeePayment> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        //this.listener=listener;
    }

    @NonNull
    @Override
    public RecyclerAdapterFeesNotify.NotifyFeesRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notication_row_layout, parent, false);
        RecyclerAdapterFeesNotify.NotifyFeesRecyclerViewHolder feesrecycleHolder = new RecyclerAdapterFeesNotify.NotifyFeesRecyclerViewHolder(view);
        return feesrecycleHolder;
        //return null;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterFeesNotify.NotifyFeesRecyclerViewHolder holder, final int position) {
        //if(holder.viewType==TYPE_LIST){
        final FeePayment fee = arrayList.get(position);
        holder.paymentId.setText(Integer.toString(fee.getPaymentId()));
        holder.childId.setText(Integer.toString(fee.getChildId()));
        holder.fname.setText(fee.getChildfname());
        holder.lname.setText(fee.getChildlname());
        holder.amount.setText(fee.getAmount());
        holder.paymentdate.setText(fee.getPayment_date());
        holder.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,AcceptFees.class);
                i.putExtra("paymentid",Integer.toString(fee.getPaymentId()));
                context.startActivity(i);
            }
        });
        holder.reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,RejectFees.class);
                i.putExtra("paymentid",Integer.toString(fee.getPaymentId()));
                context.startActivity(i);
            }
        });

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
    public class NotifyFeesRecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView paymentId,childId,fname,lname,amount,paymentdate;
        int viewType;
        Button accept,reject;

        // private RecycleAdapter.RecyclerViewClickListener listener;
        //private RecycleHolder listener;
        //constructor
        public NotifyFeesRecyclerViewHolder(View view) {
            super(view);

            //if(viewType==TYPE_LIST){
            //
            paymentId = view.findViewById(R.id.paymentid6);
            childId=view.findViewById(R.id.childid6);
            fname = view.findViewById(R.id.childfname6);
            lname = view.findViewById(R.id.childlname6);
            amount=view.findViewById(R.id.amount6);
            paymentdate=view.findViewById(R.id.paymentdate6);
            accept=view.findViewById(R.id.acceptfees);
            reject=view.findViewById(R.id.rejectfees);
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
