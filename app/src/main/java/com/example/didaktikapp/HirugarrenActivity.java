package com.example.didaktikapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class HirugarrenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hirugarren);

        //Creating MediaController
        MediaController mediaController= new MediaController(this);
        VideoView videoView = (VideoView)findViewById(R.id.vvHirugarren);
        mediaController.setAnchorView(videoView);

        //specify the location of media file
        Uri uri= Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.aittitamakurra_video);

        //Setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
    /*        public void onCompletion(MediaPlayer mp) {
                new AlertDialog.Builder(HirugarrenActivity.this)
                        .setTitle("Audioa")
                        .setMessage(uri.getPath().toString()+" Audioa entzun nahi duzu?")

                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton("Bai", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                MediaPlayer mp= MediaPlayer.create(HirugarrenActivity.this, R.raw.aittita_makurra_audio);
                                try{
                                    mp.start();
                                    if(mp.isPlaying()){
                                        Toast.makeText(getApplicationContext(),"Zahiatu berriro!",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override*/
            public void onCompletion(MediaPlayer mp) {
                new AlertDialog.Builder(HirugarrenActivity.this)
                        .setTitle("Testua")
                        .setMessage("Testua irakurri nahi duzu?")
                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton("Bai", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(HirugarrenActivity.this,HirugarrenActivityTestua.class);
                                startActivity(i);
                            }
                        })
                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton("Ez", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(HirugarrenActivity.this,KomikiActivity.class);
                                startActivity(i);
                            }
                        }).show();
            }
        });
    }
}