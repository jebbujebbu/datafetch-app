package com.example.datafetchapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DateNameAdapter extends ArrayAdapter<String[]> {
    private final Context context;
    private final JSONArray jsonArray;

    public DateNameAdapter(Context context, JSONArray jsonArray) {
        super(context, 0);
        this.context = context;
        this.jsonArray = jsonArray;
    }

    @Override
    public int getCount() {
        return jsonArray.length();
    }

    @Override
    public String[] getItem(int position) {
        try {
            JSONObject jsonObject = jsonArray.getJSONObject(position);
            String date = jsonObject.getString("pvm");
            String name = jsonObject.getString("nimi");
            return new String[]{date, name};
        } catch (JSONException e) {
            e.printStackTrace();
            return new String[]{"", ""};
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        String[] currentItem = getItem(position);
        String date = currentItem[0];
        String name = currentItem[1];

        TextView dateTextView = convertView.findViewById(R.id.dateTextView);
        dateTextView.setText(date);

        TextView nameTextView = convertView.findViewById(R.id.nameTextView);
        nameTextView.setText(name);

        convertView.setBackgroundColor(context.getResources().getColor(R.color.white));

        return convertView;
    }
}
