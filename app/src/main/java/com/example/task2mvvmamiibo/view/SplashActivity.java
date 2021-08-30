package com.example.task2mvvmamiibo.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.task2mvvmamiibo.R;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //start MainActivity after 2 second
                startActivity(new Intent(SplashActivity.this, AmiiboActivity.class));
                finish();
            }
        }, 3000);
    }
}