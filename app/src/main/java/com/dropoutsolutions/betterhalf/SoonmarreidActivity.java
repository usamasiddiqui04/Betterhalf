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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SoonmarreidActivity extends AppCompatActivity {

    TextView asap , one , three , four ;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;
    long mlastclicktime = 0 ;

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
                if (SystemClock.elapsedRealtime() - mlastclicktime < 1000 )
                    return;
                mlastclicktime = SystemClock.elapsedRealtime();
                asap.setPadding(20, 10, 20, 10);
                asap.setBackgroundResource(R.drawable.edittextback);
                one.setBackgroundResource(R.drawable.resetbackground);
                three.setBackgroundResource(R.drawable.resetbackground);
                four.setBackgroundResource(R.drawable.resetbackground);
                HashMap<String, Object> user = new HashMap<>();
                user.put("SoonMarried" , asap.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent(SoonmarreidActivity.this , EatActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }

                    }
                });

            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mlastclicktime < 1000 )
                    return;
                mlastclicktime = SystemClock.elapsedRealtime();
                one.setPadding(20 , 10 , 20 , 10);
                one.setBackgroundResource(R.drawable.edittextback);
                asap.setBackgroundResource(R.drawable.resetbackground);
                three.setBackgroundResource(R.drawable.resetbackground);
                four.setBackgroundResource(R.drawable.resetbackground);
                HashMap<String, Object> user = new HashMap<>();
                user.put("SoonMarried" , one.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent(SoonmarreidActivity.this , EatActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }

                    }
                });

            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mlastclicktime < 1000 )
                    return;
                mlastclicktime = SystemClock.elapsedRealtime();
                three.setPadding(20 , 10 , 20 , 10);
                three.setBackgroundResource(R.drawable.edittextback);
                asap.setBackgroundResource(R.drawable.resetbackground);
                one.setBackgroundResource(R.drawable.resetbackground);
                four.setBackgroundResource(R.drawable.resetbackground);
                HashMap<String, Object> user = new HashMap<>();
                user.put("SoonMarried" , three.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent(SoonmarreidActivity.this , EatActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }

                    }
                });


            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mlastclicktime < 1000 )
                    return;
                mlastclicktime = SystemClock.elapsedRealtime();
                four.setPadding(20 , 10 , 20 , 10);
                four.setBackgroundResource(R.drawable.edittextback);
                asap.setBackgroundResource(R.drawable.resetbackground);
                one.setBackgroundResource(R.drawable.resetbackground);
                three.setBackgroundResource(R.drawable.resetbackground);
                HashMap<String, Object> user = new HashMap<>();
                user.put("SoonMarried" , four.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent(SoonmarreidActivity.this , EatActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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
}