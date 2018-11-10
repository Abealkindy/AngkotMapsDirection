package com.rosinante.mapsdirection.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private static Retrofit setInitRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/maps/api/directions/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getInitRetrofit() {
        return setInitRetrofit().create(ApiService.class);
    }
}
