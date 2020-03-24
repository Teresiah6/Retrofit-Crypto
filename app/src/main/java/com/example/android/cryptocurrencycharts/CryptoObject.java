package com.example.android.cryptocurrencycharts;

import com.google.gson.annotations.SerializedName;

public class CryptoObject {
    @SerializedName("BTC")
    BitcoinObject bitcoinObject;

    @SerializedName("ETH")
    EtheriumObject etheriumObject;

    public CryptoObject() {
    }

    public CryptoObject(BitcoinObject bitcoinObject, EtheriumObject etheriumObject) {
        this.bitcoinObject = bitcoinObject;
        this.etheriumObject = etheriumObject;
    }

    public BitcoinObject getBitcoinObject() {
        return bitcoinObject;
    }

    public void setBitcoinObject(BitcoinObject bitcoinObject) {
        this.bitcoinObject = bitcoinObject;
    }

    public EtheriumObject getEtheriumObject() {
        return etheriumObject;
    }

    public void setEtheriumObject(EtheriumObject etheriumObject) {
        this.etheriumObject = etheriumObject;
    }
}

