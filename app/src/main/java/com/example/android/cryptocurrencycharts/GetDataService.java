package com.example.android.cryptocurrencycharts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {
    @GET("/data/price")
    Call<List<CryptoList>> getData(@Query("apiKey") String api);


}
