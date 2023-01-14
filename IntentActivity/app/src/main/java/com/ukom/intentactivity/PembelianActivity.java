package com.ukom.intentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ukom.intentactivity.databinding.ActivityPembelianBinding;

public class PembelianActivity extends AppCompatActivity {
    ActivityPembelianBinding bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityPembelianBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        ambildata();
    }

    public void ambildata(){
        String ambil = getIntent().getStringExtra("isi");
        bind.tvbarang.setText(ambil);
    }
}