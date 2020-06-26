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

public class GetAlcoholActivity extends AppCompatActivity {

    TextView yes , no ;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        mauth = FirebaseAuth.getInstance() ;
        Currentuserid = mauth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(Currentuserid);

        yes = findViewById(R.id.yes);
        no = findViewById(R.id.No);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                yes.setPadding(20 , 10 , 20 , 10);
                yes.setBackgroundResource(R.drawable.edittextback);
                no.setBackgroundResource(R.drawable.resetbackground);
                HashMap<String, Object> user = new HashMap<>();
                user.put("Drink" , yes.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent(GetAlcoholActivity.this , ProfilesettingActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            finish();
                        }

                    }

                });

            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                no.setPadding(20 , 10 , 20 , 10);
                no.setBackgroundResource(R.drawable.edittextback);
                yes.setBackgroundResource(R.drawable.resetbackground);
                HashMap<String, Object> user = new HashMap<>();
                user.put("Drink" , no.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent(GetAlcoholActivity.this , ProfilesettingActivity.class));
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
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    String convert = (String)dataSnapshot.child("Drink").getValue();

                    if (convert.equals(yes.getText()))
                    {
                        yes.setPadding(20 , 10 , 20 , 10);
                        yes.setBackgroundResource(R.drawable.edittextback);
                        no.setBackgroundResource(R.drawable.resetbackground);
                    }
                    else
                    {
                        no.setPadding(20 , 10 , 20 , 10);
                        no.setBackgroundResource(R.drawable.edittextback);
                        yes.setBackgroundResource(R.drawable.resetbackground);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}