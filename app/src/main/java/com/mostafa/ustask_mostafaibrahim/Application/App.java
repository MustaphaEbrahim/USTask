package com.mostafa.ustask_mostafaibrahim.Application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

public class App extends Application {
    private static Context context;
    public static Context getAppContext() {
        return App.context;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.setLocale(base));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LocaleHelper.setLocale(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        App.context = getApplicationContext();
        LocaleHelper.setLocale(getApplicationContext());

    }

}
