package com.example.mcqapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView laview,loadd;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        laview = findViewById(R.id.quiz);
        loadd = findViewById(R.id.load);
        laview.playAnimation();
        loadd.playAnimation();

        boolean handler = new Handler().postDelayed(new Runnable(){
            @Override
            public void run()
            {
                Intent i = new Intent(MainActivity.this,mcqs.class);
                startActivity(i);
                finish();
            }
        },this,4000);
    }
}





