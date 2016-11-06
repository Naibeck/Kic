package com.indigitous.hack.sansalvador.kic.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Contact implements Parcelable {

    @SerializedName("contact_alias")
    private String mContactName;

    @SerializedName("contact_desc")
    private String mDescription;

    public Contact(String mContactName, String mDescription) {
        this.mContactName = mContactName;
        this.mDescription = mDescription;
    }

    public String getContactName() {
        return mContactName;
    }

    public void setContactName(String mContactName) {
        this.mContactName = mContactName;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mContactName);
        dest.writeString(this.mDescription);
    }

    protected Contact(Parcel in) {
        this.mContactName = in.readString();
        this.mDescription = in.readString();
    }

    public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel source) {
            return new Contact(source);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };
}
