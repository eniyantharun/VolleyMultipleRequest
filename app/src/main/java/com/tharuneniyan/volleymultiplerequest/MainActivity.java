package com.tharuneniyan.volleymultiplerequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;


import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements VolleyResponse {

    private Button btnSendRequest;
    private String url = "http://www.mocky.io/v2/5c5efba2320000bd0c40b454";
    private String url2 = "http://www.mocky.io/v2/5c5f1e44320000c00c40b47f";
    private RequestQueue mRequestQueue;
    private StringRequest stringRequest;
    private String TAG = MainActivity.class.getName();
    private String REQUESTTAG = "String First Request";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSendRequest = findViewById(R.id.printButton);
        btnSendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequestAndPrintResponse();
            }
        });
    }

    private void sendRequestAndPrintResponse() {

       CustomJSONObjectRequest request1 = new CustomJSONObjectRequest(Request.Method.GET, url,
                new JSONObject(), "YOUR REQUEST TAG",  this);
        CustomJSONObjectRequest request2 = new CustomJSONObjectRequest(Request.Method.GET, url2,
                new JSONObject(), "YOUR REQUEST TAG",  this);

        mRequestQueue.add(request1.getJsonObjectRequest());
        mRequestQueue.add(request2.getJsonObjectRequest());
    }

    @Override
    public void onResponse(JSONObject object, String tag) {
        Log.i(TAG,"Response :"+ object.toString() + "   " + tag);
    }

    @Override
    public void onError(VolleyError error, String tag) {

    }
}
