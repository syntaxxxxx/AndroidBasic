package com.example.idn.basicandroidmozilla.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.idn.basicandroidmozilla.R;

public class GettingResult extends AppCompatActivity {

    //TODO 1 code uniqe untuk nampung callback data
    public static final String EXTRA_DATA = "extra_data";

    private Button btnCallBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_result);

        // hubungkan
        btnCallBack = findViewById(R.id.btn_callback);

        // event click aksi dari button
        btnCallBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // buat object intent untuk wadah hasil
                Intent data = new Intent();

                // kirim data untuk ditampilkan ke view utama
                data.putExtra(EXTRA_DATA, "Hallo Ini Callback");

                // set hasilnya
                setResult(Activity.RESULT_OK, data);

                // tutup activity saat ini
                // back ke activity utama
                finish();

            }
        });
    }
}
