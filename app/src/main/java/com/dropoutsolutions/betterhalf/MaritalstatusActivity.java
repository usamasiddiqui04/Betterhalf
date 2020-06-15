package com.dropoutsolutions.betterhalf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import com.dropoutsolutions.betterhalf.Fragment.BirthdayFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.HashMap;

public class MaritalstatusActivity extends AppCompatActivity {

    TextView nevermarried , divorced ,seprated ,annulled , widowed ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maritalstatus);

        nevermarried = findViewById(R.id.never);
        divorced = findViewById(R.id.divorced);
        seprated = findViewById(R.id.seprated);
        annulled = findViewById(R.id.annulled);
        widowed = findViewById(R.id.widowed);

        nevermarried.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nevermarried.setPadding(20 , 10 , 20 , 10);
                nevermarried.setBackgroundResource(R.drawable.edittextback);
                divorced.setBackgroundResource(R.drawable.resetbackground);
                seprated.setBackgroundResource(R.drawable.resetbackground);
                annulled.setBackgroundResource(R.drawable.resetbackground);
                widowed.setBackgroundResource(R.drawable.resetbackground);
                Handler mainLooperHandler = new Handler(Looper.getMainLooper());

                mainLooperHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MaritalstatusActivity.this , EducationActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                    }
                }, 1000);
            }
        });

        divorced.setOnClickListener(v -> {
            divorced.setPadding(20 , 10 , 20 , 10);
            divorced.setBackgroundResource(R.drawable.edittextback);
            nevermarried.setBackgroundResource(R.drawable.resetbackground);
            seprated.setBackgroundResource(R.drawable.resetbackground);
            annulled.setBackgroundResource(R.drawable.resetbackground);
            widowed.setBackgroundResource(R.drawable.resetbackground);
            Handler mainLooperHandler = new Handler(Looper.getMainLooper());

            mainLooperHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(MaritalstatusActivity.this , EducationActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                }
            }, 1000);
        });

        seprated.setOnClickListener(v -> {
            seprated.setPadding(20 , 10 , 20 , 10);
            seprated.setBackgroundResource(R.drawable.edittextback);
            nevermarried.setBackgroundResource(R.drawable.resetbackground);
            divorced.setBackgroundResource(R.drawable.resetbackground);
            annulled.setBackgroundResource(R.drawable.resetbackground);
            widowed.setBackgroundResource(R.drawable.resetbackground);
            Handler mainLooperHandler = new Handler(Looper.getMainLooper());

            mainLooperHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(MaritalstatusActivity.this , EducationActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                }
            }, 1000);
        });

        annulled.setOnClickListener(v -> {
            annulled.setPadding(20 , 10 , 20 , 10);
            annulled.setBackgroundResource(R.drawable.edittextback);
            nevermarried.setBackgroundResource(R.drawable.resetbackground);
            divorced.setBackgroundResource(R.drawable.resetbackground);
            seprated.setBackgroundResource(R.drawable.resetbackground);
            widowed.setBackgroundResource(R.drawable.resetbackground);
            Handler mainLooperHandler = new Handler(Looper.getMainLooper());

            mainLooperHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(MaritalstatusActivity.this , EducationActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                }
            }, 1000);

        });

        widowed.setOnClickListener(v -> {
            widowed.setPadding(20 , 10 , 20 , 10);
            widowed.setBackgroundResource(R.drawable.edittextback);
            nevermarried.setBackgroundResource(R.drawable.resetbackground);
            divorced.setBackgroundResource(R.drawable.resetbackground);
            seprated.setBackgroundResource(R.drawable.resetbackground);
            annulled.setBackgroundResource(R.drawable.resetbackground);
            Handler mainLooperHandler = new Handler(Looper.getMainLooper());

            mainLooperHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(MaritalstatusActivity.this , EducationActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                }
            }, 1000);
        });
    }
}