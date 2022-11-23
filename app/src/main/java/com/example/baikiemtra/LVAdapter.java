package com.example.baikiemtra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatCheckBox;

import java.util.List;

public class LVAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<CayThuocNam> list;

    public LVAdapter(Context context, int layout, List<CayThuocNam> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder {
        TextView ten, tenThuongGoi, moTa;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder = new ViewHolder();
            holder.ten = view.findViewById(R.id.tvTen);
            holder.tenThuongGoi = view.findViewById(R.id.tvTenThuongGoi);
            holder.moTa = view.findViewById(R.id.tvMoTa);
            view.setTag(holder);
        }
        else
            holder = (ViewHolder) view.getTag();

        CayThuocNam cay =list.get(i);
        holder.ten.setText(cay.getTenKhoaHoc());
        holder.tenThuongGoi.setText(cay.getTenThuongGoi());
        holder.moTa.setText(cay.getDacTinh());

        return view;
    }
}
