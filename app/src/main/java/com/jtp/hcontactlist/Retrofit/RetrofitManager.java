package com.jtp.hcontactlist.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    public static RetrofitAPI getRetrofitUniv(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://universities.hipolabs.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(RetrofitAPI.class);
    }

    public static RetrofitAPI getRetrofitRd(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://dog.ceo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(RetrofitAPI.class);
    }


}
