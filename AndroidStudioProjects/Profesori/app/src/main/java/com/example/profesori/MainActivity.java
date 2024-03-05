package com.example.profesori;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);
        TextView username = (TextView) findViewById(R.id.usernameTxt);
        TextView password = (TextView) findViewById(R.id.passwordTxt);
        Button login = (Button) findViewById(R.id.login);
//        ListView listView = findViewById(R.id.listView);


//        Call<List<Profesor>> call = api.getProfesor();
//        call.enqueue(new Callback<List<Profesor>>() {
//            @Override
//            public void onResponse(Call<List<Profesor>> call, Response<List<Profesor>> response) {
//                List<Profesor> autodelovi = response.body();
//
//
//                String[] nazivDela = new String[autodelovi.size()];
//
//                for(int i = 0; i < autodelovi.size(); i++) {
//                    nazivDela[i] = autodelovi.get(i).getIme();
//                }
//
//                adapter = new ArrayAdapter<String>(
//                        getApplicationContext(),
//                        android.R.layout.simple_list_item_2,
//                        nazivDela
//                );
//
//                listView.setAdapter(adapter);
//
//                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        Intent intent = new Intent(MainActivity.this, Register.class);
//                        Profesor kliknutiObjekat = autodelovi.get(position);
//
//                        intent.putExtra("kliknutiObjekat", kliknutiObjekat);
//                        startActivity(intent);
//                    }
//                });
//
////                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
////                    @Override
////                    public boolean onQueryTextSubmit(String query) {
////                        return false;
////                    }
////
////                    @Override
////                    public boolean onQueryTextChange(String newText) {
////                        adapter.getFilter().filter(newText);
////                        return false;
////                    }
////                });
//            }
//
//
//            @Override
//            public void onFailure(Call<List<Profesor>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Profesor> call =
                        api.loginProfesor(username.getText().toString(),
                        password.getText().toString());
                call.enqueue(new Callback<Profesor>() {
                    @Override
                    public void onResponse(Call<Profesor> call, Response<Profesor> response) {
                        if (response.isSuccessful()) {
                            // Prijavljivanje je uspešno
                            Profesor profesor = response.body();
                            Intent intent = new Intent(MainActivity.this, Predmeti.class);
                            startActivity(intent);
                        } else {
                            // Prijavljivanje nije uspelo
                            Toast.makeText(MainActivity.this,
                                    "Pogrešno korisničko ime ili lozinka",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Profesor> call, Throwable t) {
                        // Greška pri izvršavanju zahteva
                        Toast.makeText(MainActivity.this, "Greška pri izvršavanju zahteva", Toast.LENGTH_SHORT).show();
                    }
                });


                Button registerScreen = (Button) findViewById(R.id.registerScreen);
                registerScreen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, Register.class);
                        startActivity(intent);
                    }
                });

//                Button lista = (Button) findViewById(R.id.lista);
//                lista.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(MainActivity.this, Predmeti.class);
//                        startActivity(intent);
//                    }
//                });
            }
        });

    }
}