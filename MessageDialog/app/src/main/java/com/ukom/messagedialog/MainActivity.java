package com.ukom.messagedialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ukom.messagedialog.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        toast();
        alert();
        dialog();
    }



    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("start");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        System.out.println("resume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("pause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("destrory");

    }

    public void toast(){
        bind.btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Ini toast", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void alert(){
        bind.btnALert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Ini Alert");
                alert.setMessage("Ini adalah alert lo ya");
                alert.show();
            }
        });
    }


    public void dialog(){
        bind.btnAlertD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Ini alert dialog");
                dialog.setMessage("Ini alert dialog yaa");
                dialog.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "jawaban positif", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "jawaban negatif", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
            }
        });
    }

}