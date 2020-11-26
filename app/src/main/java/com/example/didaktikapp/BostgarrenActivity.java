package com.example.didaktikapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class BostgarrenActivity extends AppCompatActivity
{
    private VideoView videoView;
    private MediaController mediaController;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bostgarren);

        videoView = (VideoView)findViewById(R.id.bostgarren_videoView);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        iniciarVideo();
        eventos();
    }

    private void iniciarVideo()
    {
        //specify the location of media file
        Uri uri= Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.aurkezpena);

        //Setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();

        videoView.start();
    }

    private void eventos()
    {
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            public void onCompletion(MediaPlayer mp)
            {
                String url = "https://www.youtubetrimmer.com/view/?v=VyGwC4gH-DA&end=194";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                BostgarrenActivity.this.startActivityForResult(intent,1);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK )
        {
            MediaPlayer mp=new MediaPlayer();
            try{
                mp.setDataSource("/sdcard/Music/maine.mp3");//Write your location here
                mp.prepare();
                mp.start();

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}