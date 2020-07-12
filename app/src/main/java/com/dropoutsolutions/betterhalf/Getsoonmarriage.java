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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Getsoonmarriage extends AppCompatActivity {

    TextView asap , one , three , four ;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soonmarreid);
        mauth = FirebaseAuth.getInstance() ;
        Currentuserid = mauth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(Currentuserid);
        asap = findViewById(R.id.asap);
        one = findViewById(R.id.onetwo);
        three = findViewById(R.id.threefour);
        four = findViewById(R.id.fourplus);

        asap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asap.setPadding(20, 10, 20, 10);
                asap.setBackgroundResource(R.drawable.edittextback);
                one.setBackgroundResource(R.drawable.resetbackground);
                three.setBackgroundResource(R.drawable.resetbackground);
                four.setBackgroundResource(R.drawable.resetbackground);
                HashMap<String, Object> user = new HashMap<>();
                user.put("SoonMarried" , asap.getText().toString());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent(Getsoonmarriage.this , ProfilesettingActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            finish();
                        }

                    }
                });

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
                HashMap<String, Object> user = new HashMap<>();
                user.put("SoonMarried" , one.getText().toString());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent(Getsoonmarriage.this , ProfilesettingActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            finish();
                        }

                    }
                });

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
                HashMap<String, Object> user = new HashMap<>();
                user.put("SoonMarried" , three.getText().toString());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent(Getsoonmarriage.this , ProfilesettingActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            finish();
                        }

                    }
                });


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
                HashMap<String, Object> user = new HashMap<>();
                user.put("SoonMarried" , four.getText().toString());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent(Getsoonmarriage.this , ProfilesettingActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            finish();
                        }

                    }
                });

            }
        });
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    protected void onStart() {
        super.onStart();
        userref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                {
                    if (snapshot.hasChild("SoonMarried"))
                    {
                        String soon = (String) snapshot.child("SoonMarried").getValue();
                        if (soon.equals(asap.getText()))
                        {
                            asap.setPadding(20, 10, 20, 10);
                            asap.setBackgroundResource(R.drawable.edittextback);
                            one.setBackgroundResource(R.drawable.resetbackground);
                            three.setBackgroundResource(R.drawable.resetbackground);
                            four.setBackgroundResource(R.drawable.resetbackground);
                        }
                        else if (soon.equals(one.getText()))
                        {
                            one.setPadding(20 , 10 , 20 , 10);
                            one.setBackgroundResource(R.drawable.edittextback);
                            asap.setBackgroundResource(R.drawable.resetbackground);
                            three.setBackgroundResource(R.drawable.resetbackground);
                            four.setBackgroundResource(R.drawable.resetbackground);
                        }
                        else if (soon.equals(three.getText()))
                        {
                            three.setPadding(20 , 10 , 20 , 10);
                            three.setBackgroundResource(R.drawable.edittextback);
                            asap.setBackgroundResource(R.drawable.resetbackground);
                            one.setBackgroundResource(R.drawable.resetbackground);
                            four.setBackgroundResource(R.drawable.resetbackground);
                        }
                        else
                        {
                            four.setPadding(20 , 10 , 20 , 10);
                            four.setBackgroundResource(R.drawable.edittextback);
                            asap.setBackgroundResource(R.drawable.resetbackground);
                            one.setBackgroundResource(R.drawable.resetbackground);
                            three.setBackgroundResource(R.drawable.resetbackground);
                        }
                    }


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}