package com.example.datafetchapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    ListView lv;
    ArrayAdapter<String> adapter;
    DateNameAdapter dnAdapter;
    List<String> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv = (TextView)findViewById(R.id.textView);
        lv = (ListView)findViewById(R.id.listView);
        tv.setText("Data");

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "\"https://jebbujebbu.github.io/datafetch-app/data/data.json";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("main", "response: " + response);

                    try {
                        JSONArray jsonArray = new JSONArray(response);

                        dataList.clear();

                        //27. The date and name are in one row somehow (e.g. 27.5.2017 12:15:30, Matt Damon)
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String date = jsonObject.getString("pvm");
                            String name = jsonObject.getString("nimi");
                            dataList.add(date + ", " + name);
                        }

                        // 27: COMMENT the line below to display the list using a simple ArrayAdapter.
                        // 28: UNCOMMENT the line below to switch to the custom DateNameAdapter for displaying each date-name pair in two rows.
                        dnAdapter = new DateNameAdapter(MainActivity.this, jsonArray);


                        if (dnAdapter != null) {
                            dnAdapter.notifyDataSetChanged();
                            lv.setAdapter(dnAdapter);
                        } else {
                            adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, dataList);
                            lv.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        String msg = "Error parsing JSON: '" + e + "'";
                        Log.d("main", msg);
                        tv.setText(msg);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String msg = "ERROR: '" + error + "'";
                Log.d("main", msg);
                tv.setText(msg);
            }
        });

        queue.add(stringRequest);
    }
}