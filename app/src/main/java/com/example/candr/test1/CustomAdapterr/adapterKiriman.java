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

import com.example.candr.test1.MySQL.Kendaraan;
import com.example.candr.test1.MySQL.Kiriman;
import com.example.candr.test1.R;
import com.example.candr.test1.MySQL.logistik;


import java.util.ArrayList;


public class adapterKiriman extends BaseAdapter {

    Context c;
    ArrayList<Kiriman> Kirimans;
    LayoutInflater inflater;

    public adapterKiriman(Context c,ArrayList<Kiriman> kiriman) {
        this.c = c;
        this.Kirimans = kiriman;

        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return Kirimans.size();
    }

    @Override
    public Object getItem(int position) {
        return Kirimans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.kiriman_layout, parent, false);
        }


        TextView idKiriman = (TextView) convertView.findViewById(R.id.IDKiriman);
        TextView idPengemudi = (TextView) convertView.findViewById(R.id.IDPengemudi);
        TextView idLokasi = (TextView) convertView.findViewById(R.id.IDTujuan);
        TextView idKendaraan = (TextView)convertView.findViewById(R.id.IDNomerKendaraan);

        //BIND DATA
        Kiriman kiriman = Kirimans.get(position);

        idKendaraan.setText(String.valueOf(kiriman.getIDKendaraanKiriman()));
        idKiriman.setText(String.valueOf(kiriman.getIDKiriman()));
        idPengemudi.setText(String.valueOf(kiriman.getIDPengemudiKiriman()));
        idLokasi.setText(String.valueOf(kiriman.getIDTujuan()));



        return convertView;
    }
}