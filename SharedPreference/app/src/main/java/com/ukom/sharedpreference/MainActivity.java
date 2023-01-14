package com.ukom.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ukom.sharedpreference.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    TextView ebarang, estok;
    ActivityMainBinding bind;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        load();
    }

    public void load(){
        ebarang = bind.etbarang;
        estok = bind.etstok;

        sharedPreferences = getSharedPreferences("barang"/*nama spnya*/, MODE_PRIVATE/*yg bisa pake hny di apk yg kita buat*/);
    }

    //ISI SHAREDPREFNYA
    public void isishareppreferences(String barang, float stok){
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("barang", barang);//KEY,VALUE
        editor.putFloat("stok", stok);
        editor.apply();
    }

    public void btnsimpan(View view) {
        String barang = ebarang.getText().toString();
        float stok = Float.parseFloat(estok.getText().toString());

        if(barang.isEmpty() || stok == 0.0){
            pesan("Data tak boleh kosong");

        } else{
            isishareppreferences(barang, stok);
            pesan("Data sudah disimpan");
        }

        //KOSONGKAN FORM
        ebarang.setText("");
        estok.setText("");
    }

    public void btntampil(View view) {
        String spbarang = sharedPreferences.getString("barang","");//defvalue klo data yg diminta gk ada
        float spstok = sharedPreferences.getFloat("stok", 0);

        ebarang.setText(spbarang);
        estok.setText(spstok+"");//menampilkan float ke form
    }

    public void pesan(String isi){
        Toast.makeText(this, isi, Toast.LENGTH_SHORT).show();
    }

    /*NOTE :
    * -- SP ini spt session
    * -- meski apknya ditutup datanya akan ttp ada & tak hilang
    * -- kebanyakan dipake buat nyimpen seting2 pada aplikai, spy tak perlu ngeset terus*/
}