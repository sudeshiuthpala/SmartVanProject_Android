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

public class RecyclerAdapterTrip extends  RecyclerView.Adapter <RecyclerAdapterTrip.TripRecyclerViewHolder>{
    private static final int TYPE_HEAD = 0;
    private static final int TYPE_LIST = 1;
    //private RecyclerViewClickListener listener;
    ArrayList<MorningTrip> arrayList;
    Context context;

    public RecyclerAdapterTrip(ArrayList<MorningTrip> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        //this.listener=listener;
    }

    @NonNull
    @Override
    public RecyclerAdapterTrip.TripRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.morning_van_row_layout, parent, false);
        RecyclerAdapterTrip.TripRecyclerViewHolder feesrecycleHolder = new RecyclerAdapterTrip.TripRecyclerViewHolder(view);
        return feesrecycleHolder;
        //return null;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterTrip.TripRecyclerViewHolder holder, final int position) {
        //if(holder.viewType==TYPE_LIST){
        final MorningTrip fee = arrayList.get(position);
        holder.tripid.setText(Integer.toString(fee.getTripid()));
        holder.vanid.setText(fee.getVanid());
        holder.route.setText(fee.getRoute());
        holder.starttime.setText(fee.getStarttime());
        holder.endtime.setText(fee.getEndtime());
        holder.date.setText(fee.getDate());

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

    public class TripRecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView tripid,vanid,route,starttime,endtime,date;
        int viewType;
        //Button delete;

        // private RecycleAdapter.RecyclerViewClickListener listener;
        //private RecycleHolder listener;
        //constructor
        public TripRecyclerViewHolder(View view) {
            super(view);

            //if(viewType==TYPE_LIST){
            //
            tripid = view.findViewById(R.id.tripid3);
            vanid=view.findViewById(R.id.vanId3);
            route = view.findViewById(R.id.route3);
            starttime = view.findViewById(R.id.start3);
            endtime=view.findViewById(R.id.end3);
            date=view.findViewById(R.id.date3);
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
