package com.indigitous.hack.sansalvador.kic;

import android.app.Application;

import com.digits.sdk.android.Digits;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.indigitous.hack.sansalvador.kic.util.KicPreferences;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;

import io.fabric.sdk.android.Fabric;

public class KicApplication extends Application {

    private static KicApplication sKicApplication;

    private Gson mGson;

    private KicPreferences mPreferences;

    private static final String TWITTER_KEY = "cCkP5xYgUS9E6vykaeEsZM8nZ";
    private static final String TWITTER_SECRET = "E3Z9CjDhzCiTvXq7dNzWwwhRymgMLUXr5svp9yJpRCmXgiDZQz";

    @Override
    public void onCreate() {
        super.onCreate();
        sKicApplication = this;
        mPreferences = new KicPreferences(this);

        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new TwitterCore(authConfig), new Digits.Builder().build());
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
