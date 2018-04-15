package com.example.idn.basicandroidmozilla.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.idn.basicandroidmozilla.R;
import com.example.idn.basicandroidmozilla.model.Orang;

public class PassingObject extends AppCompatActivity {

    //TODO 2 buat variable untuk nampung data yang dikirim
    public static final String EXTRA_ORANG = "extra_orang";

    // deklarasi widget untuk digunakan
    private TextView tvNerimaObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_object);

        //TODO 3 hubungkan widget TextView
        tvNerimaObj = findViewById(R.id.tv_nerima_obj);

        //TODO 4 terima datanya
        Orang orang = getIntent().getParcelableExtra(EXTRA_ORANG);
        String nampilinObj =
                "Nama : " + orang.getNama()
                + "\n Umur : " + orang.getUmur()
                + "\n Alamat : " + orang.getAlamat()
                + "\n Asal : " + orang.getAsal();

        // nampilin ke view
        tvNerimaObj.setText(nampilinObj);
    }
}
