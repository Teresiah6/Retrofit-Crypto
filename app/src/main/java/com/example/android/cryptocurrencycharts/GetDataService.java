package com.example.android.cryptocurrencycharts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {
    public static final String BASE_URL ="https://min-api.cryptocompare.com";

    @GET("/data/pricemulti?fsyms=ETH,DASH&tsyms=BTC,USD,EUR")
    Call<List<CryptoList>> getData(@Query("apiKey") String api);


}
