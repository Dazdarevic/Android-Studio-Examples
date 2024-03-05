package com.example.sendobjecttoanotheractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        String Link1 =extras.getString("Link1");
        String Link2 =extras.getString("Link2");
        String Link3 =extras.getString("Link3");
        String Link4 =extras.getString("Link4");
        String Link5 =extras.getString("Link5");
        String Link6 =extras.getString("Link6");
        String Link7 =extras.getString("Link7");
        String Link8 =extras.getString("Link8");
//        String Link9 =extras.getString("Link9");

        TextView tv1 = (TextView)  findViewById(R.id.fullName);
        tv1.setText(tv1.getText() + " " + Link1);
//        TextView tv2 = (TextView)  findViewById(R.id.genderTV);
//        tv2.setText(tv2.getText() + " " + Link9);
        TextView tv3 = (TextView)  findViewById(R.id.currentWeightTV);
        tv3.setText(tv3.getText() + " " + Link2);
        TextView tv4 = (TextView)  findViewById(R.id.heightTV);
        tv4.setText(tv4.getText() + " " + Link3);
        TextView tv5 = (TextView)  findViewById(R.id.GoalWeightTV);
        tv5.setText(tv5.getText() + " " + Link4);
        TextView tv6 = (TextView)  findViewById(R.id.ageTV);
        tv6.setText(tv6.getText() + " " + Link5);
        TextView tv7 = (TextView)  findViewById(R.id.phoneTV);
        tv7.setText(tv7.getText() + " " + Link6);
        TextView tv8 = (TextView)  findViewById(R.id.adressTV);
        tv8.setText(tv8.getText() + " " + Link7);
        TextView tv9 = (TextView)  findViewById(R.id.checkedTV);
        tv9.setText(tv9.getText() + " " + Link8);
//        Intent intent = this.getIntent();
//        User user = (User) intent.getSerializableExtra("UserInfo");
//
//        TextView tv1 = (TextView)  findViewById(R.id.fullName);
//        tv1.setText(tv1.getText() + " " + user.fullName);
////        TextView tv2 = (TextView)  findViewById(R.id.genderTV);
////        tv2.setText(tv2.getText() + " " + user.gender);
//        TextView tv3 = (TextView)  findViewById(R.id.currentWeightTV);
//        tv3.setText(tv3.getText() + " " + user.currentWeight);
//        TextView tv4 = (TextView)  findViewById(R.id.heightTV);
//        tv4.setText(tv4.getText() + " " + user.height);
//        TextView tv5 = (TextView)  findViewById(R.id.GoalWeightTV);
//        tv5.setText(tv5.getText() + " " + user.goalWeight);
//        TextView tv6 = (TextView)  findViewById(R.id.ageTV);
//        tv6.setText(tv6.getText() + " " + user.age);
//        TextView tv7 = (TextView)  findViewById(R.id.phoneTV);
//        tv7.setText(tv7.getText() + " " + user.phone);
//        TextView tv8 = (TextView)  findViewById(R.id.adressTV);
//        tv8.setText(tv8.getText() + " " + user.adress);
//        TextView tv9 = (TextView)  findViewById(R.id.checkedTV);
//        tv9.setText(tv9.getText() + " " + user.terms);
    }
}