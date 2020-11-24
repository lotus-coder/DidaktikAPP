package com.example.didaktikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private ImageView imgHasiera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btnLehenengo);
        imgHasiera = findViewById(R.id.imageView);
        imgHasiera.setImageURI(Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.hasiera));
/*
        imgHasiera.setScaleType(ImageView.ScaleType.CENTER_CROP);
*/
        eventos();
    }

    private void eventos() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,LehenengoActivity.class);
                startActivity(i);
            }
        });
    }
}