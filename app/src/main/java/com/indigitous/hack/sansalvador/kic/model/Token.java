package com.indigitous.hack.sansalvador.kic.model;

import com.google.gson.annotations.SerializedName;

public class Token {

    //TODO: Provide with data that server sent
    @SerializedName("")
    private String mId;

    public String getId() {
        return mId;
    }

    public void setId(String mId) {
        this.mId = mId;
    }
}
