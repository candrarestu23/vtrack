package com.example.candr.test1.Login;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.candr.test1.CustomAdapter;
import com.example.candr.test1.MySQL.Downloader;
import com.example.candr.test1.MySQL.DownloaderKendaraan;
import com.example.candr.test1.MySQL.Kendaraan;
import com.example.candr.test1.MySQL.logistik;
import com.example.candr.test1.R;
import com.example.candr.test1.dataModel;

/**
 * Created by candr on 4/28/2017.
 */

public class ID extends Activity {
    final static String urlAddress = "http://projectapps.xyz/vtrack/kendaraan.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Kendaraan kendaraan = new Kendaraan();
        setContentView(R.layout.list_view);
        ImageView top = (ImageView) findViewById(R.id.listImage);
        top.setImageDrawable(getResources().getDrawable(R.drawable.id));
        final ListView lv = (ListView) findViewById(R.id.optionsList);
        new DownloaderKendaraan(ID.this, urlAddress, lv).execute();
    }
}
