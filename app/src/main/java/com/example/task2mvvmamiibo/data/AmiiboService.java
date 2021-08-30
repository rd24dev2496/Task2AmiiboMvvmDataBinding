package com.example.task2mvvmamiibo.data;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface AmiiboService {
    @GET
    Observable<AmiiboResponse> fetchamiibo(@Url String url);

}
