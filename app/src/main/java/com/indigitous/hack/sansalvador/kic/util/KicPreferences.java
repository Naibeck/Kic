package com.indigitous.hack.sansalvador.kic.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.indigitous.hack.sansalvador.kic.KicApplication;
import com.indigitous.hack.sansalvador.kic.model.Token;

/**
 * This class save the data in preferences to persist sessions
 */
public class KicPreferences {

    private SharedPreferences mPreferences;

    public KicPreferences(Context context) {
        mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public Token getToken() {
        Gson gson = KicApplication.getInstance().getGson();
        String json = mPreferences.getString(Constants.KIC_TOKEN, null);

        if (json == null) {

            return null;
        }

        return gson.fromJson(json, Token.class);
    }

    public void setToken(Token token) {
        Gson gson = KicApplication.getInstance().getGson();
        String json;

        if (token == null) {

            json = null;
        } else {

            json = gson.toJson(token);
        }
        mPreferences.edit().putString(Constants.KIC_TOKEN, json).apply();
    }

}
