package com.ukom.intentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ukom.intentactivity.databinding.ActivityPenjualanBinding;

public class PenjualanActivity extends AppCompatActivity {
    ActivityPenjualanBinding bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityPenjualanBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        ambildata();
    }

    public void ambildata(){
        String ambil = getIntent().getStringExtra("isi");
        bind.tvbarang.setText(ambil);
    }
}