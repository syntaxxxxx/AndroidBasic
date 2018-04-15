package com.example.idn.basicandroidmozilla.model;

import android.os.Parcel;
import android.os.Parcelable;

//TODO 1 buat pojo dan jadikan object parcelable
public class Orang implements Parcelable {

    // baut variable / property
    String nama, alamat, asal;
    int umur;

    //method setter && getter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.alamat);
        dest.writeString(this.asal);
        dest.writeInt(this.umur);
    }

    public Orang() {
    }

    protected Orang(Parcel in) {
        this.nama = in.readString();
        this.alamat = in.readString();
        this.asal = in.readString();
        this.umur = in.readInt();
    }

    public static final Parcelable.Creator<Orang> CREATOR = new Parcelable.Creator<Orang>() {
        @Override
        public Orang createFromParcel(Parcel source) {
            return new Orang(source);
        }

        @Override
        public Orang[] newArray(int size) {
            return new Orang[size];
        }
    };
}
