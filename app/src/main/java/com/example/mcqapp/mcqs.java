package com.example.mcqapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class mcqs extends AppCompatActivity {
    Button mcq,truef,ratee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcqs);
        mcq = findViewById(R.id.mcqs);
        truef = findViewById(R.id.truefalse);
        ratee = findViewById(R.id.rate);
        mcq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.mcqs:
                        Intent i = new Intent(mcqs.this,mcqqa.class);
                        startActivity(i);
                        break;
                }
            }
        });
        truef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.truefalse:
                        Intent i = new Intent(mcqs.this,truefalse.class);
                        startActivity(i);
                        break;
                }
            }
        });
        ratee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.rate:
                        try{
                            Uri uril = Uri.parse("https://play.google.com/store/apps/details?id=com.tencent.ig");
                            Intent market1 = new Intent(Intent.ACTION_VIEW,uril);
                            startActivity(market1);

                        }catch(ActivityNotFoundException e) {
                            Uri uril = Uri.parse("https://play.google.com/store/apps/details?id=com.tencent.ig");
                            Intent market1 = new Intent(Intent.ACTION_VIEW,uril);
                            startActivity(market1);
                        }
                        break;
                }

            }
        });


    }
}