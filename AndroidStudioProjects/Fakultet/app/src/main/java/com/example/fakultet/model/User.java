package com.example.fakultet.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("userName")
    @Expose
    private String userName;

    public User() {

    }

    public User(int id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return userName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String userName) {
        this.userName = userName;
    }
}
