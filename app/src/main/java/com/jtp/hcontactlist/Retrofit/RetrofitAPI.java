package com.jtp.hcontactlist.Retrofit;

import com.jtp.hcontactlist.RefreshTime.Refresh.Jokess.Model.DogBredResponseModel;
import com.jtp.hcontactlist.model.University;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {

        //University List
        @GET("search?country=India")
        Call<List<University>> getalllist();

        //DogBreed
    @GET("api/breeds/image/random")
    Call<DogBredResponseModel> getdetail();
}
