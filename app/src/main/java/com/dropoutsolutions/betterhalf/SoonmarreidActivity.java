package com.dropoutsolutions.betterhalf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import com.dropoutsolutions.PrayActivity;

public class SoonmarreidActivity extends AppCompatActivity {

    TextView asap , one , three , four ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soonmarreid);

        asap = findViewById(R.id.asap);
        one = findViewById(R.id.onetwo);
        three = findViewById(R.id.threefour);
        four = findViewById(R.id.fourplus);

        asap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asap.setPadding(20 , 10 , 20 , 10);
                asap.setBackgroundResource(R.drawable.edittextback);
                one.setBackgroundResource(R.drawable.resetbackground);
                three.setBackgroundResource(R.drawable.resetbackground);
                four.setBackgroundResource(R.drawable.resetbackground);
                Handler mainLooperHandler = new Handler(Looper.getMainLooper());

                mainLooperHandler.postDelayed(() ->
                        startActivity(new Intent(SoonmarreidActivity.this , EatActivity.class)), 1000);

            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one.setPadding(20 , 10 , 20 , 10);
                one.setBackgroundResource(R.drawable.edittextback);
                asap.setBackgroundResource(R.drawable.resetbackground);
                three.setBackgroundResource(R.drawable.resetbackground);
                four.setBackgroundResource(R.drawable.resetbackground);
                Handler mainLooperHandler = new Handler(Looper.getMainLooper());

                mainLooperHandler.postDelayed(() ->
                        startActivity(new Intent(SoonmarreidActivity.this , EatActivity.class)), 1000);

            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                three.setPadding(20 , 10 , 20 , 10);
                three.setBackgroundResource(R.drawable.edittextback);
                asap.setBackgroundResource(R.drawable.resetbackground);
                one.setBackgroundResource(R.drawable.resetbackground);
                four.setBackgroundResource(R.drawable.resetbackground);
                Handler mainLooperHandler = new Handler(Looper.getMainLooper());

                mainLooperHandler.postDelayed(() ->
                        startActivity(new Intent(SoonmarreidActivity.this , EatActivity.class)), 1000);

            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                four.setPadding(20 , 10 , 20 , 10);
                four.setBackgroundResource(R.drawable.edittextback);
                asap.setBackgroundResource(R.drawable.resetbackground);
                one.setBackgroundResource(R.drawable.resetbackground);
                three.setBackgroundResource(R.drawable.resetbackground);
                Handler mainLooperHandler = new Handler(Looper.getMainLooper());

                mainLooperHandler.postDelayed(() ->
                        startActivity(new Intent(SoonmarreidActivity.this , EatActivity.class)), 1000);

            }
        });
    }
}