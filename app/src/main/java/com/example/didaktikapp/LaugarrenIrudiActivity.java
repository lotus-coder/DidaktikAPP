package com.example.didaktikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Iterator;

public class LaugarrenIrudiActivity extends AppCompatActivity {

    private GridLayout gl;
    private ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9;
    private HashMap<ImageView,Boolean> mapita;
    private int width,height;
    private Button btnCheck;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laugarren_irudi);
        gl = findViewById(R.id.idGridIrudi);
        gl.setColumnCount(3);
        mapita = new HashMap<ImageView, Boolean>();
        img1 = findViewById(R.id.img1);
        mapita.put(img1,true);
        img2 = findViewById(R.id.img2);
        mapita.put(img2,false);
        img3 = findViewById(R.id.img3);
        mapita.put(img3,false);
        img4 = findViewById(R.id.img4);
        mapita.put(img4,true);
        img5 = findViewById(R.id.img5);
        mapita.put(img5,true);
        img6 = findViewById(R.id.img6);
        mapita.put(img6,true);
        img7 = findViewById(R.id.img7);
        mapita.put(img7,false);
        img8 = findViewById(R.id.img8);
        mapita.put(img8,true);
        img9 = findViewById(R.id.img9);
        mapita.put(img9,false);

        btnCheck = findViewById(R.id.btnCheck);
        builder = new AlertDialog.Builder(this);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        width = size.x/3;
        height = size.y/4;

        img2.setImageResource(R.mipmap.ada);
        ajustaTamanio(img2);
        img1.setImageResource(R.mipmap.camino);
        ajustaTamanio(img1);
        img3.setImageResource(R.mipmap.tiburon);
        ajustaTamanio(img3);
        img4.setImageResource(R.mipmap.canon);
        ajustaTamanio(img4);
        img5.setImageResource(R.mipmap.pirata);
        ajustaTamanio(img5);
        img6.setImageResource(R.mipmap.caserio);
        ajustaTamanio(img6);
        img7.setImageResource(R.mipmap.mar);
        ajustaTamanio(img7);
        img8.setImageResource(R.mipmap.hospital);
        ajustaTamanio(img8);
        img9.setImageResource(R.mipmap.movil);
        ajustaTamanio(img9);
        eventos();
    }

    private void eventos() {
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Iterator<ImageView> i = mapita.keySet().iterator();
                int cont = 0;
                for (Iterator<ImageView> it = i; it.hasNext(); ) {
                    ImageView im = it.next();
                    if (im.isSelected() && mapita.get(im)) {
                        cont++;
                    }
                }
                String textoDialogo = "";
                if (cont == 5){
                    textoDialogo = "Erantzun guztiak ondo daude!";
                }else{
                    textoDialogo = "Hasmatu dituzu "+cont+" galdera!";
                }
                builder.setTitle("Audioa").setMessage(textoDialogo+"\nNahi duzu hurrengo gunera joatea?")
                        .setCancelable(false)
                        .setPositiveButton("Bai", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent i = new Intent(LaugarrenIrudiActivity.this,BostgarrenActivity.class);
                                /*Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
                                        Toast.LENGTH_SHORT).show();*/
                                startActivity(i);
                            }
                        })
                        .setNegativeButton("Ez", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                deselecionameEsto();
                                Toast.makeText(getApplicationContext(),"Zahiatu berriro!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("AlertDialogExample");
                alert.show();
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!img1.isSelected()){
                    img1.setBackgroundColor(Color.GREEN);
                    img1.setSelected(true);
                }else {
                    img1.setBackgroundColor(Color.TRANSPARENT);
                    img1.setSelected(false);
                }
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!img2.isSelected()){
                    img2.setBackgroundColor(Color.GREEN);
                    img2.setSelected(true);
                }else {
                    img2.setBackgroundColor(Color.TRANSPARENT);
                    img2.setSelected(false);
                }
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!img3.isSelected()){
                    img3.setBackgroundColor(Color.GREEN);
                    img3.setSelected(true);
                }else {
                    img3.setBackgroundColor(Color.TRANSPARENT);
                    img3.setSelected(false);
                }
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!img4.isSelected()){
                    img4.setBackgroundColor(Color.GREEN);
                    img4.setSelected(true);
                }else {
                    img4.setBackgroundColor(Color.TRANSPARENT);
                    img4.setSelected(false);
                }
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!img5.isSelected()){
                    img5.setBackgroundColor(Color.GREEN);
                    img5.setSelected(true);
                }else {
                    img5.setBackgroundColor(Color.TRANSPARENT);
                    img5.setSelected(false);
                }
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!img6.isSelected()){
                    img6.setBackgroundColor(Color.GREEN);
                    img6.setSelected(true);
                }else {
                    img6.setBackgroundColor(Color.TRANSPARENT);
                    img6.setSelected(false);
                }
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!img7.isSelected()){
                    img7.setBackgroundColor(Color.GREEN);
                    img7.setSelected(true);
                }else {
                    img7.setBackgroundColor(Color.TRANSPARENT);
                    img7.setSelected(false);
                }
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!img8.isSelected()){
                    img8.setBackgroundColor(Color.GREEN);
                    img8.setSelected(true);
                }else {
                    img8.setBackgroundColor(Color.TRANSPARENT);
                    img8.setSelected(false);
                }
            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!img9.isSelected()){
                    img9.setBackgroundColor(Color.GREEN);
                    img9.setSelected(true);
                }else {
                    img9.setBackgroundColor(Color.TRANSPARENT);
                    img9.setSelected(false);
                }
            }
        });
    }
    private void deselecionameEsto(){
        img1.setSelected(false);
        img2.setSelected(false);
        img3.setSelected(false);
        img4.setSelected(false);
        img5.setSelected(false);
        img6.setSelected(false);
        img7.setSelected(false);
        img8.setSelected(false);
        img9.setSelected(false);
        img1.setBackgroundColor(Color.TRANSPARENT);
        img2.setBackgroundColor(Color.TRANSPARENT);
        img3.setBackgroundColor(Color.TRANSPARENT);
        img4.setBackgroundColor(Color.TRANSPARENT);
        img5.setBackgroundColor(Color.TRANSPARENT);
        img6.setBackgroundColor(Color.TRANSPARENT);
        img7.setBackgroundColor(Color.TRANSPARENT);
        img8.setBackgroundColor(Color.TRANSPARENT);
        img9.setBackgroundColor(Color.TRANSPARENT);
    }
    private void ajustaTamanio(ImageView img){
        img.getLayoutParams().height = height;
        img.getLayoutParams().width = width;
        img.requestLayout();
    }
}