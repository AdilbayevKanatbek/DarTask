package com.example.kanatbek.midtask.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rates implements Parcelable {
    @SerializedName("USD")
    @Expose
    public Double usd;

    @SerializedName("EUR")
    @Expose
    public Double eur;

    @SerializedName("GBP")
    @Expose
    public Double gbp;

    @SerializedName("RUB")
    @Expose
    public Double rub;

    public Rates() {

    }

    public Rates(Double usd, Double eur, Double gbp, Double rub) {
        this.usd = usd;
        this.eur = eur;
        this.gbp = gbp;
        this.rub = rub;
    }

    protected Rates(Parcel in) {
        if (in.readByte() == 0) {
            usd = null;
        } else {
            usd = in.readDouble();
        }
        if (in.readByte() == 0) {
            eur = null;
        } else {
            eur = in.readDouble();
        }
        if (in.readByte() == 0) {
            gbp = null;
        } else {
            gbp = in.readDouble();
        }
        if (in.readByte() == 0) {
            rub = null;
        } else {
            rub = in.readDouble();
        }
    }

    public static final Creator<Rates> CREATOR = new Creator<Rates>() {
        @Override
        public Rates createFromParcel(Parcel in) {
            return new Rates(in);
        }

        @Override
        public Rates[] newArray(int size) {
            return new Rates[size];
        }
    };

    public Double getUsd() {
        return usd;
    }

    public void setUsd(Double usd) {
        this.usd = usd;
    }

    public Double getEur() {
        return eur;
    }

    public void setEur(Double eur) {
        this.eur = eur;
    }

    public Double getGbp() {
        return gbp;
    }

    public void setGbp(Double gbp) {
        this.gbp = gbp;
    }

    public Double getRub() {
        return rub;
    }

    public void setRub(Double rub) {
        this.rub = rub;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (usd == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(usd);
        }
        if (eur == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(eur);
        }
        if (gbp == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(gbp);
        }
        if (rub == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(rub);
        }
    }
}