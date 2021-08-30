package com.example.task2mvvmamiibo.data;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AmiiboFactory {
    private static String BASE_URL = "https://amiiboapi.com/api/amiibo/";
    public final static String RANDOM_USER_URL = "https://amiiboapi.com/api/amiibo/?name=value";

    public static AmiiboService create() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(com.example.task2mvvmamiibo.data.AmiiboService.class);
    }
}

