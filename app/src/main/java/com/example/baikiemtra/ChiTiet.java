package com.example.baikiemtra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ChiTiet extends AppCompatActivity {
    TextView ten,moTa;
    ImageFilterView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);

        ten = findViewById(R.id.chiTiet_Ten);
        moTa = findViewById(R.id.chiTiet_moTa);
        imgBack = findViewById(R.id.imgViewBackToList);

        Intent intent = getIntent();
        ten.setText(intent.getStringExtra("tenCay"));
        moTa.setText(intent.getStringExtra("moTaCay"));

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}