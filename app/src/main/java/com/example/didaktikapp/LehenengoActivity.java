package com.example.didaktikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class LehenengoActivity extends AppCompatActivity {
        private TextView v1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_lehenengo);
            VideoView videoView =(VideoView)findViewById(R.id.videoView);

            //Creating MediaController
            MediaController mediaController= new MediaController(this);
            mediaController.setAnchorView(videoView);

            //specify the location of media file
            Uri uri= Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.aurkezpena);

            //Setting MediaController and URI, then starting the videoView
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.start();
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    Intent i = new Intent(LehenengoActivity.this,LehenengoTexto.class);
                    startActivity(i);
                }
            });
        }
}