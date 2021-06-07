package com.example.criclowa.Services;

import com.example.criclowa.Model.Match;
import com.example.criclowa.Model.MatchList;
import com.example.criclowa.Model.SportNews;
import com.example.criclowa.Model.SportNewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("api/cricket")
    Call<MatchList> getMatchScore(@Query("apikey") String name);

    @GET("top-headlines")
    Call<SportNewsResponse> getMatchNews(@Query("country") String country,@Query("category") String cat,@Query("apiKey") String name);


}
