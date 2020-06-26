package com.dropoutsolutions.betterhalf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.ActionMode;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class EducationActivity extends AppCompatActivity {

    TextView bdegree , mdegree ,nondegree , college , doctorate ,other ;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;
    long mlastclicktime = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        mauth = FirebaseAuth.getInstance() ;
        Currentuserid = mauth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(Currentuserid);
        bdegree = findViewById(R.id.bachlorsdegree);
        mdegree = findViewById(R.id.master);
        nondegree = findViewById(R.id.nondegree);
        college = findViewById(R.id.college);
        doctorate = findViewById(R.id.doctorate);
        other = findViewById(R.id.other);

        bdegree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bdegree.setPadding(20 , 10 , 20 , 10);
                bdegree.setBackgroundResource(R.drawable.edittextback);
                mdegree.setBackgroundResource(R.drawable.resetbackground);
                nondegree.setBackgroundResource(R.drawable.resetbackground);
                college.setBackgroundResource(R.drawable.resetbackground);
                doctorate.setBackgroundResource(R.drawable.resetbackground);
                other.setBackgroundResource(R.drawable.resetbackground);
                HashMap<String, Object> user = new HashMap<>();
                user.put("EducationLevel" , bdegree.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent(EducationActivity.this, CountryActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }

                    }
                });

            }
        });


        mdegree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mdegree.setPadding(20 , 10 , 20 , 10);
                mdegree.setBackgroundResource(R.drawable.edittextback);
                bdegree.setBackgroundResource(R.drawable.resetbackground);
                nondegree.setBackgroundResource(R.drawable.resetbackground);
                college.setBackgroundResource(R.drawable.resetbackground);
                doctorate.setBackgroundResource(R.drawable.resetbackground);
                other.setBackgroundResource(R.drawable.resetbackground);
                HashMap<String, Object> user = new HashMap<>();
                user.put("EducationLevel" , mdegree.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(EducationActivity.this, CountryActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }
                    }
                });

            }
        });


        nondegree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nondegree.setPadding(20 , 10 , 20 , 10);
                nondegree.setBackgroundResource(R.drawable.edittextback);
                bdegree.setBackgroundResource(R.drawable.resetbackground);
                mdegree.setBackgroundResource(R.drawable.resetbackground);
                college.setBackgroundResource(R.drawable.resetbackground);
                doctorate.setBackgroundResource(R.drawable.resetbackground);
                HashMap<String, Object> user = new HashMap<>();
                user.put("EducationLevel" , nondegree.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent(EducationActivity.this, CountryActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                        }

                    }
                });

            }
        });

        college.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                college.setPadding(20 , 10 , 20 , 10);
                college.setBackgroundResource(R.drawable.edittextback);
                bdegree.setBackgroundResource(R.drawable.resetbackground);
                mdegree.setBackgroundResource(R.drawable.resetbackground);
                nondegree.setBackgroundResource(R.drawable.resetbackground);
                doctorate.setBackgroundResource(R.drawable.resetbackground);
                other.setBackgroundResource(R.drawable.resetbackground);
                HashMap<String, Object> user = new HashMap<>();
                user.put("EducationLevel" , college.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(EducationActivity.this, CountryActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }

                    }
                });
            }
        });

        doctorate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doctorate.setPadding(20 , 10 , 20 , 10);
                doctorate.setBackgroundResource(R.drawable.edittextback);
                bdegree.setBackgroundResource(R.drawable.resetbackground);
                mdegree.setBackgroundResource(R.drawable.resetbackground);
                college.setBackgroundResource(R.drawable.resetbackground);
                nondegree.setBackgroundResource(R.drawable.resetbackground);
                other.setBackgroundResource(R.drawable.resetbackground);
                HashMap<String, Object> user = new HashMap<>();
                user.put("EducationLevel" , doctorate.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent(EducationActivity.this, CountryActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }

                    }
                });
            }
        });

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                other.setPadding(20, 10, 20, 10);
                other.setBackgroundResource(R.drawable.edittextback);
                bdegree.setBackgroundResource(R.drawable.resetbackground);
                mdegree.setBackgroundResource(R.drawable.resetbackground);
                college.setBackgroundResource(R.drawable.resetbackground);
                nondegree.setBackgroundResource(R.drawable.resetbackground);
                doctorate.setBackgroundResource(R.drawable.resetbackground);
                HashMap<String, Object> user = new HashMap<>();
                user.put("EducationLevel", other.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(EducationActivity.this, CountryActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }

                    }
                });
            }
        });

    }

}