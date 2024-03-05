package com.example.auto_delovi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;import android.widget.SearchView;


public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        SearchView searchView = (SearchView) findViewById(R.id.searchView);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);

        Call<List<AutoDeo>> call = api.getAutoDelovi();
        call.enqueue(new Callback<List<AutoDeo>>() {
            @Override
            public void onResponse(Call<List<AutoDeo>> call, Response<List<AutoDeo>> response) {
                List<AutoDeo> autodelovi = response.body();


                String[] nazivDela = new String[autodelovi.size()];

                for(int i = 0; i < autodelovi.size(); i++) {
                    nazivDela[i] = autodelovi.get(i).getNaziv();
                }

                adapter = new ArrayAdapter<String>(
                        getApplicationContext(),
                        android.R.layout.simple_list_item_1,
                        nazivDela
                );
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(MainActivity.this, Detalji.class);
                        AutoDeo kliknutiObjekat = autodelovi.get(position);

                        intent.putExtra("kliknutiObjekat", kliknutiObjekat);
                        startActivity(intent);
                    }
                });

//                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//                    @Override
//                    public boolean onQueryTextSubmit(String query) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onQueryTextChange(String newText) {
//                        adapter.getFilter().filter(newText);
//                        return false;
//                    }
//                });
            }


            @Override
            public void onFailure(Call<List<AutoDeo>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}