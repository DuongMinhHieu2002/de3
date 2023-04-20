package com.example.de1;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class adapterHDH extends BaseAdapter {
    Context context;

    int layout;

    List<HDH> ListHDH;

    public adapterHDH(Context context, int layout, List<HDH> listHDH) {
        this.context = context;
        this.layout = layout;
        ListHDH = listHDH;
    }

    @Override
    public int getCount() {
        return ListHDH.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);

        TextView tenpb = convertView.findViewById(R.id.txt1);
        TextView tenhdh = convertView.findViewById(R.id.txt2);

//gan gia tri
        tenpb.setText(ListHDH.get(position).tenphienban);
        tenhdh.setText(ListHDH.get(position).tenhedieuhanh);

        return convertView;
    }
}
