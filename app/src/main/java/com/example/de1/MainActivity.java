package com.example.de1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvHDH;
    ArrayList<HDH> arrayList;
    adapterHDH adapterHDH;
    Context context;
    EditText edtpb;
    EditText edthdh;
    Button btnud,btnv,btnadd;

    int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        arrayList = new ArrayList<>();
        AddarrayList();
        context = this;
        adapterHDH = new adapterHDH(context,R.layout.item_hdh,arrayList);
        lvHDH.setAdapter(adapterHDH);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenpb = edtpb.getText().toString();
                String tenhbh = edthdh.getText().toString();

                arrayList.add(new HDH(tenpb,tenhbh,R.drawable.anh_background));
                edtpb.setText(null);
                edthdh.setText(null);
                adapterHDH.notifyDataSetChanged();
            }
        });
        lvHDH.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                vitri = position;
                xacnhanxoa();
                return false;
            }
        });

    }

    private void xacnhanxoa() {
        AlertDialog.Builder adl= new AlertDialog.Builder(this);
        adl.setTitle("Thong bao");
        adl.setIcon(R.mipmap.ic_launcher_round);
        adl.setMessage("Bạn có muốn xóa không");
        adl.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                arrayList.remove(vitri);
                adapterHDH.notifyDataSetChanged();
            }
        });
        adl.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        adl.show();

    }

    private void AddarrayList() {
        arrayList.add(new HDH("andoid 1","hieu",R.drawable.anh_background));
        arrayList.add(new HDH("andoid 2","hieu",R.mipmap.ic_launcher_round));
    }

    private void Anhxa() {
    lvHDH = findViewById(R.id.lvhdh);
    edtpb = findViewById(R.id.edt1);
    edthdh = findViewById(R.id.edt2);
    btnud = findViewById(R.id.btnud);
    btnv = findViewById(R.id.btnview);
    btnadd = findViewById(R.id.btnadd);
    }
}