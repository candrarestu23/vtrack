package com.example.candr.test1.Login;

import android.app.ActivityOptions;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Transition;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.candr.test1.MapsActivity;
import com.example.candr.test1.R;
import com.example.candr.test1.history;

/**
 * Created by candr on 4/27/2017.
 */

public class homeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        ImageView trackTruck = (ImageView) findViewById(R.id.trackButton);
        ImageView historyButton = (ImageView) findViewById(R.id.historyButton);
        ImageView platNomorButton = (ImageView) findViewById(R.id.IDButton);
        ImageView boxButton = (ImageView)findViewById(R.id.boxButton);
        final Transition explode = new Explode();
        getWindow().setEnterTransition(explode);

        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeActivity.this,history.class);
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(homeActivity.this).toBundle();
                startActivity(intent, bundle);
            }
        });

        platNomorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeActivity.this,ID.class);
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(homeActivity.this).toBundle();
                startActivity(intent, bundle);
            }
        });

        trackTruck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeActivity.this,MapsActivity.class);
                intent.putExtra("latitude","-6.974001");
                intent.putExtra("longitude","107.63034800000003");
                startActivity(intent);
            }
        });
        boxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (homeActivity.this,Box.class);
                startActivity(intent);
            }
        });
    }
}
