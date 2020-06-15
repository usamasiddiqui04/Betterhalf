package com.dropoutsolutions.betterhalf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import com.dropoutsolutions.PrayActivity;

public class ReligionActivity extends AppCompatActivity {

    TextView verypractising , practising ,modepractsing , notpractising ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_religion);

        verypractising = findViewById(R.id.vpractising);
        practising = findViewById(R.id.practising);
        modepractsing = findViewById(R.id.mpractising);
        notpractising = findViewById(R.id.cnpractising);

        verypractising.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verypractising.setPadding(20 , 10 , 20 , 10);
                verypractising.setBackgroundResource(R.drawable.edittextback);
                practising.setBackgroundResource(R.drawable.resetbackground);
                modepractsing.setBackgroundResource(R.drawable.resetbackground);
                notpractising.setBackgroundResource(R.drawable.resetbackground);
                Handler mainLooperHandler = new Handler(Looper.getMainLooper());

                mainLooperHandler.postDelayed(() ->
                        startActivity(new Intent(ReligionActivity.this , PrayActivity.class)), 1000);

            }
        });

        practising.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                practising.setPadding(20 , 10 , 20 , 10);
                practising.setBackgroundResource(R.drawable.edittextback);
                verypractising.setBackgroundResource(R.drawable.resetbackground);
                modepractsing.setBackgroundResource(R.drawable.resetbackground);
                notpractising.setBackgroundResource(R.drawable.resetbackground);
                Handler mainLooperHandler = new Handler(Looper.getMainLooper());

                mainLooperHandler.postDelayed(() ->
                        startActivity(new Intent(ReligionActivity.this , PrayActivity.class)), 1000);
            }
        });

        modepractsing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modepractsing.setPadding(20 , 10 , 20 , 10);
                modepractsing.setBackgroundResource(R.drawable.edittextback);
                verypractising.setBackgroundResource(R.drawable.resetbackground);
                practising.setBackgroundResource(R.drawable.resetbackground);
                notpractising.setBackgroundResource(R.drawable.resetbackground);
                Handler mainLooperHandler = new Handler(Looper.getMainLooper());

                mainLooperHandler.postDelayed(() ->
                        startActivity(new Intent(ReligionActivity.this , PrayActivity.class)), 1000);
            }
        });

        notpractising.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notpractising.setPadding(20 , 10 , 20 , 10);
                notpractising.setBackgroundResource(R.drawable.edittextback);
                verypractising.setBackgroundResource(R.drawable.resetbackground);
                practising.setBackgroundResource(R.drawable.resetbackground);
                modepractsing.setBackgroundResource(R.drawable.resetbackground);
                Handler mainLooperHandler = new Handler(Looper.getMainLooper());

                mainLooperHandler.postDelayed(() ->
                        startActivity(new Intent(ReligionActivity.this , PrayActivity.class)), 1000);
            }
        });
    }
}