package com.example.retrofitsetup.retrofit;

import com.example.retrofitsetup.MainModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {
    @GET("data.php")
    Call<MainModel> getData();
}
