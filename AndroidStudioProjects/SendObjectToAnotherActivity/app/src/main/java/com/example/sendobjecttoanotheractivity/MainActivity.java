package com.example.sendobjecttoanotheractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String gender="";
    String fullName="";
    String currentWeight="";
    String goalWeight = "";
    String age = "";
    String phone = "";
    String address = "";
    String height = "";
    Boolean terms=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText fullnameEdit = (EditText) findViewById(R.id.name);
        CheckBox termsEdit = (CheckBox) findViewById(R.id.terms);
        EditText currentWeightEdit = (EditText) findViewById(R.id.current_weight);
        EditText goalWeightEdit = (EditText) findViewById(R.id.goal_weight);
        EditText heightEdit = (EditText) findViewById(R.id.height);
        EditText phoneEdit = (EditText) findViewById(R.id.phone);
        EditText ageEdit = (EditText) findViewById(R.id.age);
        EditText addressEdit = (EditText) findViewById(R.id.address);

        View submit = (Button) findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullName = fullnameEdit.getText().toString();
                terms = termsEdit.isChecked();
                currentWeight = currentWeightEdit.getText().toString();
                goalWeight = goalWeightEdit.getText().toString();
                height = heightEdit.getText().toString();
                phone = phoneEdit.getText().toString();
                age = ageEdit.getText().toString();
                address = addressEdit.getText().toString();
//                User user = new User(
//                        fullName,
////                        gender,
//                        currentWeight,
//                        goalWeight,
//                        height,
//                        age,
//                        phone,
//                        address,
//                        terms
//                );

                Intent sintent = new Intent(MainActivity.this, Second.class);
                Bundle mBundle = new Bundle();
                mBundle.putString("Link1", fullName);
                mBundle.putString("Link2", currentWeight);
                mBundle.putString("Link3", goalWeight);
                mBundle.putString("Link4", age);
                mBundle.putString("Link5", phone);
                mBundle.putString("Link6", address);
                mBundle.putString("Link7", height);
                mBundle.putString("Link8", String.valueOf(terms));
//                mBundle.putString("Link9", gender);

//                prosledjivanje podataka putem intenta
//                sintent.putExtra("UserInfo", user);

                sintent.putExtras(mBundle); //slanje podataka putem primitiva
                startActivity(sintent); //slanje podataka direktno
            }
        });
    }
}