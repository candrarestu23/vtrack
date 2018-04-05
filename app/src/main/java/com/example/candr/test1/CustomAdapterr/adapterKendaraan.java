package com.example.candr.test1.CustomAdapterr;

/**
 * Created by candr on 5/2/2017.
 */
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.candr.test1.MapsActivity;
import com.example.candr.test1.MySQL.Kendaraan;
import com.example.candr.test1.R;
import com.example.candr.test1.MySQL.logistik;


import java.util.ArrayList;
import java.util.Map;


public class adapterKendaraan extends BaseAdapter {

    Context c;
    ArrayList<Kendaraan> kendaraans;
    LayoutInflater inflater;

    public adapterKendaraan(Context c,ArrayList<Kendaraan> kendaraan) {
        this.c = c;
        this.kendaraans = kendaraan;

        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return kendaraans.size();
    }

    @Override
    public Object getItem(int position) {
        return kendaraans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.kendaraan_layout, parent, false);
        }


        TextView idKendaraan = (TextView) convertView.findViewById(R.id.IDKendaraan);
        TextView idPengemudi = (TextView) convertView.findViewById(R.id.IDPengemudi);
        TextView idLatitude = (TextView)convertView.findViewById(R.id.IDLatitude);
        TextView idLongitude = (TextView)convertView.findViewById(R.id.IDLongitude);
        Button idButtonList = (Button)convertView.findViewById(R.id.trackList);


        //BIND DATA
        final Kendaraan kendaraan = kendaraans.get(position);

        idKendaraan.setText(String.valueOf(kendaraan.getIDKendaraan()));
        idPengemudi.setText(String.valueOf(kendaraan.getIDPengemudi()));
        idLatitude.setText(String.valueOf(kendaraan.getIDLatitude()));
        idLongitude.setText(String.valueOf(kendaraan.getIDLongitude()));
        idButtonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(c,MapsActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("latitude",kendaraan.getIDLatitude());
                intent.putExtra("longitude",kendaraan.getIDLongitude());
                c.startActivity(intent);

            }
        });

        return convertView;
    }
}