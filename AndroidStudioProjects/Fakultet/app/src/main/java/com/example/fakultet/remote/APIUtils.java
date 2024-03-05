package com.example.fakultet.remote;

public class APIUtils {

    private APIUtils() {
    };

    public static final String API_URL = "http://192.168.1.7:83/api/";

    public static UserService getUserService() {
        return RetrofitClient.getClient(API_URL).create(UserService.class);
    }
}
