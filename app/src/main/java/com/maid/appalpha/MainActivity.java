package com.maid.appalpha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import java.sql.*;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAdmin,btnStudent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdmin=findViewById(R.id.admin);
        btnStudent=findViewById(R.id.student);



        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button clicked", Toast.LENGTH_SHORT).show();

                Intent in = new Intent(MainActivity.this,signInAdmin.class);
                startActivity(in);

            }
        });

        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button clicked", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(MainActivity.this,signInStudent.class);
                startActivity(in);
            }
        });


    }
}