package com.example.fakultet.remote;

import com.example.fakultet.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {

    //naziv endpointa
    @GET("User/")
    Call<List<User>> getUsers();

    @POST("User/add")
    Call<User> addUser(@Body User user);

    @PUT("update/{id}")
    Call<User> updateUser(@Path("id") int id, @Body User user);

    @DELETE("delete/{id}")
    Call<User> deleteUser(@Path("id") int id);
}
