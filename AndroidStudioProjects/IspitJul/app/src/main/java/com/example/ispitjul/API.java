package com.example.ispitjul;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    String BASE_URL = "http://192.168.196.231:83/api/";
    @GET("Profesor/login")
    Call<Profesor> loginProfesor(@Query("username") String username, @Query("password") String password);

}
