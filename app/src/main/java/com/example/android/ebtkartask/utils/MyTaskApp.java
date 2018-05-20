package com.example.android.ebtkartask.utils;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.support.multidex.MultiDex;


public class MyTaskApp extends Application {
    Configuration config;
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        config = getBaseContext().getResources().getConfiguration();
        sContext = getApplicationContext();

    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);


    }

    public static Context getContext() {
        return sContext;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
