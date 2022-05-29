package com.shayekh.swosti.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api_Response_Member {

    private static Retrofit retrofit;
      private static String BASE_URL = "https://swosti.net/";
    public static Retrofit getUser() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
}
