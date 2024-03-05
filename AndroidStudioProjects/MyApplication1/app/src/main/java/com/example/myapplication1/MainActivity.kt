package com.example.myapplication1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var button: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.buttonone) // Povezivanje člana s odgovarajućim elementom iz XML-a
        button.setOnClickListener(new View.OnClickListener() {
            override public void OnClick(View v) {

            }
        })
    }

}