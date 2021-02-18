package com.example.didaktikapp;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class SopaLetras extends AppCompatActivity {

    private GridLayout grid;
    private String [] hitzak = {"kaxarranka","aurreskua","dantza","mantoia","fandangoa"};
    private TextViewSopa [][] letras = new TextViewSopa[10][9];
    private boolean haPulsado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sopa_letras);
        grid = (GridLayout) findViewById(R.id.idGrid);
        grid.setColumnCount(9);
        haPulsado = false;
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
                t.setOnTouchListener(new ListenerSopita());
                letras[i][j] = t;
                grid.addView(t);
            }
        }
    }

    class ListenerSopita implements View.OnTouchListener  {
        private static final int MAX_CLICK_DURATION = 200;
        private long startClickTime;
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(!haPulsado) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        startClickTime = Calendar.getInstance().getTimeInMillis();
                        v.setBackgroundColor(Color.GREEN);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        long clickDuration = Calendar.getInstance().getTimeInMillis() - startClickTime;
                        if (clickDuration < MAX_CLICK_DURATION) {
                            v.setBackgroundColor(Color.GREEN);
                        }
                    }
                    case MotionEvent.ACTION_BUTTON_PRESS: {
                        v.setBackgroundColor(Color.GREEN);
                    }
                    case MotionEvent.ACTION_SCROLL: {
                        v.setBackgroundColor(Color.GREEN);
                    }
                }
                haPulsado = true;
            }else{
/*
                v.get
*/
                haPulsado = false;
            }
            return true;
        }
    }

    private int dameRandom(int min,int max){
        int numero = (int)(Math.random()*(max-min+1)+min);
        return numero;
    }

    private int dameLetraRandom(){
        int min = 'a';
        int max = 'z';
        return dameRandom(min,max);
    }


}