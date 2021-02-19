package com.example.didaktikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class BigarrenVideo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bigarren_video);
        MediaController mediaController= new MediaController(this);
        VideoView videoView = (VideoView)findViewById(R.id.vvBigarren);
        mediaController.setAnchorView(videoView);

        //specify the location of media file
        Uri uri= Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.kaxarrankalekeitio);

        //Setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(BigarrenVideo.this,BigarrenTestua.class);
                startActivity(i);
            }
        });
    }
}