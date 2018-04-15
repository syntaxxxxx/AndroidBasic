package com.example.idn.basicandroidmozilla;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.idn.basicandroidmozilla.activities.GettingResult;
import com.example.idn.basicandroidmozilla.activities.Layouting;
import com.example.idn.basicandroidmozilla.activities.PassingData;
import com.example.idn.basicandroidmozilla.activities.PassingObject;
import com.example.idn.basicandroidmozilla.model.Orang;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //TODO 1 deklarasi widget secara global

    // untuk intent explicit
    private Button btnLayout, btnData, btnObj, btnResult;

    // untuk intent implicit
    private Button btnCall, btnEmail;

    // variable uniqe untuk minta data hasil callback
    private static final int REQUEST_DATA = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //TODO 2 casting atau hubungin
        btnLayout = findViewById(R.id.btn_layout);
        btnData = findViewById(R.id.btn_pass_data);
        btnObj = findViewById(R.id.btn_pass_obj);
        btnResult = findViewById(R.id.btn_result);

        // button implicit
        btnCall = findViewById(R.id.btn_call);
        btnEmail = findViewById(R.id.btn_email);

        // event click
        btnLayout.setOnClickListener(this);
        btnData.setOnClickListener(this);
        btnObj.setOnClickListener(this);
        btnResult.setOnClickListener(this);

        //event clik implicit
        btnCall.setOnClickListener(this);
        btnEmail.setOnClickListener(this);

    }

    //TODO 3 melakukan aksi pada masing" button
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_layout:
                startActivity(new Intent(this, Layouting.class));
                break;

            case R.id.btn_pass_data:

                // intent dengan kelas asal dan tujuan
                Intent i = new Intent(this, PassingData.class);

                // kirim data dengan variable yang ada di PassingData.java
                i.putExtra(PassingData.EXTRA_NAMA, "Fiqri Hafzain Islami");
                i.putExtra(PassingData.EXTRA_UMUR, 19);
                startActivity(i);
                break;

            case R.id.btn_pass_obj:

                // buat instance dari class pojo
                Orang orang = new Orang();

                // set untuk dikirm, object dari pojo
                // akan mewakili data yang dikirim
                orang.setNama("Fiqri Hafzain Islami");
                orang.setUmur(19);
                orang.setAlamat("Slipi, Jakarta Barat");
                orang.setAsal("Lampung, Indonesia");

                // kirim dengan intent
                Intent ii = new Intent(this, PassingObject.class);

                // kirim data menggunakan method putExtra()
                ii.putExtra(PassingObject.EXTRA_ORANG, orang);
                startActivity(ii);
                break;

            case R.id.btn_call:

                // intent implicit telfon
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:089614191467"));
                startActivity(intent);
                break;

            case R.id.btn_email:

                // intent implicit email
                Intent email = new Intent(Intent.ACTION_SENDTO,
                        Uri.fromParts("mailto",
                                "fiqrihafzainislami@gmail.com",
                                null));

                // subject email
                email.putExtra(Intent.EXTRA_SUBJECT, "Ini Subjcet");
                email.putExtra(Intent.EXTRA_TEXT, "Ini pesan");

                // cek jika device ada email client
                if (email.resolveActivity(getPackageManager()) != null) {

                    // pilih email client di device
                    startActivity(Intent.createChooser(
                            email, "Pilih Email Client"));
                } else {

                }
                break;

            case R.id.btn_result:

                // intent dulu
                Intent callback = new Intent(this, GettingResult.class);
                startActivityForResult(callback, REQUEST_DATA);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // cek requestCode nya cocok apa enggak
        // denga apa yang telah kita buat
        if (requestCode == REQUEST_DATA) {

            // cek hasil sama atau enggak
            if (resultCode == RESULT_OK) {

                // get data callback nya
                String result = data.getStringExtra(GettingResult.EXTRA_DATA);

                // nampilin toast
                Toast.makeText(this, "Result : "
                        + result, Toast.LENGTH_SHORT).show();

            } else {
                // jika gagal nothing to do
            }
        }
    }
}
