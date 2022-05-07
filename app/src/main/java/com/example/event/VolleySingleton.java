package com.example.event;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {
    private  static VolleySingleton sInstance = null;
    private RequestQueue mRequestQueue;

    private VolleySingleton()
    {
        mRequestQueue = getmRequestQueue();
    }

    public  static VolleySingleton getInstance(){
        if(sInstance == null)
        {
            sInstance = new VolleySingleton();
        }
        return sInstance;
    }
    private RequestQueue getmRequestQueue(){
        if(mRequestQueue == null){
            mRequestQueue = Volley.newRequestQueue((Context) Event.getAppContext());
        }
        return mRequestQueue;
    }

    public void addRequestQueue(Request request){
        mRequestQueue.add(request);
    }
}



