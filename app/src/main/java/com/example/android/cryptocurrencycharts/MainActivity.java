package com.example.android.cryptocurrencycharts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String BASE_URL ="https://min-api.cryptocompare.com";
    String fsyms = "BTC,ETH";
    String tsyms = "USD,JPY,EUR,GBP";


    //   private Adapter adapter;
   // private ArrayList<BitcoinObject> list;
  //  private RecyclerView recyclerView;
    GetDataService service;
    ProgressBar progressBar;


    private String apiKey ="95953efef1284a958822ab5d8ab8fe9f4faf56bcf5d66689b1ca8720ba4a86c2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        data = new Data();
//        list = new ArrayList<>();
//        recyclerView = findViewById(R.id.cryptorv);


        progressBar = findViewById(R.id.progress_circular);
       Retrofit retrofit = new retrofit2.Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

      // Call<List<CryptoList>>

     service = retrofit.create(GetDataService.class);
        getDataFromApi();
            }
    private void getDataFromApi() {

        service.getData(apiKey, fsyms, tsyms).enqueue(new Callback<CryptoObject>() {
            @Override
            public void onResponse(Call<CryptoObject> call, Response<CryptoObject> response) {

                if (response.body() != null) {

                    CryptoObject cryptoObject = response.body();

                    setViews(cryptoObject);

                }

            }

            @Override
            public void onFailure(Call<CryptoObject> call, Throwable t) {

            }
        });

    }

    private void setViews(CryptoObject cryptoObject) {

        progressBar.setVisibility(View.GONE);

        BitcoinObject bitcoin = cryptoObject.bitcoinObject;


        TextView usdBitcoin = findViewById(R.id.usdb);
        usdBitcoin.setText(String.valueOf("US Dollars: "+ bitcoin.us_dollars));

        TextView poundBitcoin = findViewById(R.id.gbpb);
        poundBitcoin.setText(String.valueOf("British Pound: " + bitcoin.british_pound));

        TextView jpyBitcoin = findViewById(R.id.jpyb);
        jpyBitcoin.setText(String.valueOf("Japanese Yen: " +bitcoin.japanese_yen));

        TextView euroBitcoin = findViewById(R.id.eurob);
        euroBitcoin.setText(String.valueOf("Euros: " + bitcoin.euro));

        EtheriumObject etherium = cryptoObject.etheriumObject;

        TextView usdEth = findViewById(R.id.usde);
        usdEth.setText(String.valueOf("US Dollars: " +etherium.us_dollars));

        TextView poundEth = findViewById(R.id.gbpe);
        poundEth.setText(String.valueOf("British Pound: " + etherium.british_pound));

        TextView jpyEth = findViewById(R.id.jpye);
        jpyEth.setText(String.valueOf("Japanese Yen: " + etherium.japanese_yen));

        TextView euroEth = findViewById(R.id.euroe);
        euroEth.setText(String.valueOf("Euros: " + etherium.euro));
    }


//
//
//    private void  setupAdapter(List<BitcoinObject> list) {
//        recyclerView = findViewById(R.id.cryptorv);
//       Adapter adapter= new Adapter(list, MainActivity.this);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
//
//    }
//}



    }
