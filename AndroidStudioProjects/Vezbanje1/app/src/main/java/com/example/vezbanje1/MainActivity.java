package com.example.vezbanje1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CustomDrawableView customDrawableView;
//    ListView listview;
//    String[] listItems = {"Belkisa", "Azra", "Mama"};
//    ArrayAdapter<String> adapter;
//    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        customDrawableView = new CustomDrawableView(this);
        setContentView(customDrawableView);

//        listview = findViewById(R.id.list);
//        adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.listText, listItems);
//        listview.setAdapter(adapter);
//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String value = adapter.getItem(position);
//                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        button = findViewById(R.id.buttonone);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(getApplicationContext(), "Selam alejkum", Toast.LENGTH_SHORT).show();
//                 Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
//                 startActivity(intent);
//            }
//        });
    }
}