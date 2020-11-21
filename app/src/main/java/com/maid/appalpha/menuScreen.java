package com.maid.appalpha;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

public class menuScreen extends AppCompatActivity {
Button btnSnacks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);
        btnSnacks=findViewById(R.id.snacks);


        btnSnacks.setBackgroundColor(Color.WHITE);
        btnSnacks.setTextColor(Color.BLACK);
    }
}