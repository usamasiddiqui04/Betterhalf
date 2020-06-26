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

public class GetPrayingActivity extends AppCompatActivity {

    TextView apray , upray , spray , npray ;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pray);
        mauth = FirebaseAuth.getInstance() ;
        Currentuserid = mauth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(Currentuserid);
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
                HashMap<String, Object> user = new HashMap<>();
                user.put("Prayer" , apray.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent(GetPrayingActivity.this , ProfilesettingActivity.class));
                            finish();
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }

                    }

                });

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
                HashMap<String, Object> user = new HashMap<>();
                user.put("Prayer" , upray.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent(GetPrayingActivity.this , ProfilesettingActivity.class));
                            finish();
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }

                    }
                });

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
                HashMap<String, Object> user = new HashMap<>();
                user.put("Prayer" , spray.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent(GetPrayingActivity.this , ProfilesettingActivity.class));
                            finish();
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }

                    }
                });

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
                HashMap<String, Object> user = new HashMap<>();
                user.put("Prayer" , npray.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent(GetPrayingActivity.this , ProfilesettingActivity.class));
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
                    String pray = (String)dataSnapshot.child("Prayer").getValue();

                    if (pray.equals(apray))
                    {
                        apray.setPadding(20 , 10 , 20 , 10);
                        apray.setBackgroundResource(R.drawable.edittextback);
                        spray.setBackgroundResource(R.drawable.resetbackground);
                        npray.setBackgroundResource(R.drawable.resetbackground);
                        upray.setBackgroundResource(R.drawable.resetbackground);
                    }
                    else if (pray.equals(upray))
                    {
                        upray.setPadding(20, 10, 20, 10);
                        upray.setBackgroundResource(R.drawable.edittextback);
                        spray.setBackgroundResource(R.drawable.resetbackground);
                        npray.setBackgroundResource(R.drawable.resetbackground);
                        apray.setBackgroundResource(R.drawable.resetbackground);
                        HashMap<String, Object> user = new HashMap<>();
                    }
                    else if (pray.equals(spray))
                    {
                        spray.setPadding(20, 10, 20, 10);
                        spray.setBackgroundResource(R.drawable.edittextback);
                        upray.setBackgroundResource(R.drawable.resetbackground);
                        npray.setBackgroundResource(R.drawable.resetbackground);
                        apray.setBackgroundResource(R.drawable.resetbackground);
                    }
                    else
                    {
                        npray.setPadding(20, 10, 20, 10);
                        npray.setBackgroundResource(R.drawable.edittextback);
                        upray.setBackgroundResource(R.drawable.resetbackground);
                        spray.setBackgroundResource(R.drawable.resetbackground);
                        apray.setBackgroundResource(R.drawable.resetbackground);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}