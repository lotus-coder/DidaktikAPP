package com.example.didaktikapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class BostgarrenActivity extends AppCompatActivity
{
    private VideoView videoView;
    private MediaController mediaController;
    private TextView tvBostgarren;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bostgarren);

        //Preparar el video view
        videoView = (VideoView)findViewById(R.id.bostgarren_videoView);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        tvBostgarren = (TextView)findViewById(R.id.tvBostgarren);
        tvBostgarren.setText("Kostaldeko lurralde gehienetan bezala, Lekeitioko lurrak ere inoiz ez dira izan nekazaritza lantzeko lur onak. Horren ondorioz, laboreak errotetara eraman eta han lantzen zituzten. Baina, XVI. mendean lehorte-garai bat egon zen, eta horren ondorioz erreketan kokatuta zeuden errotek ez zuten funtzionatzen. Hortik, bururatu zitzaien errota hau eraikitzeko ideia; izan ere, errota hau marea-errota bat da. Hau da, marearen gorabeherekin funtzionatzen duen errota, horregatik errotak funtzionatzeko behar duen ura egongo dela bermatuta dago. Marea-errota hau eraikitzea garai hartan oso esanguratsua zen, zaila zelako eraikitzea eta gainera, marea-erroten ideia Europatik zabaldu zelako gurera. Horrez gain, leku horretan zehar ontziak ere ibili ahal ziren, errotarekin zuten komunikazioa ahalbidetuz. Azkenik, aipagarria da gaur egun Euskal Herrian oso gutxi aurkitzen direla.  ");

        eventos();
        iniciarVideoMarierrota();
    }

    private void eventos()
    {
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            public void onCompletion(MediaPlayer mp)
            {
                Intent intent = new Intent(BostgarrenActivity.this, BostgarrenGalderak.class);
                startActivity(intent);
            }
        });
    }

    public void butAudioListener(View view)
    {
        iniciarVideoMarierrota();
    }

    private void iniciarVideoMarierrota()
    {
        String url = "https://www.youtubetrimmer.com/view/?v=VyGwC4gH-DA&end=194";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    private void iniciarAudioMarierrota()
    {
        Uri uri= Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.marierrota_audioa);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();

        videoView.start();
    }
}