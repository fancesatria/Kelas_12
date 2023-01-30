/*NOTE :
* --DEBUGGING = Pencarian error/bug
* --kalo apknya force close, bisa cari erornya di menu logcat/run/debug*/

package com.ukom.sqlitedatabaseandroid;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ukom.sqlitedatabase.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding bind;
    Database db;//memanggil class Database

    EditText barang, stok, harga;
    TextView pilihan;

    List<BarangModel> barangModelList = new ArrayList<BarangModel>();//declare modelnya
    BarangAdapter adapter;
    String idbarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        load();
        insertdata();
        selectdata();
    }

    public void load(){
        db = new Database(MainActivity.this);
        //MANGGIL FUNC BUAT TABEL DR CLASS DATABASE
        db.buatTabel();

        barang = bind.etbarang;
        stok = bind.etstok;
        harga = bind.etharga;
        pilihan = bind.tvpilihan;

        bind.rcvbarang.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        bind.rcvbarang.setHasFixedSize(true);//Biar rcvnya stay fixed

    }

    public void insertdata(){
        bind.btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ambilbarang = barang.getText().toString();
                String ambilstok = stok.getText().toString();
                String ambilharga = harga.getText().toString();
                String ambilpilian = pilihan.getText().toString();

                //VALIDATION
                if(ambilbarang.isEmpty() || ambilstok.isEmpty() || ambilharga.isEmpty()){
                    pesan("Data harus diisi semua");

                } else {
                    if(ambilpilian.equals("Insert")){
                        String sql = "insert into tblbarang (barang, stok, harga) values('"+ambilbarang+"','"+ambilstok+"','"+ambilharga+"')";

                        //biar klo ada trouble bisa ketahuan
                        //pesan(sql);
                        if(db.runSql(sql)){
                            pesan("Insert berhasil");
                            selectdata();
                        } else {
                            pesan("Insert gagal");
                        }
                    } else {
                        String sql = "update tblbarang set barang='"+ambilbarang+"', stok="+ambilstok+", harga="+ambilharga+" where id="+idbarang+";";
                        if(db.runSql(sql)){
                            pesan("Update berhasil");
                            selectdata();
                        } else {
                            pesan("Update gagal");
                        }

                    }
                }

                barang.setText("");
                stok.setText("");
                harga.setText("");
                pilihan.setText("Insert");
            }
        });
    }

    public void pesan(String teks){
        Toast.makeText(MainActivity.this, teks, Toast.LENGTH_SHORT).show();
    }

    public void selectdata(){
        String sql = "select * from tblbarang order by barang asc";
        Cursor cursor = db.select(sql);
        //pesan(cursor.getCount()+"");//karen int mau ditampilin, makanya oakai petik

        //kalo mau ditampilin ke recyclerview, maka perlu model
        barangModelList.clear();//datanya di clearkan dulu
        if(cursor.getCount() > 0){//klo jml data lbh dr nol
            //krn datanya byk di loop aja
            while (cursor.moveToNext()){//movetonext == memasukkn data 1 by 1
                String id = cursor.getString(cursor.getColumnIndexOrThrow("id"));//pke getthrow krn kalo getindex biasa bisa ngereturn hasil -1
                String barang = cursor.getString(cursor.getColumnIndexOrThrow("barang"));
                String stok = cursor.getString(cursor.getColumnIndexOrThrow("stok"));
                String harga = cursor.getString(cursor.getColumnIndexOrThrow("harga"));

                //setelah data akan dimskkn ke model
                barangModelList.add(new BarangModel(id, barang, stok, harga));
            }

            //Masukkan ke adapter
            adapter = new BarangAdapter(MainActivity.this, barangModelList);
            bind.rcvbarang.setAdapter(adapter);
            adapter.notifyDataSetChanged();//biar apknya bisa ngenali perubagan

        } else {
            pesan("Tak ada data untuk ditampilkan");
        }
    }

    public void deletedata(String id){
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Konfirmasi");
        alert.setMessage("Yakin ingin menghapus data ini?");
        alert.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                idbarang = id;
                String sql = "delete from tblbarang where id="+idbarang+"";

                if(db.runSql(sql)){
                    pesan("Data sudah dihapus");
                    selectdata();
                }else {
                    pesan("Data tak bisa dihapus");
                }
            }
        }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).show();
    }

    public void selectwhere(String id){
        idbarang = id;
        String sql = "select * from tblbarang where id="+idbarang+"";

        //NOTE:semua select pake function cursor
        Cursor cursor = db.select(sql);
        cursor.moveToNext();//utk menampilkan data

        barang.setText(cursor.getString(cursor.getColumnIndexOrThrow("barang")));
        stok.setText(cursor.getString(cursor.getColumnIndexOrThrow("stok")));
        harga.setText(cursor.getString(cursor.getColumnIndexOrThrow("harga")));
        pilihan.setText("Update");
    }

}