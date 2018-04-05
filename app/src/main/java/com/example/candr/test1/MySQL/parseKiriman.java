package com.example.candr.test1.MySQL;

/**
 * Created by candr on 5/2/2017.
 */
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.candr.test1.CustomAdapterr.adapterKiriman;
import com.example.candr.test1.CustomAdapterr.adapterLogistik;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class parseKiriman extends AsyncTask<Void,Void,Integer> {

    Context c;
    String jsonData;
    ListView lv;

    ProgressDialog pd;
    ArrayList<Kiriman> Kirimans = new ArrayList<>();

    public parseKiriman(Context c, String jsonData, ListView lv) {
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
            adapterKiriman adapter=new adapterKiriman(c,Kirimans);
            lv.setAdapter(adapter);
        }
    }

    private int parseData()
    {
        try
        {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;

            Kirimans.clear();
            Kiriman kiriman;

            for(int i=0;i<ja.length();i++) {
                jo = ja.getJSONObject(i);

                int idKiriman = jo.getInt("id_kiriman");
                String idTujuan = jo.getString("tujuan");
                String idKendaraan = jo.getString("id_kendaraan");
                String idPengemudi = jo.getString("pengemudi");

                kiriman = new Kiriman();
                kiriman.setIDKiriman(idKiriman);
                kiriman.setIDTujuan(idTujuan);
                kiriman.setIDKendaraanKiriman(idKendaraan);
                kiriman.setIDPengemudiKiriman(idPengemudi);

                Kirimans.add(kiriman);
            }
            return 1;


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
