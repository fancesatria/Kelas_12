package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.kalkulator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding bind;
    //dibuat global
    EditText a,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        operasi();
    }

    public void operasi(){
        //gabisa langsungdiambil teknya krn ini cuma declare edittext
        EditText a = bind.bil1;
        EditText b = bind.bil2;

        bind.tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double b1 = Double.parseDouble(a.getText().toString());
                double b2 = Double.parseDouble(b.getText().toString());
                double hasil = b1+b2;
                bind.hasil.setText(String.valueOf(hasil));
            }
        });

        bind.kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double b1 = Double.parseDouble(a.getText().toString());
                double b2 = Double.parseDouble(b.getText().toString());
                double hasil = b1-b2;
                bind.hasil.setText(String.valueOf(hasil));
            }
        });

        bind.kali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double b1 = Double.parseDouble(a.getText().toString());
                double b2 = Double.parseDouble(b.getText().toString());
                double hasil = b1*b2;
                bind.hasil.setText(String.valueOf(hasil));
            }
        });

        bind.bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double b1 = Double.parseDouble(a.getText().toString());
                double b2 = Double.parseDouble(b.getText().toString());
                double hasil = b1/b2;
                bind.hasil.setText(String.valueOf(hasil));
            }
        });

        bind.reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bind.hasil.setText("0");
            }
        });
    }

}