package com.example.android.experthometask.utils;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.support.multidex.MultiDex;


public class MyTaskApp extends Application {
    String lang;
    Configuration config;
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        lang = Localization.getLocale(getApplicationContext());
        config = getBaseContext().getResources().getConfiguration();

        if (!lang.equals("unknown") && !config.locale.getLanguage().equals(lang)) {
            Localization.setLocale(getApplicationContext(), lang);
        }



        sContext = getApplicationContext();

    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (!lang.equals("unknown") && !config.locale.getLanguage().equals(lang)) {
            Localization.setLocale(getApplicationContext(), lang);
        }

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
