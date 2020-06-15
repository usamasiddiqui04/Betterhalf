package com.dropoutsolutions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import com.dropoutsolutions.betterhalf.EducationActivity;
import com.dropoutsolutions.betterhalf.MaritalstatusActivity;
import com.dropoutsolutions.betterhalf.R;
import com.dropoutsolutions.betterhalf.ReligionActivity;
import com.dropoutsolutions.betterhalf.SoonmarreidActivity;

public class PrayActivity extends AppCompatActivity {

    TextView  apray , upray , spray , npray ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pray);

        apray = findViewById(R.id.apray);
        upray = findViewById(R.id.upray);
        spray = findViewById(R.id.spray);
        npray = findViewById(R.id.npray);

        apray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apray.setPadding(20 , 10 , 20 , 10);
                apray.setBackgroundResource(R.drawable.edittextback);
                spray.setBackgroundResource(R.drawable.resetbackground);
                npray.setBackgroundResource(R.drawable.resetbackground);
                upray.setBackgroundResource(R.drawable.resetbackground);
                Handler mainLooperHandler = new Handler(Looper.getMainLooper());

                mainLooperHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(PrayActivity.this , SoonmarreidActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                    }
                }, 1000);
            }
        });

        upray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upray.setPadding(20, 10, 20, 10);
                upray.setBackgroundResource(R.drawable.edittextback);
                spray.setBackgroundResource(R.drawable.resetbackground);
                npray.setBackgroundResource(R.drawable.resetbackground);
                apray.setBackgroundResource(R.drawable.resetbackground);
                Handler mainLooperHandler = new Handler(Looper.getMainLooper());

                mainLooperHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(PrayActivity.this, SoonmarreidActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                    }
                }, 1000);
            }
        });


        spray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spray.setPadding(20, 10, 20, 10);
                spray.setBackgroundResource(R.drawable.edittextback);
                upray.setBackgroundResource(R.drawable.resetbackground);
                npray.setBackgroundResource(R.drawable.resetbackground);
                apray.setBackgroundResource(R.drawable.resetbackground);
                Handler mainLooperHandler = new Handler(Looper.getMainLooper());

                mainLooperHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(PrayActivity.this, SoonmarreidActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                    }
                }, 1000);
            }
        });

        npray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                npray.setPadding(20, 10, 20, 10);
                npray.setBackgroundResource(R.drawable.edittextback);
                upray.setBackgroundResource(R.drawable.resetbackground);
                spray.setBackgroundResource(R.drawable.resetbackground);
                apray.setBackgroundResource(R.drawable.resetbackground);
                Handler mainLooperHandler = new Handler(Looper.getMainLooper());

                mainLooperHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(PrayActivity.this, SoonmarreidActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                    }
                }, 1000);
            }
        });



    }
}