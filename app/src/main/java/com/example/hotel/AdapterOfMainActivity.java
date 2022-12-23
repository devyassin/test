package com.example.hotel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class AdapterOfMainActivity extends RecyclerView.Adapter<AdapterOfMainActivity.ViewHolder> {

    public List<Stars> mDataList;
    public OnItemClickListener mListener;
    public Context context;


    public AdapterOfMainActivity(List<Stars> dataList, Context context) {
        mDataList = dataList;
        this.context=context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Stars data = mDataList.get(position);
        holder.ratingBar.setRating(data.getNum());
        holder.ratingBar.setIsIndicator(true);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public RatingBar ratingBar;

        public ViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            ratingBar = itemView.findViewById(R.id.rating_bar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(context,Hotel_list.class);
                    int num = (int) Math.round(ratingBar.getRating());
                    i.putExtra("id",num);
                    context.startActivity(i);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

}