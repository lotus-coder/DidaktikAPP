package com.example.didaktikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Icon;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.ImageView;

public class LaugarrenIrudiActivity extends AppCompatActivity {

    private GridLayout gl;
    private ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laugarren_irudi);
        gl = findViewById(R.id.idGridIrudi);
        gl.setColumnCount(3);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);
        img7 = findViewById(R.id.img7);
        img8 = findViewById(R.id.img8);
        img9 = findViewById(R.id.img9);
        /*
        gl.removeAllViews();
*/
        img2.setImageResource(R.mipmap.ada);
        img1.setImageResource(R.mipmap.camino);
        img3.setImageResource(R.mipmap.tiburon);
        img4.setImageResource(R.mipmap.canon);
        img5.setImageResource(R.mipmap.pirata);
        img6.setImageResource(R.mipmap.caserio);
        img7.setImageResource(R.mipmap.mar);
        img8.setImageResource(R.mipmap.hospital);
        img9.setImageResource(R.mipmap.movil);
/*
        gl.addView(img1);
        gl.addView(img2);
        gl.addView(img3);
        gl.addView(img4);
        gl.addView(img5);*/

    }
}