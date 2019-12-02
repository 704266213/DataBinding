package com.databinding.demo;

import android.app.Application;
import android.content.Context;

public class DataBindApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

    }

    private static Context context;

    public static Context getDataBindContext() {
        return context;
    }
}
