package com.example.paw_some.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface{
    static final String BASE_URL = "https://api.thedogapi.com/v1/";
    @GET("breeds")
    Call<List<DogData>> getDogData();

}
