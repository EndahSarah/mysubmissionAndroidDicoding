package com.endah.mysubmissiondicoding;

import android.os.Parcel;
import android.os.Parcelable;
import android.telecom.Call;

public class History implements Parcelable {
    private String name;
    private String release;
    private String detail;
    private int photo;

    protected History(Parcel in) {
        name = in.readString();
        release = in.readString();
        detail = in.readString();
        photo = in.readInt();
    }

    public static final Creator<History> CREATOR = new Creator<History>() {
        @Override
        public History createFromParcel(Parcel in) {
            return new History(in);
        }

        @Override
        public History[] newArray(int size) {
            return new History[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(release);
        dest.writeString(detail);
        dest.writeInt(photo);
    }
    public History(){

    }
}
