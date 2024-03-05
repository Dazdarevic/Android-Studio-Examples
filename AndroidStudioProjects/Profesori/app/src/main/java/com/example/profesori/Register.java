package com.example.profesori;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);
        TextView firstname = (TextView) findViewById(R.id.firstname);
        TextView lastname = (TextView) findViewById(R.id.lastname);
        Button register = (Button) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                String firstnameValue = firstname.getText().toString();
                String lastnameValue = lastname.getText().toString();

                Profesor profesor =
                        new Profesor(firstnameValue, lastnameValue, usernameValue, passwordValue,
                                "hej", "kako ste", "sta radite");
                Call<Profesor> call = api.registerProfesor(profesor);
                call.enqueue(new Callback<Profesor>() {
                    @Override
                    public void onResponse(Call<Profesor> call, Response<Profesor> response) {
                        if (response.isSuccessful()) {
                            // Profesor uspešno registrovan
                            Profesor registeredProfesor = response.body();
                            Intent intent = new Intent(Register.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            // Greška prilikom registracije profesora
                            int statusCode = response.code(); // Statusni kod
                            String errorMessage = response.message(); // Poruka o grešci

                            // Dodatne informacije o grešci iz response body-ja, ako su dostupne
                            String errorBody = response.errorBody().toString();

                            // Prikazivanje poruke o grešci
                            String message = "Greška prilikom registracije. Kod: " + statusCode + ", Poruka: " + errorMessage;
                            Toast.makeText(Register.this, message, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Profesor> call, Throwable t) {
                        // Greška prilikom komunikacije sa serverom
                        Toast.makeText(Register.this, "Greška prilikom komunikacije sa serverom", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}