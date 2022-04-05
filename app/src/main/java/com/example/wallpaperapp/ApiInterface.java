package com.example.wallpaperapp;

import com.example.wallpaperapp.Modals.wallpapermodal;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiInterface {

    public static final String API = "563492ad6f9170000100000126c8255946ca419fad3c8fc1fdfe9ec5";

    @Headers("Authorization: 563492ad6f9170000100000126c8255946ca419fad3c8fc1fdfe9ec5")
    @GET("curated")
    Call<wallpapermodal> getWallpaper(
            @Query("per_page") String per_page
    );

    @Headers("Authorization: 563492ad6f9170000100000126c8255946ca419fad3c8fc1fdfe9ec5")
    @GET("search")
    Call<wallpapermodal> getSearchWallpaper(
            @Query("query") String query,
            @Query("per_page") String per_page
    );
}
