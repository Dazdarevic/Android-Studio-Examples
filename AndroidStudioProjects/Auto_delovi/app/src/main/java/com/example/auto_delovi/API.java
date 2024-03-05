package com.example.auto_delovi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    String BASE_URL = "http://192.168.196.231:83/api/";

    @GET("AutoDeo")
    Call<List<AutoDeo>> getAutoDelovi();
}
