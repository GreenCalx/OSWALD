package com.example.oswald;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity
{

    private final int SPLASH_TIMER = 2500;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(
                new Runnable()
                {
                    @Override
                    public void run() {
                        Intent intent = new Intent(SplashScreen.this, ToolPickerActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, SPLASH_TIMER );
    }
}
