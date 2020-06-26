package com.dropoutsolutions.betterhalf;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class EditdobActivity extends AppCompatActivity {

    private DatePicker datePicker ;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;
    private String birthdaydate ;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_birthday);

        Button button = findViewById(R.id.cont);
        datePicker = findViewById(R.id.datePicker);
        mauth = FirebaseAuth.getInstance() ;
        Currentuserid = mauth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(Currentuserid);

        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                birthdaydate = i + "/" + i1 + "/" + i2 ;
            }
        });

        button.setOnClickListener(v -> {
            HashMap<String, Object> user = new HashMap<>();
            user.put("DateOfBirth" , birthdaydate);
            userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful())
                    {
                        startActivity(new Intent(EditdobActivity.this , ProfilesettingActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    }

                }
            });
        });

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}