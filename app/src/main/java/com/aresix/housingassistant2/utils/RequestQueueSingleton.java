package com.aresix.housingassistant2.utils;

import android.annotation.SuppressLint;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class RequestQueueSingleton {
    @SuppressLint("StaticFieldLeak")
    private static RequestQueueSingleton instance;
    private RequestQueue requestQueue;
    private final Context context;

    private RequestQueueSingleton(Context context) {
        this.context = context;
    }

    public static RequestQueueSingleton getInstance(Context context) {
        if (instance == null) {
            instance = new RequestQueueSingleton(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }
}
