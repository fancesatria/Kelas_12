package com.ukom.recyclerview_cv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.ukom.recyclerview_cv.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding bind;
    List<Siswa> siswaList; //mengisi data model
    RecyclerView rcv;
    SiswaAdapter adapter;//memanggil adapter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        load();
        isidata();
        tambahdata();
    }

    public void load(){
        rcv = bind.rcvsiswa;
        rcv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    //buyat isi data
    public void isidata(){
        siswaList = new ArrayList<Siswa>();
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));//ini nambahin data scr manual
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));
        siswaList.add(new Siswa("Johnny Depp", "JL. Aloha Timur 4A"));

        adapter = new SiswaAdapter(MainActivity.this, siswaList);//masukin data ke adapter
        rcv.setAdapter(adapter);
    }

    //TAMBAH DATA
    public void tambahdata(){
        bind.btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //memasukkan data
                siswaList.add(new Siswa("KING ARTHUR", "ENGLAND"));
                //data sebenarnya udh masuk tp blm tampil
                //tampilinnya pake adapter + notify data set changed(merefresh)
                adapter.notifyDataSetChanged();
            }
        });
    }
}