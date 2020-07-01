package com.dropoutsolutions.betterhalf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;

public class MaritalstatusActivity extends AppCompatActivity {

    private TextView nevermarried , divorced ,seprated ,annulled , widowed ;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;
    String nickname ;
    String dob ;
    String gender ;
    String profession ;
    String prfileimage ;
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
        nickname = getIntent().getStringExtra("nickname");
        dob = getIntent().getStringExtra("dob");
        gender = getIntent().getStringExtra("gender");
        profession = getIntent().getStringExtra("profession");


        nevermarried.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nevermarried.setPadding(20 , 10 , 20 , 10);
                nevermarried.setBackgroundResource(R.drawable.edittextback);
                divorced.setBackgroundResource(R.drawable.resetbackground);
                seprated.setBackgroundResource(R.drawable.resetbackground);
                annulled.setBackgroundResource(R.drawable.resetbackground);
                widowed.setBackgroundResource(R.drawable.resetbackground);
                Intent intent = new Intent(MaritalstatusActivity.this , EducationActivity.class);
                intent.putExtra("gender" , gender);
                intent.putExtra("nickname" , nickname);
                intent.putExtra("dob" , dob);
                intent.putExtra("profession" ,profession);
                intent.putExtra("maritalstatus" , nevermarried.getText());
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        divorced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                divorced.setPadding(20 , 10 , 20 , 10);
                divorced.setBackgroundResource(R.drawable.edittextback);
                nevermarried.setBackgroundResource(R.drawable.resetbackground);
                seprated.setBackgroundResource(R.drawable.resetbackground);
                annulled.setBackgroundResource(R.drawable.resetbackground);
                widowed.setBackgroundResource(R.drawable.resetbackground);
                Intent intent = new Intent(MaritalstatusActivity.this , EducationActivity.class);
                intent.putExtra("gender" , gender);
                intent.putExtra("nickname" , nickname);
                intent.putExtra("dob" , dob);
                intent.putExtra("profession" ,profession);
                intent.putExtra("maritalstatus" , divorced.getText());
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });


        seprated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seprated.setPadding(20 , 10 , 20 , 10);
                seprated.setBackgroundResource(R.drawable.edittextback);
                nevermarried.setBackgroundResource(R.drawable.resetbackground);
                divorced.setBackgroundResource(R.drawable.resetbackground);
                annulled.setBackgroundResource(R.drawable.resetbackground);
                widowed.setBackgroundResource(R.drawable.resetbackground);
                Intent intent = new Intent(MaritalstatusActivity.this , EducationActivity.class);
                intent.putExtra("gender" , gender);
                intent.putExtra("nickname" , nickname);
                intent.putExtra("dob" , dob);
                intent.putExtra("profession" ,profession);
                intent.putExtra("maritalstatus" , seprated.getText());
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        annulled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                annulled.setPadding(20 , 10 , 20 , 10);
                annulled.setBackgroundResource(R.drawable.edittextback);
                nevermarried.setBackgroundResource(R.drawable.resetbackground);
                divorced.setBackgroundResource(R.drawable.resetbackground);
                seprated.setBackgroundResource(R.drawable.resetbackground);
                widowed.setBackgroundResource(R.drawable.resetbackground);
                Intent intent = new Intent(MaritalstatusActivity.this , EducationActivity.class);
                intent.putExtra("gender" , gender);
                intent.putExtra("nickname" , nickname);
                intent.putExtra("dob" , dob);
                intent.putExtra("profession" ,profession);
                intent.putExtra("maritalstatus" , annulled.getText());
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        widowed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                widowed.setPadding(20 , 10 , 20 , 10);
                widowed.setBackgroundResource(R.drawable.edittextback);
                nevermarried.setBackgroundResource(R.drawable.resetbackground);
                divorced.setBackgroundResource(R.drawable.resetbackground);
                seprated.setBackgroundResource(R.drawable.resetbackground);
                annulled.setBackgroundResource(R.drawable.resetbackground);
                Intent intent = new Intent(MaritalstatusActivity.this , EducationActivity.class);
                intent.putExtra("gender" , gender);
                intent.putExtra("nickname" , nickname);
                intent.putExtra("dob" , dob);
                intent.putExtra("profession" ,profession);
                intent.putExtra("maritalstatus" , widowed.getText());
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

}