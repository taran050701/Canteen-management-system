package com.maid.appalpha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menuScreen extends AppCompatActivity {
Button btnSnacks,btnBev,btnLunch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);
        btnSnacks = findViewById(R.id.snacks);
        btnBev = findViewById(R.id.beverages);
        btnLunch = findViewById(R.id.lunch);

        btnSnacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent in =new Intent(menuScreen.this,snacksList.class);
             startActivity(in);
            }
        });

        btnBev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(menuScreen.this,bevList.class);
                startActivity(in);
            }
        });

        btnLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(menuScreen.this,lunchList.class);
            }
        });


    }
}