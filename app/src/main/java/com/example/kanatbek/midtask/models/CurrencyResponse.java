package com.example.kanatbek.midtask.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrencyResponse {
    @SerializedName("rates")
    @Expose
    public Rates rates;

    @SerializedName("base")
    @Expose
    public String base;

    @SerializedName("date")
    @Expose
    public String date;

    public CurrencyResponse(Rates rates, String base, String date) {
        this.rates = rates;
        this.base = base;
        this.date = date;
    }

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
