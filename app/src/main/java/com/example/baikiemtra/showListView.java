package com.example.baikiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class showListView extends AppCompatActivity {
    ListView listView;
    ImageView btBackLogin;
    LVAdapter adapter;
    ArrayList<CayThuocNam> listCay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list_view);

        listView = findViewById(R.id.lístView);
        btBackLogin = findViewById(R.id.imgBackToLogin);
        btBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        AddDuLieu();

        adapter = new LVAdapter(this, R.layout.line_list, listCay);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(showListView.this, ChiTiet.class);
                intent.putExtra("tenCay", listCay.get(i).getTenKhoaHoc());
                intent.putExtra("moTaCay", listCay.get(i).getDacTinh());
                startActivity(intent);
            }
        });
    }

    private void AddDuLieu() {
        listCay = new ArrayList<>();
        listCay.add(new CayThuocNam("Bạc Hà", "Mentha arvensis L", "Sơ phong, thanh nhiệt, thấu chẩn, sơ can, giải uất, giải độc. Chữa cảm mạo phong nhiệt,"));
        listCay.add(new CayThuocNam("Bách Bộ", "Stemona tuberosa Lour", "Nhuận phế, chỉ ho, sát trùng. Chữa các chứng ho mới hoặc ho lâu ngày"));
        listCay.add(new CayThuocNam("Bạch Đồng Nữ", "Clerodendrum chinense", "Thanh nhiệt, giải độc, khu phong trừ thấp, tiêu viêm. Rễ cây chữa gân xương đau nhức"));
        listCay.add(new CayThuocNam("Bạch Hoa Xà Thiệt Thảo", "Hedyotis diffusa Willd", "Thanh nhiệt giải độc, lợi niệu thông lâm, tiêu ung tán kết."));
        listCay.add(new CayThuocNam("Hạ Khô Thảo", "Prunella vulgaris L", "Thanh nhiệt giải độc, lợi niệu thông lâm, tiêu ung tán kết."));
    }
}