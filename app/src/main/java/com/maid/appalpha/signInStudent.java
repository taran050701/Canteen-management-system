package com.maid.appalpha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import java.sql.*;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signInStudent extends AppCompatActivity {
    Button btnLogin;
    EditText edtUsername,edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_student);

        btnLogin=findViewById(R.id.login);
        edtUsername=findViewById(R.id.edtUsername);
        edtPassword=findViewById(R.id.edtPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(signInStudent.this,menuScreen.class);
                startActivity(in);

            }
        });
    }
}