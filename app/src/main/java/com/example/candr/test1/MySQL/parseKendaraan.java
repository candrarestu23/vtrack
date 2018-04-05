package com.example.candr.test1.MySQL;

/**
 * Created by candr on 5/2/2017.
 */
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.candr.test1.CustomAdapter;
import com.example.candr.test1.CustomAdapterr.adapterKendaraan;
import com.example.candr.test1.CustomAdapterr.adapterLogistik;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class parseKendaraan extends AsyncTask<Void,Void,Integer> {

    Context c;
    String jsonData;
    ListView lv;

    ProgressDialog pd;
    ArrayList<Kendaraan> kendaraans = new ArrayList<>();

    public parseKendaraan(Context c, String jsonData, ListView lv) {
        this.c = c;
        this.jsonData = jsonData;
        this.lv = lv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Parsing...Please wait");
        pd.show();
    }

    @Override
    protected Integer doInBackground(Void... params) {
        return this.parseData();
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);

        pd.dismiss();

        if(result==0)
        {
            Toast.makeText(c,"Unable To Parse",Toast.LENGTH_SHORT).show();
        }else {
            //BIND DATA TO LISTVIEW
            adapterKendaraan adapter=new adapterKendaraan(c,kendaraans);
            lv.setAdapter(adapter);
        }
    }

    private int parseData()
    {
        try
        {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;

            kendaraans.clear();
            Kendaraan kendaraan;

            for(int i=0;i<ja.length();i++) {
                jo = ja.getJSONObject(i);

                String IDKendaraan = jo.getString("id_kenda");
                String IDPengemudi = jo.getString("pengemudi");
                String IDLatitude = jo.getString("latitude");
                String IDLongitude = jo.getString("longitude");


                kendaraan = new Kendaraan();
                kendaraan.setIDKendaraan(IDKendaraan);
                kendaraan.setIDPengemudi(IDPengemudi);
                kendaraan.setIDLatitude(IDLatitude);
                kendaraan.setIDLongitude(IDLongitude);

                kendaraans.add(kendaraan);
            }
            return 1;


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}