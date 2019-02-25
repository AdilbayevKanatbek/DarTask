package com.example.kanatbek.midtask.Repository;

import com.example.kanatbek.midtask.models.CurrencyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("latest?")
    Call<CurrencyResponse> getRates(@Query("base") String base);
}