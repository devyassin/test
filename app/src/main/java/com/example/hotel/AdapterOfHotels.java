package com.example.hotel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class AdapterOfHotels extends RecyclerView.Adapter<AdapterOfHotels.ViewHolder> {

    private List<Hotel> mDataList;
    private OnItemClickListener mListener;

    public AdapterOfHotels(List<Hotel> dataList) {
        mDataList = dataList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list, parent, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Hotel data = mDataList.get(position);
        holder.name.setText(data.getName());
        holder.numberEtoile.setText(String.valueOf(data.getId()));

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView numberEtoile;

        public ViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            name = itemView.findViewById(R.id.hotelName);
            numberEtoile = itemView.findViewById(R.id.hotelNumber);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

}