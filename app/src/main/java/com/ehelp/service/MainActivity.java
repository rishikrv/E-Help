package com.ehelp.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run() {
                Intent d1Intent = new Intent(MainActivity.this ,home.class);
                startActivity(d1Intent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
