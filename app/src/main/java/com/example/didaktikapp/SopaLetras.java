package com.example.didaktikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Calendar;

public class SopaLetras extends AppCompatActivity {

    private GridLayout grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sopa_letras);
        grid = (GridLayout) findViewById(R.id.idGrid);
        grid.setColumnCount(9);
        for (int i = 0;i<8;i++){
            for (int j = 0; j<9;j++){
                TextView t = new TextView(this);
                t.setText("j");
                t.setTextSize((float) (t.getTextSize() +0.1));
                t.setPadding(50,30,50,30);
                t.setOnTouchListener(new ListenerSopita());
                grid.addView(t);
            }
        }
    }

    class ListenerSopita implements View.OnTouchListener  {
        private static final int MAX_CLICK_DURATION = 200;
        private long startClickTime;
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    startClickTime = Calendar.getInstance().getTimeInMillis();
                    v.setBackgroundColor(Color.GREEN);
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    long clickDuration = Calendar.getInstance().getTimeInMillis() - startClickTime;
                    if(clickDuration < MAX_CLICK_DURATION) {
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
            return true;
        }
    }
}