package com.example.didaktikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HirugarrenActivityTestua extends AppCompatActivity {

    TextView txtTestua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hirugarren_testua);
        txtTestua = findViewById(R.id.txtHirugarren);
        txtTestua.setText("Ikasi behar dutenaren testua (irakurri eta entzuteko)\n" +
                "Lekeitioko Isuntza hondartzan kokatuta dagoen haitz bat da. Hemen kondairaren laburpena:\n" +
                "Orain dela urte asko, Lekeitioko balea harrapaitze trebeena portuan lanak egiten ari zen" +
                " bitartean zorabiatu eta lurrera erori zen konosimendua galduta. Herritar guztiek uste zuten " +
                "arrantzale hure hil egingo zela, egunak igaro baitzituen txalupa-etxen ensatu gabe. Baina, egun" +
                " batean, bera zaintzen zegoen marinelari dotore jantzita zihoan gizon bat agertu zitzaion (heriotza zen)" +
                " Isuntza hondartzan. Hark, esan zion ez zegola munduan medikurik arrantzale hura sendatuko zuenik, eta" +
                " konponbide bakarra berak zuela. Beraz, edaberako behar zituen osagaiak arrantzale gaztearekin partekatu" +
                " zituen esanez: “Zuk Lekeitioko herritar guztiak sendatuko dituzu edabe honekin. Hori gutxi balitz, urte" +
                " luzez biziko zara, 90 urtera arte, zure etxeko teilatuan belarra hasten hasten den arte”. Ordutik aurrera" +
                ", Lekeitioko sendagilerik ospetsuena bilakatu zen, eta horregatik, aittitta ezizenez zen ezaguna herrian." +
                " 90 urte bete zituenean, berriz egin zuen topo hasierako gizon berarekin. Momentu horretan, gizonak buruan" +
                " ukitu eta arrantzalea harri bihurtu zuen. Momentu hartatik aurrera, Lekeitio herriari hainbeste poztasun" +
                " eman zizkion arrantzalea Isuntza hondartzan dago harri bihurututa: aittitta makurra.");
    }
}