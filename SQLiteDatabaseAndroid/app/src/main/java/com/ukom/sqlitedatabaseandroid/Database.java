package com.ukom.sqlitedatabaseandroid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

//    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }
//
//    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
//        super(context, name, factory, version, errorHandler);
//    }


    //MEMANGGIL DATABASE
    private static final String DATABASE_NAME = "dbtoko";
    private static final int DATABASE_VERSION = 1; //setiap ada perubahan versi ini harus diganti


    SQLiteDatabase db;// model variabel buat database

    //yang dipakai hanya satu ini
    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = this.getWritableDatabase();//ini spt hak akses?
    }

    //FUNC UTK SQL COMMAND; BOOLEAN KRN OUTPUTNYA BAKAL TRUE OR FALSE
    boolean runSql(String sql){
        try {
            db.execSQL(sql);
            return true;
        } catch(Exception e){//SUPAYA GA FORCE CLOSE
            return false;
        }
    }

    public void buatTabel(){
        String tblbarang = "CREATE TABLE \"tblbarang\" (\n" +
                "\t\"id\"\tINTEGER,\n" +
                "\t\"barang\"\tTEXT,\n" +
                "\t\"stok\"\tREAL,\n" +
                "\t\"harga\"\tREAL,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ");";
        runSql(tblbarang);
    }

    //pake class cursor
    Cursor select(String sql){
        try{
            return db.rawQuery(sql, null);

        } catch (Exception e){
            return null;
        }
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
