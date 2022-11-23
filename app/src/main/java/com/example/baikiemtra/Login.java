package com.example.baikiemtra;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    Button btLogin;
    TextView btRegis;
    EditText editEmail,editPass;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        editEmail = (EditText) findViewById(R.id.inputUsername);
        editPass = (EditText) findViewById(R.id.inputPassword);

        btLogin = findViewById(R.id.btnLogin);
        btRegis = findViewById(R.id.tvToRegis);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginTo();
            }
        });
        btRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUp();
            }
        });

    }

        private void SignUp() {
            Intent i = new Intent(Login.this, Regis.class);
            startActivity(i);
        }

        private void LoginTo() {
            String email, pass;
            email = editEmail.getText().toString();
            pass = editPass.getText().toString();

            if(TextUtils.isEmpty(email)){
                Toast.makeText(this,"Nhap Email !",Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(pass)){
                Toast.makeText(this,"Nhap Password !",Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(),"Dang nhap thanh cong !", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Login.this, showListView.class);
                        startActivity(i);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Dang nhap thanh cong !", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Login.this, showListView.class);
                        startActivity(i);
                    }
                }
            });
}
}