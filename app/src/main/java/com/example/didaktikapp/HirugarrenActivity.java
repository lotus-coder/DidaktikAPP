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
            public void onCompletion(MediaPlayer mp) {
                Uri uri= Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.aittita_makurra_audio);
                new AlertDialog.Builder(HirugarrenActivity.this)
                        .setTitle("Audioa")
                        .setMessage(uri.getPath().toString()+" Audioa entzun nahi duzu?")

                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton("Bai", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Uri uri= Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.aittita_makurra_audio);
                                MediaPlayer mp=new MediaPlayer();
                                try{
                                    mp.setDataSource(uri.getPath().toString());
                                    mp.prepare();
                                    mp.start();
                                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            new AlertDialog.Builder(HirugarrenActivity.this)
                                                    .setTitle("Audioa")
                                                    .setMessage(uri.getPath().toString()+"Testua irakurri nahi duzu?")

                                                    // Specifying a listener allows you to take an action before dismissing the dialog.
                                                    // The dialog is automatically dismissed when a dialog button is clicked.
                                                    .setPositiveButton("Bai", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int which) {
                                                        }
                                                    })

                                                    // A null listener allows the button to dismiss the dialog and take no further action.
                                                    .setNegativeButton("Ez", null)
                                                    .setIcon(android.R.drawable.ic_dialog_alert)
                                                    .show();
                                        }
                                    });
                                }
                                catch(Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        })
                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton("Ez", null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
    }
}