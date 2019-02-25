package com.example.kanatbek.midtask.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.kanatbek.midtask.R;
import com.example.kanatbek.midtask.Repository.Api;
import com.example.kanatbek.midtask.models.CurrencyResponse;
import com.example.kanatbek.midtask.models.Rates;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CurrencyDetailed extends Activity{

    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private ProgressBar loading;
    private TextView rate_text1;
    private TextView rate_text2;
    private TextView rate_text3;
    private TextView title;

    private ArrayList<String> listCurrencies = new ArrayList<>();
    private ArrayList<Double> listRates = new ArrayList<>();
    private String currentCurrency = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currency_detailed);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        title = findViewById(R.id.titleId);

        rate_text1 = findViewById(R.id.rate_text1);
        rate_text2 = findViewById(R.id.rate_text2);
        rate_text3 = findViewById(R.id.rate_text3);

        loading = findViewById(R.id.loading);

        setLoading(false);

        Intent i = getIntent();
        if (i.getStringExtra("currency") != null) {
            currentCurrency = i.getStringExtra("currency");
            if (title != null) {
                title.setText(currentCurrency);
            }
            setTitles(currentCurrency);
            getCurrencyRate(currentCurrency);
        }
    }

    public void getCurrencyRate(String currency) {
        setLoading(true);
        Retrofit.Builder builder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.exchangeratesapi.io/");

        Retrofit retrofit = builder.build();
        final Api repository = retrofit.create(Api.class);
        Call<CurrencyResponse> call = repository.getRates(currency);
        call.enqueue(new Callback<CurrencyResponse>() {
            @Override
            public void onResponse(Call<CurrencyResponse> call, Response<CurrencyResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getRates() != null) {
                        CurrencyResponse resp = response.body();
                        setRates(resp);
                    }
                }
            }
            @Override
            public void onFailure(Call<CurrencyResponse> call, Throwable t) {
                Log.d("Currency response: ", t.getMessage() + "");
            }
        });
    }

    public void setTitles(String currency) {
        if (!currency.equals("USD")) {
            listCurrencies.add("USD");
        }
        if (!currency.equals("EUR")) {
            listCurrencies.add("EUR");
        }
        if (!currency.equals("GBP")) {
            listCurrencies.add("GBP");
        }
        if (!currency.equals("RUB")) {
            listCurrencies.add("RUB");
        }

        txt1.setText(listCurrencies.get(0) + ":");
        txt2.setText(listCurrencies.get(1) + ":");
        txt3.setText(listCurrencies.get(2) + ":");

    }

    public void setRates(CurrencyResponse response) {
        if (response.getRates() != null) {
            Rates rates = response.getRates();
            if (!currentCurrency.equals("USD")) {
                listRates.add(rates.getUsd());
            }
            if (!currentCurrency.equals("EUR")) {
                listRates.add(rates.getEur());
            }
            if (!currentCurrency.equals("GBP")) {
                listRates.add(rates.getGbp());
            }
            if (!currentCurrency.equals("RUB")) {
                listRates.add(rates.getRub());
            }
            rate_text1.setText(listRates.get(0) + "");
            rate_text2.setText(listRates.get(1) + "");
            rate_text3.setText(listRates.get(2) + "");

            setLoading(false);
        }
    }


    public void setLoading(Boolean isLoading) {
        if (isLoading) {
            txt1.setVisibility(View.INVISIBLE);
            txt2.setVisibility(View.INVISIBLE);
            txt3.setVisibility(View.INVISIBLE);
            rate_text1.setVisibility(View.INVISIBLE);
            rate_text2.setVisibility(View.INVISIBLE);
            rate_text3.setVisibility(View.INVISIBLE);
            loading.setVisibility(View.VISIBLE);
        } else {
            txt1.setVisibility(View.VISIBLE);
            txt2.setVisibility(View.VISIBLE);
            txt3.setVisibility(View.VISIBLE);
            rate_text1.setVisibility(View.VISIBLE);
            rate_text2.setVisibility(View.VISIBLE);
            rate_text3.setVisibility(View.VISIBLE);
            loading.setVisibility(View.INVISIBLE);
        }
    }
}
