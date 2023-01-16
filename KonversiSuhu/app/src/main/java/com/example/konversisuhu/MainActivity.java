package com.example.konversisuhu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.konversisuhu.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ActivityMainBinding bind;
    Spinner dropdown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        load();
    }

    public void load(){
        isiSpinner();
    }

    public void isiSpinner(){
        dropdown = bind.pilih;
        //buat adapter bertipe array
        ArrayAdapter<CharSequence> pilihAdapter = ArrayAdapter.createFromResource(this, R.array.pilih, android.R.layout.simple_spinner_item);
        //specify the layout to use when tyhe choices list appears
        pilihAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        //get data
        dropdown.setOnItemSelectedListener(this);
        dropdown.setAdapter(pilihAdapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String choice = adapterView.getItemAtPosition(i).toString();

        bind.btnconvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double suhu = Double.parseDouble(bind.nilai.getText().toString());
                double hasil;

                if(choice.equals("Celcius to Reamur")){
                    hasil = (4.0/5.0)*suhu;
                    bind.hasil.setText(String.valueOf(hasil));
                }

                if(choice.equals("Celcius to Fahrenheit")){
                    hasil = (9.0/5.0)*suhu + 32;
                    bind.hasil.setText(String.valueOf(hasil));
                }

                if(choice.equals("Celcius to Kelvin")){
                    hasil = suhu + 273;
                    bind.hasil.setText(String.valueOf(hasil));
                }
            }
        });
        //Toast.makeText(this, choice, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}