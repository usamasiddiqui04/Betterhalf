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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class GenderActivity extends AppCompatActivity {
    private TextView male , female ;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;
    private String nickname ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.genderlayout);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        mauth = FirebaseAuth.getInstance() ;
        Currentuserid = mauth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(Currentuserid);
        nickname = getIntent().getStringExtra("nickname");
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setPadding(20 , 10 , 20 , 10);
                male.setBackgroundResource(R.drawable.edittextback);
                female.setBackgroundResource(R.drawable.resetbackground);
                Intent intent = new Intent(GenderActivity.this , BirthdayActivity.class);
                intent.putExtra("gender" , male.getText());
                intent.putExtra("nickname" , nickname);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

        female.setOnClickListener(v -> {
            female.setPadding(20, 10, 20, 10);
            female.setBackgroundResource(R.drawable.edittextback);
            male.setBackgroundResource(R.drawable.resetbackground);
            Intent intent = new Intent(GenderActivity.this , BirthdayActivity.class);
            intent.putExtra("gender" , female.getText());
            intent.putExtra("nickname" , nickname);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}