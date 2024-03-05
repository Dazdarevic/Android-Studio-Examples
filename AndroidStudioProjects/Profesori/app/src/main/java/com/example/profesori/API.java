package com.example.profesori;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {
    String BASE_URL = "http://192.168.196.231:83/api/";

    @GET("Profesor")
    Call<List<Profesor>> getProfesor();

    @POST("Profesor/add")
    Call<Profesor> registerProfesor(@Body Profesor profesor);

    @GET("Profesor/login")
    Call<Profesor> loginProfesor(@Query("username") String username, @Query("password") String password);

    @DELETE("Profesor/delete/{id}")
    Call<Void> deleteProfesor(@Path("id") int id);
}
