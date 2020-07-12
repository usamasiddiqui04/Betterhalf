package com.dropoutsolutions.betterhalf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class EditEducationActivity extends AppCompatActivity {

    TextView bdegree , mdegree ,nondegree , college , doctorate ,other ;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;
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
                            startActivity(new Intent(EditEducationActivity.this, ProfilesettingActivity.class));
                            finish();
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
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent(EditEducationActivity.this, ProfilesettingActivity.class));
                            finish();
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
                            startActivity(new Intent(EditEducationActivity.this, ProfilesettingActivity.class));
                            finish();
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
                            startActivity(new Intent(EditEducationActivity.this, ProfilesettingActivity.class));
                            finish();
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
                            startActivity(new Intent(EditEducationActivity.this, ProfilesettingActivity.class));
                            finish();
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
                            startActivity(new Intent(EditEducationActivity.this, ProfilesettingActivity.class));
                            finish();
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }

                    }
                });


            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        userref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    if (dataSnapshot.hasChild("EducationLevel"))
                    {
                        String education = (String) dataSnapshot.child("EducationLevel").getValue();

                        if (education.equals(other.getText()))
                        {
                            other.setPadding(20, 10, 20, 10);
                            other.setBackgroundResource(R.drawable.edittextback);
                            bdegree.setBackgroundResource(R.drawable.resetbackground);
                            mdegree.setBackgroundResource(R.drawable.resetbackground);
                            college.setBackgroundResource(R.drawable.resetbackground);
                            nondegree.setBackgroundResource(R.drawable.resetbackground);
                            doctorate.setBackgroundResource(R.drawable.resetbackground);
                        }
                        else if (education.equals(doctorate.getText()))
                        {
                            doctorate.setPadding(20 , 10 , 20 , 10);
                            doctorate.setBackgroundResource(R.drawable.edittextback);
                            bdegree.setBackgroundResource(R.drawable.resetbackground);
                            mdegree.setBackgroundResource(R.drawable.resetbackground);
                            college.setBackgroundResource(R.drawable.resetbackground);
                            nondegree.setBackgroundResource(R.drawable.resetbackground);
                            other.setBackgroundResource(R.drawable.resetbackground);
                        }
                        else if (education.equals(college.getText()))
                        {
                            college.setPadding(20 , 10 , 20 , 10);
                            college.setBackgroundResource(R.drawable.edittextback);
                            bdegree.setBackgroundResource(R.drawable.resetbackground);
                            mdegree.setBackgroundResource(R.drawable.resetbackground);
                            nondegree.setBackgroundResource(R.drawable.resetbackground);
                            doctorate.setBackgroundResource(R.drawable.resetbackground);
                            other.setBackgroundResource(R.drawable.resetbackground);
                        }
                        else if (education.equals(nondegree.getText()))
                        {
                            nondegree.setPadding(20 , 10 , 20 , 10);
                            nondegree.setBackgroundResource(R.drawable.edittextback);
                            bdegree.setBackgroundResource(R.drawable.resetbackground);
                            mdegree.setBackgroundResource(R.drawable.resetbackground);
                            college.setBackgroundResource(R.drawable.resetbackground);
                            doctorate.setBackgroundResource(R.drawable.resetbackground);
                        }
                        else if (education.equals(mdegree.getText()))
                        {
                            mdegree.setPadding(20 , 10 , 20 , 10);
                            mdegree.setBackgroundResource(R.drawable.edittextback);
                            bdegree.setBackgroundResource(R.drawable.resetbackground);
                            nondegree.setBackgroundResource(R.drawable.resetbackground);
                            college.setBackgroundResource(R.drawable.resetbackground);
                            doctorate.setBackgroundResource(R.drawable.resetbackground);
                        }
                        else if (education.equals(bdegree.getText()))
                        {
                            bdegree.setPadding(20 , 10 , 20 , 10);
                            bdegree.setBackgroundResource(R.drawable.edittextback);
                            mdegree.setBackgroundResource(R.drawable.resetbackground);
                            nondegree.setBackgroundResource(R.drawable.resetbackground);
                            college.setBackgroundResource(R.drawable.resetbackground);
                            doctorate.setBackgroundResource(R.drawable.resetbackground);
                            other.setBackgroundResource(R.drawable.resetbackground);
                        }

                    }


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this , ProfilesettingActivity.class));
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }
}