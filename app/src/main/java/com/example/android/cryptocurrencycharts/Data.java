package com.example.android.cryptocurrencycharts;

import java.util.List;

public class Data {

    public List<CryptoList> data;

    public Data (List<CryptoList> data){
        this.data =data;
    }
    public Data(){

    }

    public List<CryptoList> getData() {
        return data;
    }

    public void setData(List<CryptoList> data) {
        this.data = data;
    }
}
