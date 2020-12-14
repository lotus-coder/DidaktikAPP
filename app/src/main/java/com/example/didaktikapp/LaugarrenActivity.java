package com.example.didaktikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LaugarrenActivity extends AppCompatActivity {

    private TextView testua;
    private Button btnHurrengoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laugarren);
        btnHurrengoa = findViewById(R.id.btnLaugarren);
        testua = findViewById(R.id.testua4Act);
        testua.setText("Ikasi behar dutenaren testua (irakurri eta entzuteko)\n" +
                "Lekeition kokatuta dagoen irla bat da. Harriz egindako bide estu bat zeharkatu behar"+
                " da bertara heltzeko; malekoia izenekoa. Hori bai, marea behera egotea komeni da, bestela"+
                " bidea urak estaltzen du. Antzina, ermita bat eta konbentu bat zeuden. XVIII. mende amaieran kanoi"+
                " bi jarri zituzten islaren tontorrean, herria babesteko piraten eta bikingoengandik. Gaur egun, ez"+
                " dago orain aipatutako eraikinaren arrastorik. Horrez gain, orain dela urte asko Lepra pandemia bat"+
                " ere egon zen. Eta bertan, ospitale bat egin zuten gaixoak bertara joateko eta herrikoak ez kutsatzeko.");
        btnHurrengoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LaugarrenActivity.this,LaugarrenIrudiActivity.class);
                startActivity(i);
            }
        });
    }
}