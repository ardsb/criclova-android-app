package com.example.criclowa.Services;

import com.example.criclowa.Model.SportNewsList;
import com.example.criclowa.Model.SportVideosResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("top-headlines")
    Call<SportNewsList> getMatchNews(@Query("country") String country, @Query("category")
            String cat, @Query("apiKey") String name);

    @GET("search")
    Call<SportVideosResponse> getMatchVideos(@Query("key") String key, @Query("channelId")
            String chId, @Query("part") String part);

}
