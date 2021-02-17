package com.example.didaktikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class KomikiActivity extends AppCompatActivity {

    private ImageView img1,img2,img3,img4,img5,img6,img7,img8;
    private TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8;
    private int cont;
    private Button btnReset,btnChekia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_komiki);
        cont = 1;
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);
        txt6 = findViewById(R.id.txt6);
        txt7 = findViewById(R.id.txt7);
        txt8 = findViewById(R.id.txt8);
        btnReset = findViewById(R.id.botonReset);
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
        txt6.setText("");
        txt7.setText("");
        txt8.setText("");
        img1 = findViewById(R.id.com1);
        img2 = findViewById(R.id.com2);
        img3 = findViewById(R.id.com3);
        img4 = findViewById(R.id.com4);
        img5 = findViewById(R.id.com5);
        img6 = findViewById(R.id.com6);
        img7 = findViewById(R.id.com7);
        img8 = findViewById(R.id.com8);
        eventos();
    }

    private void eventos() {
        img1.setOnClickListener(new Klik(txt1));
        img2.setOnClickListener(new Klik(txt2));
        img3.setOnClickListener(new Klik(txt3));
        img4.setOnClickListener(new Klik(txt4));
        img5.setOnClickListener(new Klik(txt5));
        img6.setOnClickListener(new Klik(txt6));
        img7.setOnClickListener(new Klik(txt7));
        img8.setOnClickListener(new Klik(txt8));
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setText("");
                txt2.setText("");
                txt3.setText("");
                txt4.setText("");
                txt5.setText("");
                txt6.setText("");
                txt7.setText("");
                txt8.setText("");
                cont = 1;
            }
        });

    }
    public class Klik implements View.OnClickListener {
        private TextView t;
        public Klik(TextView t){
            this.t = t;
        }
        @Override
        public void onClick(View v) {
            if(t.getText().toString().equals("")){
                t.setText(cont + "");
                cont++;
            }
        }
    }
}