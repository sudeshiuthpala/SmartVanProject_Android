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

public class RecyclerAdapterTripChild extends RecyclerView.Adapter <RecyclerAdapterTripChild.TripChildRecyclerViewHolder>{
    private static final int TYPE_HEAD = 0;
    private static final int TYPE_LIST = 1;
    //private RecyclerViewClickListener listener;
    ArrayList<TripChild> arrayList;
    Context context;
    public RecyclerAdapterTripChild(ArrayList<TripChild> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        //this.listener=listener;
    }
    public RecyclerAdapterTripChild.TripChildRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_child_row_layout, parent, false);
        RecyclerAdapterTripChild.TripChildRecyclerViewHolder childrecycleHolder = new RecyclerAdapterTripChild.TripChildRecyclerViewHolder(view);
        return childrecycleHolder;
        //return null;
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterTripChild.TripChildRecyclerViewHolder holder, final int position) {
        //if(holder.viewType==TYPE_LIST){
        final TripChild child = arrayList.get(position);
        holder.fname.setText(child.getChildfname());
        holder.lname.setText(child.getChildlname());
        holder.school.setText(child.getChildschool());
        holder.location.setText(child.getChildlocation());

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

    public class TripChildRecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView fname,lname,school,location;
        int viewType;


        // private RecycleAdapter.RecyclerViewClickListener listener;
        //private RecycleHolder listener;
        //constructor
        public TripChildRecyclerViewHolder(View view) {
            super(view);

            //if(viewType==TYPE_LIST){

            fname = view.findViewById(R.id.tripchildFName2);
            lname = view.findViewById(R.id.tripchildLName2);
            school = view.findViewById(R.id.tripchildschool2);
            location= view.findViewById(R.id.tripchildlocation2);
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
