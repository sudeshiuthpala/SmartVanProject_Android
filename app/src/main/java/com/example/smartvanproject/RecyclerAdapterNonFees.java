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

public class RecyclerAdapterNonFees extends RecyclerView.Adapter <RecyclerAdapterNonFees.NonFeesRecyclerViewHolder> {

    private static final int TYPE_HEAD = 0;
    private static final int TYPE_LIST = 1;
    //private RecyclerViewClickListener listener;
    ArrayList<NonFeePayment> arrayList;
    Context context;

    public RecyclerAdapterNonFees(ArrayList<NonFeePayment> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        //this.listener=listener;
    }

    @NonNull
    @Override
    public RecyclerAdapterNonFees.NonFeesRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.non_fee_row_layout, parent, false);
        RecyclerAdapterNonFees.NonFeesRecyclerViewHolder nonfeesrecycleHolder = new RecyclerAdapterNonFees.NonFeesRecyclerViewHolder(view);
        return nonfeesrecycleHolder;
        //return null;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterNonFees.NonFeesRecyclerViewHolder holder, final int position) {
        //if(holder.viewType==TYPE_LIST){
        final NonFeePayment nonfee = arrayList.get(position);

        holder.childId.setText(Integer.toString(nonfee.getChildId()));
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
    public class  NonFeesRecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView childId,fname,lname;
        int viewType;
        //Button delete;

        // private RecycleAdapter.RecyclerViewClickListener listener;
        //private RecycleHolder listener;
        //constructor
        public NonFeesRecyclerViewHolder(View view) {
            super(view);

            //if(viewType==TYPE_LIST){
            //

            childId=view.findViewById(R.id.childid4);
            fname = view.findViewById(R.id.childfname4);
            lname = view.findViewById(R.id.childlname4);

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
