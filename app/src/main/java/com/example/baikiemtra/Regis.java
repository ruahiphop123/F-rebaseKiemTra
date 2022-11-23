package com.example.baikiemtra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Regis extends AppCompatActivity {
    Button btRegis,btBackToLogin;
    EditText editEmail, editPass, passconf;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);

        mAuth = FirebaseAuth.getInstance();
        btRegis = (Button) findViewById(R.id.btnRegister);
        btBackToLogin = (Button) findViewById(R.id.btBackToLogin);

        editEmail = (EditText) findViewById(R.id.txtUserRegis);
        editPass = (EditText) findViewById(R.id.txtPassRegis);
        passconf = (EditText) findViewById(R.id.txtPassConf);

        btBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
        String email, pass;
        email = editEmail.getText().toString();
        pass = editPass.getText().toString();


        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Nhập Email !",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Nhập Password !",Toast.LENGTH_SHORT).show();
            return;
        }


        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Đăng kí thành công ! ",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Đăng kí thất bại !",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}