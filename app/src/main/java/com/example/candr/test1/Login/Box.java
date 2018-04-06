package com.example.candr.test1.Login;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.candr.test1.CustomAdapter;
import com.example.candr.test1.MySQL.logistik;
import com.example.candr.test1.R;
import com.example.candr.test1.MySQL.parseLogistik;
import com.example.candr.test1.MySQL.Downloader;

/**
 * Created by candr on 4/28/2017.
 */

public class Box extends Activity {
    final static String urlAddress="http://projectapps.xyz/vtrack/logistik.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logistik Logistik = new logistik();
        setContentView(R.layout.list_view);
        ImageView top = (ImageView)findViewById(R.id.listImage);
        top.setImageDrawable(getResources().getDrawable(R.drawable.box));
        final ListView lv= (ListView) findViewById(R.id.optionsList);
        new Downloader(Box.this,urlAddress,lv).execute();

    }
}
