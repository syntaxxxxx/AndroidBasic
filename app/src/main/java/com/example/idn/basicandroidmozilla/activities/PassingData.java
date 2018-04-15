package com.example.idn.basicandroidmozilla.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.idn.basicandroidmozilla.R;

public class PassingData extends AppCompatActivity {

    //TODO 1 buat variable untuk nampung data
    public static final String EXTRA_NAMA = "extra_nama";
    public static final String EXTRA_UMUR = "extra_umur";

    private TextView tvNerimaData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_data);

        //TODO 2 hubungkan
        tvNerimaData = findViewById(R.id.tv_nerima);

        // buat instance intent dulu
        Intent i = getIntent();

        //TODO 3 terima data sesuai type data nya
        String nama = i.getStringExtra(EXTRA_NAMA);
        int umur = i.getIntExtra(EXTRA_UMUR, 0);
        String tampilin = "Nama : " + nama + "\n Umur : " + umur + "Tahun";
        tvNerimaData.setText(tampilin);

    }
}
