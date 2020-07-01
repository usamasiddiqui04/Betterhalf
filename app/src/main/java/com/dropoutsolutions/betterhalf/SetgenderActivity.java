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
import com.dropoutsolutions.betterhalf.Fragment.Gender;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class SetgenderActivity extends AppCompatActivity {

    private TextView male , female ;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.genderlayout);

        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        mauth = FirebaseAuth.getInstance() ;
        Currentuserid = mauth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(Currentuserid);


        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setPadding(20 , 10 , 20 , 10);
                male.setBackgroundResource(R.drawable.edittextback);
                female.setBackgroundResource(R.drawable.resetbackground);

                HashMap<String, Object> user = new HashMap<>();
                user.put("Gender" , male.getText().toString());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Intent intent = new Intent(SetgenderActivity.this , ProfilesettingActivity.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            finish();
                        }

                    }
                });
            }
        });

        female.setOnClickListener(v -> {
            female.setPadding(20, 10, 20, 10);
            female.setBackgroundResource(R.drawable.edittextback);
            male.setBackgroundResource(R.drawable.resetbackground);
            HashMap<String, Object> user = new HashMap<>();
            user.put("Gender", female.getText().toString());
            userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Intent intent = new Intent(SetgenderActivity.this , ProfilesettingActivity.class);
                        startActivity(intent);
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
                    String sex = (String) dataSnapshot.child("Gender").getValue();

                    if (sex.equals("Male"))
                    {
                        male.setPadding(20 , 10 , 20 , 10);
                        male.setBackgroundResource(R.drawable.edittextback);
                        female.setBackgroundResource(R.drawable.resetbackground);
                    }
                    else
                    {
                        female.setPadding(20, 10, 20, 10);
                        female.setBackgroundResource(R.drawable.edittextback);
                        male.setBackgroundResource(R.drawable.resetbackground);
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
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this , ProfilesettingActivity.class));
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }
}