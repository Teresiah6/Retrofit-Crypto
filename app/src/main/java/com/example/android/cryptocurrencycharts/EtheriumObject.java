package com.example.android.cryptocurrencycharts;

import com.google.gson.annotations.SerializedName;

public class EtheriumObject {
    @SerializedName("USD")
    Double us_dollars;
    @SerializedName("JPY")
    Double japanese_yen;
    @SerializedName("EUR")
    Double euro;
    @SerializedName("GBP")
    Double british_pound;

    public EtheriumObject(Double us_dollars, Double japanese_yen, Double euro, Double british_pound) {
        this.us_dollars = us_dollars;
        this.japanese_yen = japanese_yen;
        this.euro = euro;
        this.british_pound = british_pound;
    }

    public EtheriumObject() {
    }

    public Double getUs_dollars() {
        return us_dollars;
    }

    public void setUs_dollars(Double us_dollars) {
        this.us_dollars = us_dollars;
    }

    public Double getJapanese_yen() {
        return japanese_yen;
    }

    public void setJapanese_yen(Double japanese_yen) {
        this.japanese_yen = japanese_yen;
    }

    public Double getEuro() {
        return euro;
    }

    public void setEuro(Double euro) {
        this.euro = euro;
    }

    public Double getBritish_pound() {
        return british_pound;
    }

    public void setBritish_pound(Double british_pound) {
        this.british_pound = british_pound;
    }
}

