package com.ukom.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.ukom.datepicker.databinding.ActivityMainBinding;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        load();
    }

    public void load(){
        bind.ptTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();//buat var type calendar
                int tgl = cal.get(Calendar.DAY_OF_MONTH);//ambil tanggal
                int bln = cal.get(Calendar.MONTH);//ambil bulan
                int thn = cal.get(Calendar.YEAR);//ambil tahun

                //panggil datetime picker
                DatePickerDialog dp = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int thn, int bln, int tgl) {
                        bind.ptTanggal.setText(tgl+"-"+(bln+1)+"-"+thn);
                    }
                }, thn, bln, tgl);

                dp.show();//menampilkan kalendernya
            }
        });
    }
}