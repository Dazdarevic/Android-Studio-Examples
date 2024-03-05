package com.example.sendobjecttoanotheractivity;


public class User implements java.io.Serializable{

    String fullName;
    String gender;
    String currentWeight;
    String goalWeight;
    String height;
    String age;
    String phone;
    String adress;
    Boolean terms;

    public User(String fullName, String currentWeight, String goalWeight, String height,
                String age, String phone, String address, Boolean terms) {
        this.fullName = fullName;
//        this.gender = gender;
        this.currentWeight = currentWeight;
        this.goalWeight = goalWeight;
        this.height = height;
        this.age = age;
        this.phone = phone;
        this.adress = address;
        this.terms = terms;
    }
}
