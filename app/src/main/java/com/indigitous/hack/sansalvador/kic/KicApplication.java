package com.indigitous.hack.sansalvador.kic;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.indigitous.hack.sansalvador.kic.util.KicPreferences;

public class KicApplication extends Application {

    private static KicApplication sKicApplication;

    private Gson mGson;

    private KicPreferences mPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        sKicApplication = this;
        mPreferences = new KicPreferences(this);
    }

    public synchronized static KicApplication getInstance() {
        return sKicApplication;
    }

    public KicPreferences getPreferences() {
        return mPreferences;
    }

    public Gson getGson() {
        if (mGson == null) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            mGson = gsonBuilder.create();
        }
        return mGson;
    }
}
