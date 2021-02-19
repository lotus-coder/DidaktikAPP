package com.example.didaktikapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class SopaLetras extends AppCompatActivity {

    private GridLayout grid;
    private String [] hitzak = {"kaxarranka","aurreskua","dantza","mantoia","fandangoa"};
    private TextViewSopa [][] letras = new TextViewSopa[10][9];
    private int [] ultimaPulsada;
    private boolean haPulsado;
    private  int cont=0;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sopa_letras);
        grid = (GridLayout) findViewById(R.id.idGrid);
        grid.setColumnCount(9);
        haPulsado = false;
        builder = new AlertDialog.Builder(this);
        for (int i = 0;i<10;i++){

            for (int j = 0; j<9;j++){
                TextViewSopa t = new TextViewSopa(this);
                if(i == 0){
                    t.setText(""+hitzak[1].charAt(j));
                }else if(i == 2 && j < hitzak[2].length()){
                    t.setText(""+hitzak[2].charAt(j));
                }else if(j == 1 && i <= hitzak[3].length() && i>0){
                    t.setText(""+hitzak[3].charAt(i-1));
                }else if (j == 6){
                    t.setText(""+hitzak[0].charAt(i));
                }else{
                    t.setText((char)(dameLetraRandom())+"");
                }
                t.setPosicionX(i);
                t.setPosicionY(j);
                t.setTextSize((float) (t.getTextSize() +0.1));
                t.setPadding(17,10,17,10);
                t.setOnClickListener(new ListenerSopita(t));
                letras[i][j] = t;
                grid.addView(t);
            }
        }
    }

    class ListenerSopita implements View.OnClickListener  {
        private static final int MAX_CLICK_DURATION = 200;
        private long startClickTime;
        private TextViewSopa t;
        public ListenerSopita(TextViewSopa t){
            this.t = t;
        }
        @Override
        public void onClick(View v) {
            if(!haPulsado) {
                v.setBackgroundColor(Color.GREEN);
                ultimaPulsada = cualEs(t);
                haPulsado = true;
            }else{

                int [] locationActual = cualEs(t);int max = 0; int min= 0;
                String palabra = "";
                if (locationActual[0] == ultimaPulsada[0] ){
                    min=(locationActual[1] < ultimaPulsada[1]) ? locationActual[1]:ultimaPulsada[1];
                    max=(locationActual[1] > ultimaPulsada[1]) ? locationActual[1]:ultimaPulsada[1];
                    for(int i = min;i < max;i++){
                        palabra+=letras[locationActual[0]][i].getText().toString();
                    }
                    palabra+=letras[locationActual[0]][locationActual[1]].getText().toString();
                    boolean b = false;
                    for(String hitz :hitzak){
                        if (hitz.equals(palabra)) b = true;
                    }
                    if(b){
                        for(;min < max;min++){
                            letras[locationActual[0]][min].setBackgroundColor(Color.GREEN);
                        }
                        t.setBackgroundColor(Color.GREEN);
                        cont++;
                    }else{
                        Toast.makeText(getApplicationContext(),"Zahiatu berriro!",
                                Toast.LENGTH_SHORT).show();
                        letras[ultimaPulsada[0]][ultimaPulsada[1]].setBackgroundColor(Color.TRANSPARENT);
                        letras[locationActual[0]][locationActual[1]].setBackgroundColor(Color.TRANSPARENT);
                    }
                }
                else if (locationActual[1] == ultimaPulsada[1] ){
                    min =(locationActual[0] < ultimaPulsada[0]) ? locationActual[0]:ultimaPulsada[0];
                    max =(locationActual[0] > ultimaPulsada[0]) ? locationActual[0]:ultimaPulsada[0];
                    for(int i = min;i < max;i++){
                        palabra+=letras[i][locationActual[1]].getText().toString();
                    }
                    palabra+=letras[locationActual[0]][locationActual[1]].getText().toString();
                    boolean b = false;
                    for(String hitz :hitzak){
                        if (hitz.equals(palabra)) b = true;
                    }
                    if(b){
                        for(int i = min;i < max;i++){
                            letras[i][locationActual[1]].setBackgroundColor(Color.GREEN);
                        }
                        cont++;
                        t.setBackgroundColor(Color.GREEN);
                    }else{
                        Toast.makeText(getApplicationContext(),"Zahiatu berriro!",
                                Toast.LENGTH_SHORT).show();
                        letras[ultimaPulsada[0]][ultimaPulsada[1]].setBackgroundColor(Color.TRANSPARENT);
                        letras[locationActual[0]][locationActual[1]].setBackgroundColor(Color.TRANSPARENT);
                    }
                }
                if (max == 0 && min ==0){
                    letras[ultimaPulsada[0]][ultimaPulsada[1]].setBackgroundColor(Color.TRANSPARENT);
                }
                if (cont+1 == hitzak.length){
                    builder.setTitle("Bukatu duzu").setMessage("Oso ondo hitz guztiak aurkitu dituzu! Hurrengoa Egitera!")
                            .setCancelable(false)
                            .setPositiveButton("Lets Go !", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent i = new Intent(SopaLetras.this,MapsActivity.class);
                                /*Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
                                        Toast.LENGTH_SHORT).show();*/
                                    startActivity(i);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
                ultimaPulsada = null;
                haPulsado = false;
            }
        }

    }

    private int dameRandom(int min,int max){
        int numero = (int)(Math.random()*(max-min+1)+min);
        return numero;
    }

    private int[] cualEs(TextViewSopa t){
        for (int i = 0;i<10;i++){
            for (int j = 0; j<9;j++){
                if (t==letras[i][j]){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private int dameLetraRandom(){
        int min = 'a';
        int max = 'z';
        return dameRandom(min,max);
    }


}