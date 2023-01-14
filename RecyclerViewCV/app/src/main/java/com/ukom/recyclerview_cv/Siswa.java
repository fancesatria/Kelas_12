package com.ukom.recyclerview_cv;

public class Siswa {
    //ini adalah file MODEL:menghubunkan db ke adapter

    //buat variabel yg dibutuhin
    private String nama;
    private String alamat;


    //buat coonstructor biar auto request nilai

    public Siswa(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
