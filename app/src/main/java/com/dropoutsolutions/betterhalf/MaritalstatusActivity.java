package com.dropoutsolutions.betterhalf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;

public class MaritalstatusActivity extends AppCompatActivity {

    TextView nevermarried , divorced ,seprated ,annulled , widowed ;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maritalstatus);
        mauth = FirebaseAuth.getInstance() ;
        Currentuserid = mauth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(Currentuserid);

        nevermarried = findViewById(R.id.never);
        divorced = findViewById(R.id.divorced);
        seprated = findViewById(R.id.seprated);
        annulled = findViewById(R.id.annulled);
        widowed = findViewById(R.id.widowed);



        nevermarried.setOnClickListener(v -> {
            nevermarried.setPadding(20 , 10 , 20 , 10);
            nevermarried.setBackgroundResource(R.drawable.edittextback);
            divorced.setBackgroundResource(R.drawable.resetbackground);
            seprated.setBackgroundResource(R.drawable.resetbackground);
            annulled.setBackgroundResource(R.drawable.resetbackground);
            widowed.setBackgroundResource(R.drawable.resetbackground);
            HashMap<String, Object> user = new HashMap<>();
            user.put("MaritalStatus" , nevermarried.getText());
            userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful())
                    {

                    }

                }
            });
            Intent intent = new Intent(MaritalstatusActivity.this , EducationActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

        divorced.setOnClickListener(v -> {
            divorced.setPadding(20 , 10 , 20 , 10);
            divorced.setBackgroundResource(R.drawable.edittextback);
            nevermarried.setBackgroundResource(R.drawable.resetbackground);
            seprated.setBackgroundResource(R.drawable.resetbackground);
            annulled.setBackgroundResource(R.drawable.resetbackground);
            widowed.setBackgroundResource(R.drawable.resetbackground);
            HashMap<String, Object> user = new HashMap<>();
            user.put("MaritalStatus" , divorced.getText());
            userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful())
                    {

                    }

                }
            });
            Intent intent = new Intent(MaritalstatusActivity.this , EducationActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        });

        seprated.setOnClickListener(v -> {
            seprated.setPadding(20 , 10 , 20 , 10);
            seprated.setBackgroundResource(R.drawable.edittextback);
            nevermarried.setBackgroundResource(R.drawable.resetbackground);
            divorced.setBackgroundResource(R.drawable.resetbackground);
            annulled.setBackgroundResource(R.drawable.resetbackground);
            widowed.setBackgroundResource(R.drawable.resetbackground);
            HashMap<String, Object> user = new HashMap<>();
            user.put("MaritalStatus" , seprated.getText());
            userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful())
                    {


                    }

                }
            });
            Intent intent = new Intent(MaritalstatusActivity.this , EducationActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

        annulled.setOnClickListener(v -> {
            annulled.setPadding(20 , 10 , 20 , 10);
            annulled.setBackgroundResource(R.drawable.edittextback);
            nevermarried.setBackgroundResource(R.drawable.resetbackground);
            divorced.setBackgroundResource(R.drawable.resetbackground);
            seprated.setBackgroundResource(R.drawable.resetbackground);
            widowed.setBackgroundResource(R.drawable.resetbackground);
            HashMap<String, Object> user = new HashMap<>();
            user.put("MaritalStatus" , annulled.getText());
            userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful())
                    {


                    }

                }
            });
            Intent intent = new Intent(MaritalstatusActivity.this , EducationActivity.class);
            startActivity(intent);

            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        });

        widowed.setOnClickListener(v -> {
            widowed.setPadding(20 , 10 , 20 , 10);
            widowed.setBackgroundResource(R.drawable.edittextback);
            nevermarried.setBackgroundResource(R.drawable.resetbackground);
            divorced.setBackgroundResource(R.drawable.resetbackground);
            seprated.setBackgroundResource(R.drawable.resetbackground);
            annulled.setBackgroundResource(R.drawable.resetbackground);
            HashMap<String, Object> user = new HashMap<>();
            user.put("MaritalStatus" , widowed.getText());
            userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful())
                    {

                    }

                }
            });
            Intent intent = new Intent(MaritalstatusActivity.this , EducationActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        });
    }

}