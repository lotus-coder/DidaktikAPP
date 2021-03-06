package com.example.didaktikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BigarrenTestua extends AppCompatActivity {

    private TextView txt;
    private Button btnHurrengoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bigarren_testua);
        txt = findViewById(R.id.textoSegundo);
        txt.setText("• KAXARRANKA: San Pedro eguneko prozesioa amaitu ostean egiten den Lekeitioko dantza famatua da hau. Zortzi gaztek eusten dute kaxa (mahoisko arropak jantzita) eta dantzari batek arin-arina, fandangoa eta zortzikoa dantzatzen ditu kaxaren goiko aldean. Kaxarranka ospatu den guztietan, Dantzaria gizonezkoa izan da, sekula ez du emakumezko batek dantzatu Lekeitioko dantza tradizional hau.\n" +
                "• EMAKUMEEN AURRESKUA: Dantza hau, San Juan egunean dantzatzeaz gain, lehen San Pedro egunean ere dantzatzen zen. Hiru saiotan banatzen da dantza hauen emanaldia: goizean, eguerdian eta gauean. Dantzariek, gona beltz eta koloretako mantoi dotoreak eramaten dituzte.");
        btnHurrengoa = findViewById(R.id.btnHurrengoa2);
        eventos();
    }

    private void eventos(){
        btnHurrengoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BigarrenTestua.this,SopaLetras.class);
                startActivity(i);
            }
        });
    }
}