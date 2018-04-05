package com.example.candr.test1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.candr.test1.Login.ID;
import com.example.candr.test1.MySQL.DownloaderKendaraan;
import com.example.candr.test1.MySQL.DownloaderKiriman;
import com.example.candr.test1.MySQL.Kendaraan;
import com.example.candr.test1.MySQL.Kiriman;

/**
 * Created by candr on 4/27/2017.
 */

public class history extends Activity {
    final static String urlAddress = "http://10.0.3.2/vtrack/kiriman.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Kiriman kiriman = new Kiriman();
        setContentView(R.layout.list_view);
        ImageView top = (ImageView) findViewById(R.id.listImage);
        top.setImageDrawable(getResources().getDrawable(R.drawable.history));
        final ListView lv = (ListView) findViewById(R.id.optionsList);
        new DownloaderKiriman(history.this, urlAddress, lv).execute();
    }
}