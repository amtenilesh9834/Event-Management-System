package com.example.event;

import  android.app.Application;
import android.content.Context;

public class Event extends Application{
    public static Event sInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }
    public static Event getInstance(){
        return sInstance;
    }
    public static Context getAppContext(){

        return sInstance.getApplicationContext();
    }
}

