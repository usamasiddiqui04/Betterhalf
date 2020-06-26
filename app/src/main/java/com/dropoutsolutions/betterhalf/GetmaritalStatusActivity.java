package com.dropoutsolutions.betterhalf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class GetmaritalStatusActivity extends AppCompatActivity {

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
                    if (task.isSuccessful()) {
                        startActivity(new Intent(GetmaritalStatusActivity.this, ProfilesettingActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        finish();
                    }

                }
            });
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
                        startActivity(new Intent(GetmaritalStatusActivity.this, ProfilesettingActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        finish();
                    }

                }
            });

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
                        startActivity(new Intent(GetmaritalStatusActivity.this, ProfilesettingActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        finish();
                    }

                }
            });

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
                    if (task.isSuccessful()) {
                        startActivity(new Intent(GetmaritalStatusActivity.this, ProfilesettingActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        finish();
                    }

                }
            });


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
                        startActivity(new Intent(GetmaritalStatusActivity.this, ProfilesettingActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        finish();
                    }
                }
            });

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
                    String s = (String) dataSnapshot.child("MaritalStatus").getValue();
                    if (s.equals(nevermarried.getText()))
                    {
                        nevermarried.setPadding(20 , 10 , 20 , 10);
                        nevermarried.setBackgroundResource(R.drawable.edittextback);
                        divorced.setBackgroundResource(R.drawable.resetbackground);
                        seprated.setBackgroundResource(R.drawable.resetbackground);
                        annulled.setBackgroundResource(R.drawable.resetbackground);
                        widowed.setBackgroundResource(R.drawable.resetbackground);
                    }
                    else if (s.equals(seprated.getText()))
                    {
                        seprated.setPadding(20 , 10 , 20 , 10);
                        seprated.setBackgroundResource(R.drawable.edittextback);
                        nevermarried.setBackgroundResource(R.drawable.resetbackground);
                        divorced.setBackgroundResource(R.drawable.resetbackground);
                        annulled.setBackgroundResource(R.drawable.resetbackground);
                        widowed.setBackgroundResource(R.drawable.resetbackground);
                    }
                    else if (s.equals(widowed.getText()))
                    {
                        widowed.setPadding(20 , 10 , 20 , 10);
                        widowed.setBackgroundResource(R.drawable.edittextback);
                        nevermarried.setBackgroundResource(R.drawable.resetbackground);
                        divorced.setBackgroundResource(R.drawable.resetbackground);
                        seprated.setBackgroundResource(R.drawable.resetbackground);
                        annulled.setBackgroundResource(R.drawable.resetbackground);
                    }
                    else if (s.equals(annulled.getText()))
                    {
                        annulled.setPadding(20 , 10 , 20 , 10);
                        annulled.setBackgroundResource(R.drawable.edittextback);
                        nevermarried.setBackgroundResource(R.drawable.resetbackground);
                        divorced.setBackgroundResource(R.drawable.resetbackground);
                        seprated.setBackgroundResource(R.drawable.resetbackground);
                        widowed.setBackgroundResource(R.drawable.resetbackground);
                    }
                    else
                    {
                        divorced.setPadding(20 , 10 , 20 , 10);
                        divorced.setBackgroundResource(R.drawable.edittextback);
                        nevermarried.setBackgroundResource(R.drawable.resetbackground);
                        seprated.setBackgroundResource(R.drawable.resetbackground);
                        annulled.setBackgroundResource(R.drawable.resetbackground);
                        widowed.setBackgroundResource(R.drawable.resetbackground);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}