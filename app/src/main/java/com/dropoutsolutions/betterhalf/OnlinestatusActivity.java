package com.dropoutsolutions.betterhalf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class OnlinestatusActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth ;
    DatabaseReference userref ;
    String currentuser ;
    EditText name ;
    Button cont ;
    String getname ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onlinestatus);

        firebaseAuth = FirebaseAuth.getInstance() ;
        currentuser = firebaseAuth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(currentuser);
        name = findViewById(R.id.name);
        cont = findViewById(R.id.cont);

        cont.setOnClickListener(v -> {
            getname = name.getText().toString() ;
            if (getname.isEmpty())
            {
                name.setError("Please enter your status");
            }
            else
            {
                HashMap<String, Object> user = new HashMap<>();
                user.put("OnlineStatus" , name.getText().toString());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Intent intent = new Intent(OnlinestatusActivity.this , ProfilesettingActivity.class);
                            startActivity(intent);
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
                    String Name = (String) dataSnapshot.child("OnlineStatus").getValue();
                    name.setText(Name);
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