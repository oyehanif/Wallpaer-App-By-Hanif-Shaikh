package com.example.wallpaperapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {

        public static String  BASE_URL = "https://api.pexels.com/v1/";

        public static Retrofit retrofit = null;


        public static ApiInterface getApiInterface(){
                if (retrofit == null){
                        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
                }
                return retrofit.create(ApiInterface.class);
        }
}
