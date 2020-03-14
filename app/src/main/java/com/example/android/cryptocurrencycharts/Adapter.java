package com.example.android.cryptocurrencycharts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    public List<CryptoList> mList;
    private Context context;

    public Adapter(List<CryptoList> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from (viewGroup.getContext())
                .inflate(R.layout.crypto_row_list, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        CryptoList cryptoList = mList.get(position);

        holder.currency.setText(cryptoList.fsym);
        holder.USD.setText(cryptoList.tysms);
     //holder.Jpytv.setText(cryptoList.tryconversion);
       // holder.Euros.setText(cryptoList.extraparams);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView currency, USD;
        //Jpytv, Euros;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            currency = itemView.findViewById(R.id.currency);
            USD = itemView.findViewById(R.id.usd);
       //     Jpytv = itemView.findViewById(R.id.jpyTv);
         //   Euros= itemView.findViewById(R.id.euros_tv);
        }
    }
}
