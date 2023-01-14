package com.ukom.intentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.ukom.intentactivity.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding bind;
    EditText enama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        load();
    }

    public void load(){
        enama = bind.input;
        bind.btnbarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = enama.getText().toString();
                Intent i = new Intent(MainActivity.this, BarangActivity.class);
                i.putExtra("isi",nama);
                startActivity(i);
            }
        });

        bind.btnpembelian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = enama.getText().toString();
                Intent i = new Intent(MainActivity.this, PembelianActivity.class);
                i.putExtra("isi", nama);
                startActivity(i);
            }
        });

        bind.btnpenjualan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = enama.getText().toString();
                Intent i = new Intent(MainActivity.this, PenjualanActivity.class);
                i.putExtra("isi",nama);
                startActivity(i);
            }
        });
    }
}