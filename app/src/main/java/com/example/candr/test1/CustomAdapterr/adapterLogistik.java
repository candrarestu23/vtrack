package com.example.candr.test1.CustomAdapterr;

/**
 * Created by candr on 5/2/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.candr.test1.R;
import com.example.candr.test1.MySQL.logistik;


import java.util.ArrayList;


public class adapterLogistik extends BaseAdapter {

    Context c;
    ArrayList<logistik> Logistiks;

    LayoutInflater inflater;

    public adapterLogistik(Context c,ArrayList<logistik> Logistik) {
        this.c = c;
        this.Logistiks = Logistik;

        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return Logistiks.size();
    }

    @Override
    public Object getItem(int position) {
        return Logistiks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.logistik_layout, parent, false);
        }


        TextView idBarang = (TextView) convertView.findViewById(R.id.IDlogistik);
        TextView NamaBarang = (TextView) convertView.findViewById(R.id.idNamaBarang);
        TextView stock = (TextView) convertView.findViewById(R.id.IDStockLogistik);

        //BIND DATA
        logistik Logistik = Logistiks.get(position);

        idBarang.setText("NO."+String.valueOf(Logistik.getIdBarang()));
        NamaBarang.setText(String.valueOf(Logistik.getNamaBarang()));
        stock.setText("Stock :"+String.valueOf(Logistik.getJumlahBarang()));



        return convertView;
    }
}
