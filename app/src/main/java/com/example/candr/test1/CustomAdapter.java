package com.example.candr.test1;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by candr on 4/27/2017.
 */

public class CustomAdapter extends ArrayAdapter<dataModel>{

    Context context;
    int layoutResourceId;
    dataModel data[] = null;

    public CustomAdapter(Context context, int layoutResourceId, dataModel[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        WeatherHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new WeatherHolder();
            holder.textNO = (TextView)row.findViewById(R.id.textNO);
            holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
            holder.txtTitle2=(TextView)row.findViewById(R.id.txtTitle2);

            row.setTag(holder);
        }
        else
        {
            holder = (WeatherHolder)row.getTag();
        }

        dataModel dataModel = data[position];
        holder.txtTitle.setText(dataModel.title);
        holder.textNO.setText(dataModel.icon);
        holder.txtTitle2.setText(dataModel.hari);

        return row;
    }

    static class WeatherHolder
    {
        TextView textNO;
        TextView txtTitle;
        TextView txtTitle2;
    }
}