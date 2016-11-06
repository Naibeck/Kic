package com.indigitous.hack.sansalvador.kic.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Calendar;
import java.util.Date;

public class Token implements Parcelable {

    //TODO: Provide with data that server sent
    @SerializedName("id")
    private Long mId;
    
    @SerializedName("ext_id")
    private String mExtId;

    @SerializedName("ext_desc_id")
    private String mMethod;

    @SerializedName("create_timestamp")
    private Date mDate;

    public Token(String mExtId, String mMethod) {
        this.mExtId = mExtId;
        this.mMethod = mMethod;
        mDate = Calendar.getInstance().getTime();
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long mId) {
        this.mId = mId;
    }

    public String getExtId() {
        return mExtId;
    }

    public void setExtId(String mExtId) {
        this.mExtId = mExtId;
    }

    public String getMethod() {
        return mMethod;
    }

    public void setMethod(String mMethod) {
        this.mMethod = mMethod;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.mId);
        dest.writeString(this.mExtId);
        dest.writeString(this.mMethod);
        dest.writeLong(this.mDate != null ? this.mDate.getTime() : -1);
    }

    protected Token(Parcel in) {
        this.mId = (Long) in.readValue(Long.class.getClassLoader());
        this.mExtId = in.readString();
        this.mMethod = in.readString();
        long tmpMDate = in.readLong();
        this.mDate = tmpMDate == -1 ? null : new Date(tmpMDate);
    }

    public static final Creator<Token> CREATOR = new Creator<Token>() {
        @Override
        public Token createFromParcel(Parcel source) {
            return new Token(source);
        }

        @Override
        public Token[] newArray(int size) {
            return new Token[size];
        }
    };
}
