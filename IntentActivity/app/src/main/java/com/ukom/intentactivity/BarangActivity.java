package com.ukom.intentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.ukom.intentactivity.databinding.ActivityBarangBinding;

public class BarangActivity extends AppCompatActivity {
    ActivityBarangBinding bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityBarangBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        ambildata();
    }

    public void ambildata(){
        String ambil = getIntent().getStringExtra("isi");
        bind.tvbarang.setText(ambil);
    }
}