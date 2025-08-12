package com.example.datafetchapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DateNameRecyclerAdapter extends RecyclerView.Adapter<DateNameRecyclerAdapter.ViewHolder> {

    private Context context;
    private ArrayList<DateName> dateNameList;

    // Constructor to receive context and data source
    public DateNameRecyclerAdapter(Context context, ArrayList<DateName> dateNameList) {
        this.context = context;
        this.dateNameList = dateNameList;
    }

    // Inner class holds references to the views in each list item for performance
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView dateTextView;
        public TextView nameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
        }
    }

    // Method to inflate the layout XML of the list item and create a ViewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);        return new ViewHolder(view);
    }

    // Method to bind data to each ViewHolder (each list item)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DateName item = dateNameList.get(position);
        holder.dateTextView.setText(item.getPvm());
        holder.nameTextView.setText(item.getNimi());
    }

    // Method to tell RecyclerView how many items there are
    @Override
    public int getItemCount() {
        return dateNameList.size();
    }
}
