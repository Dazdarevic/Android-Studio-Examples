package com.example.auto_delovi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Detalji extends AppCompatActivity {

    TextView naziv;
    TextView tvMarka;
    TextView tvCena;
    TextView tvDetalji;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalji);

        Intent intent = getIntent();
        AutoDeo prenetiObjekat = (AutoDeo) intent.getSerializableExtra("kliknutiObjekat");

         naziv = (TextView) findViewById(R.id.tvNaziv);
         tvMarka = (TextView) findViewById(R.id.tvMarka);
         tvCena = (TextView) findViewById(R.id.tvCena);
         tvDetalji = (TextView) findViewById(R.id.tvDetalji);

        if (prenetiObjekat != null) {
            naziv.setText(prenetiObjekat.getNaziv());
            tvMarka.setText(prenetiObjekat.getMarka_automobila());
            tvCena.setText(prenetiObjekat.getCena());
            tvDetalji.setText(prenetiObjekat.getDetalji());
        }
    }
}