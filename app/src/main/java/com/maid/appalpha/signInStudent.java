package com.maid.appalpha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import java.sql.*;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class signInStudent extends AppCompatActivity {
    Button btnLogin;
    EditText edtUsername,edtPassword;
    DatabaseReference reference;
    FirebaseDatabase firebaseDatabase,rootNode;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_student);

        btnLogin=findViewById(R.id.login);
        edtUsername=findViewById(R.id.edtUsername);
        edtPassword=findViewById(R.id.edtPassword);
        firebaseDatabase = FirebaseDatabase.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = edtUsername.getText().toString();
                password = edtPassword.getText().toString();
                reference = rootNode.getReference("Student");
                final DatabaseReference personDetails = firebaseDatabase.getReference("Student");
                personDetails.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String id=snapshot.child("id").getValue().toString();
                        String pass=snapshot.child("password").getValue().toString();
                      //  Log.d("id123",id);
                        if (id.equalsIgnoreCase(username)){
                            if (pass.equalsIgnoreCase(password)){
                                Intent in = new Intent(signInStudent.this, menuScreen.class);
                            startActivity(in);
                            }else{
                                Toast.makeText(signInStudent.this, "Incorrect credentials", Toast.LENGTH_SHORT).show();

                            }
                        }else{
                            Toast.makeText(signInStudent.this, "Incorrect credentials", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {



            }
        });
    }
});
    }
}