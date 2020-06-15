package com.dropoutsolutions.betterhalf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import java.time.Year;

public class EatActivity extends AppCompatActivity {

    TextView yes , no ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat);

        yes = findViewById(R.id.yes);
        no = findViewById(R.id.No);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yes.setPadding(20 , 10 , 20 , 10);
                yes.setBackgroundResource(R.drawable.edittextback);
                no.setBackgroundResource(R.drawable.resetbackground);
                Handler mainLooperHandler = new Handler(Looper.getMainLooper());

                mainLooperHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(EatActivity.this , SmokeActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                    }
                }, 1000);
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no.setPadding(20 , 10 , 20 , 10);
                no.setBackgroundResource(R.drawable.edittextback);
                yes.setBackgroundResource(R.drawable.resetbackground);
                Handler mainLooperHandler = new Handler(Looper.getMainLooper());

                mainLooperHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(EatActivity.this , SmokeActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                    }
                }, 1000);
            }
        });
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}