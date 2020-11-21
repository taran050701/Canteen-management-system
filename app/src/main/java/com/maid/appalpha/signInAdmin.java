package com.maid.appalpha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class signInAdmin extends AppCompatActivity {
Button btnLogin;
EditText edtUsername,edtPassword;
FirebaseDatabase firebaseDatabase,rootNode;
DatabaseReference reference;
    String username,password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_admin);
        btnLogin=findViewById(R.id.login);
        edtUsername=findViewById(R.id.edtUsername);
        edtPassword=findViewById(R.id.edtPassword);
        firebaseDatabase = FirebaseDatabase.getInstance();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Login");
//Get all the values
                username = edtUsername.getText().toString();
                password = edtPassword.getText().toString();
                final DatabaseReference personDetails = firebaseDatabase.getReference("Login");
                personDetails.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Log.d("going", "hello");
                        if (dataSnapshot.hasChild(username)) {
                            String a = dataSnapshot.child(username).getKey();
                            Log.d("trueee", dataSnapshot.child(username).getValue().toString());
                            Toast.makeText(signInAdmin.this, "Already Exisitng", Toast.LENGTH_SHORT).show();

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

