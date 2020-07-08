package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Activity_splashScreen extends AppCompatActivity {
    private static int TIMEOUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        setTitle("Màn Hình Chào");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Activity_splashScreen.this, Bai2Activity.class);
                startActivity(intent);
                finish();
            }
        },
                TIMEOUT);
    }
}