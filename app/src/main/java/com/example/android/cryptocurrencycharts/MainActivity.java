package com.example.android.cryptocurrencycharts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

   private static final String BASE_URL ="https://min-api.cryptocompare.com";

    private Data data;
    //   private Adapter adapter;
    private ArrayList<CryptoList> list;
    private RecyclerView recyclerView;
    private GetDataService service;

    private String apiKey ="95953efef1284a958822ab5d8ab8fe9f4faf56bcf5d66689b1ca8720ba4a86c2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new Data();
        list = new ArrayList<>();
        recyclerView = findViewById(R.id.cryptorv);



       Retrofit retrofit = new retrofit2.Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

      // Call<List<CryptoList>>

     service = retrofit.create(GetDataService.class);
        getDatafromApi();
            }

    private void getDatafromApi() {

        service.getData(apiKey).enqueue(new Callback<List<CryptoList>>() {
            @Override
            public void onResponse(Call<List<CryptoList>> call, Response<List<CryptoList>> response) {
                if (response.body() != null) {
                    list.addAll(response.body());

                    setupAdapter(list);


                }
            }

            @Override
            public void onFailure(Call<List<CryptoList>> call, Throwable t) {

                    Toast.makeText(MainActivity.this, "Something went wrong try again", Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void  setupAdapter(List<CryptoList> list) {
        recyclerView = findViewById(R.id.cryptorv);
       Adapter adapter= new Adapter(list, MainActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
