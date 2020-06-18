package com.dropoutsolutions.betterhalf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

import com.dropoutsolutions.PrayActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ReligionActivity extends AppCompatActivity {

    TextView verypractising , practising ,modepractsing , notpractising ;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;
    long mlastclicktime = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_religion);
        mauth = FirebaseAuth.getInstance() ;
        Currentuserid = mauth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(Currentuserid);
        verypractising = findViewById(R.id.vpractising);
        practising = findViewById(R.id.practising);
        modepractsing = findViewById(R.id.mpractising);
        notpractising = findViewById(R.id.cnpractising);

        verypractising.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlastclicktime = SystemClock.elapsedRealtime();
                verypractising.setPadding(20, 10, 20, 10);
                verypractising.setBackgroundResource(R.drawable.edittextback);
                practising.setBackgroundResource(R.drawable.resetbackground);
                modepractsing.setBackgroundResource(R.drawable.resetbackground);
                notpractising.setBackgroundResource(R.drawable.resetbackground);
                HashMap<String, Object> user = new HashMap<>();
                user.put("Religious" , verypractising.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {

                        }

                    }
                });
                startActivity(new Intent(ReligionActivity.this, PrayActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        practising.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlastclicktime = SystemClock.elapsedRealtime();
                practising.setPadding(20, 10, 20, 10);
                practising.setBackgroundResource(R.drawable.edittextback);
                verypractising.setBackgroundResource(R.drawable.resetbackground);
                modepractsing.setBackgroundResource(R.drawable.resetbackground);
                notpractising.setBackgroundResource(R.drawable.resetbackground);
                HashMap<String, Object> user = new HashMap<>();
                user.put("Religious" , practising.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {

                        }

                    }
                });
                startActivity(new Intent(ReligionActivity.this, PrayActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        modepractsing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlastclicktime = SystemClock.elapsedRealtime();
                modepractsing.setPadding(20 , 10 , 20 , 10);
                modepractsing.setBackgroundResource(R.drawable.edittextback);
                verypractising.setBackgroundResource(R.drawable.resetbackground);
                practising.setBackgroundResource(R.drawable.resetbackground);
                notpractising.setBackgroundResource(R.drawable.resetbackground);
                HashMap<String, Object> user = new HashMap<>();
                user.put("Religious" , modepractsing.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {

                        }

                    }
                });
                startActivity(new Intent(ReligionActivity.this, PrayActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        notpractising.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlastclicktime = SystemClock.elapsedRealtime();
                notpractising.setPadding(20 , 10 , 20 , 10);
                notpractising.setBackgroundResource(R.drawable.edittextback);
                verypractising.setBackgroundResource(R.drawable.resetbackground);
                practising.setBackgroundResource(R.drawable.resetbackground);
                modepractsing.setBackgroundResource(R.drawable.resetbackground);
                HashMap<String, Object> user = new HashMap<>();
                user.put("Religious" , notpractising.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {

                        }

                    }
                });
                startActivity(new Intent(ReligionActivity.this, PrayActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}