package com.example.recyclerviewtugas;

import android.os.Parcel;
import android.os.Parcelable;

public class Konten implements Parcelable {
    private String name;
    private String remarks;
    private String photo;

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    private String deskripsi;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.remarks);
        dest.writeString(this.photo);
        dest.writeString(this.deskripsi);
    }

    public Konten() {
    }
    protected Konten(Parcel in) {
        this.name = in.readString();
        this.remarks = in.readString();
        this.photo = in.readString();
        this.deskripsi = in.readString();
    }
    public static final Parcelable.Creator<Konten> CREATOR = new Parcelable.Creator<Konten>() {
        @Override
        public Konten createFromParcel(Parcel source) {
            return new Konten(source);
        }
        @Override
        public Konten[] newArray(int size) {
            return new Konten[size];
        }
    };
}
