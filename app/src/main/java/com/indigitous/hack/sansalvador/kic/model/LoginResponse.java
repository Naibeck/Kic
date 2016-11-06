package com.indigitous.hack.sansalvador.kic.model;

import android.os.Parcel;
import android.os.Parcelable;

public class LoginResponse implements Parcelable {
    private Long mId;

    public LoginResponse(Long mId) {
        this.mId = mId;
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.mId);
    }

    protected LoginResponse(Parcel in) {
        this.mId = (Long) in.readValue(Long.class.getClassLoader());
    }

    public static final Parcelable.Creator<LoginResponse> CREATOR = new Parcelable.Creator<LoginResponse>() {
        @Override
        public LoginResponse createFromParcel(Parcel source) {
            return new LoginResponse(source);
        }

        @Override
        public LoginResponse[] newArray(int size) {
            return new LoginResponse[size];
        }
    };
}
