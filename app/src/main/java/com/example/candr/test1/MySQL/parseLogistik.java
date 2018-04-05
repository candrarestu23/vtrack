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
import com.example.candr.test1.CustomAdapterr.adapterLogistik;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class parseLogistik extends AsyncTask<Void,Void,Integer> {

    Context c;
    String jsonData;
    ListView lv;

    ProgressDialog pd;
    ArrayList<logistik> Logistiks = new ArrayList<>();

    public parseLogistik(Context c, String jsonData, ListView lv) {
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
            adapterLogistik adapter=new adapterLogistik(c,Logistiks);
            lv.setAdapter(adapter);
        }
    }

    private int parseData()
    {
        try
        {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo=null;

            Logistiks.clear();
            logistik Logistik;

            for(int i=0;i<ja.length();i++) {
                jo = ja.getJSONObject(i);

                int idBarang = jo.getInt("id_barang");
                String namaBarang = jo.getString("nama_barang");
                int stock = jo.getInt("jumlah_stock");


                Logistik = new logistik();
                Logistik.setIDBarang(idBarang);
                Logistik.setNamaBarang(namaBarang);
                Logistik.setJumlahBarang(stock);

                Logistiks.add(Logistik);
            }
                return 1;


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
    }
