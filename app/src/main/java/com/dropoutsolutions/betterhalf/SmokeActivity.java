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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SmokeActivity extends AppCompatActivity {

    TextView yes , no ;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;
    String nickname ;
    String dob ;
    String gender ;
    String profession ;
    String prfileimage , maritalstatus , education , country , religion , prayer , soonmarried , eat ;
    long mlastclicktime = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smoke);
        mauth = FirebaseAuth.getInstance() ;
        Currentuserid = mauth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(Currentuserid);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.No);
        nickname = getIntent().getStringExtra("nickname");
        dob = getIntent().getStringExtra("dob");
        gender = getIntent().getStringExtra("gender");
        profession = getIntent().getStringExtra("profession");
        maritalstatus = getIntent().getStringExtra("maritalstatus");
        education = getIntent().getStringExtra("educationlevel");
        country = getIntent().getStringExtra("country");
        religion = getIntent().getStringExtra("religion");
        prayer = getIntent().getStringExtra("prayer");
        eat = getIntent().getStringExtra("eat");
        soonmarried = getIntent().getStringExtra("soonmarried");
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yes.setPadding(20 , 10 , 20 , 10);
                yes.setBackgroundResource(R.drawable.edittextback);
                no.setBackgroundResource(R.drawable.resetbackground);

                Intent intent = new Intent(SmokeActivity.this , DrinkActivity.class);
                intent.putExtra("gender" , gender);
                intent.putExtra("nickname" , nickname);
                intent.putExtra("dob" , dob);
                intent.putExtra("profession" ,profession);
                intent.putExtra("maritalstatus" , maritalstatus);
                intent.putExtra("educationlevel" , education);
                intent.putExtra("country" , country);
                intent.putExtra("religion" , religion);
                intent.putExtra("prayer" , prayer);
                intent.putExtra("soonmarried" , soonmarried);
                intent.putExtra("eat" , eat);
                intent.putExtra("smoke" , yes.getText());
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                no.setPadding(20 , 10 , 20 , 10);
                no.setBackgroundResource(R.drawable.edittextback);
                yes.setBackgroundResource(R.drawable.resetbackground);

                Intent intent = new Intent(SmokeActivity.this , DrinkActivity.class);
                intent.putExtra("gender" , gender);
                intent.putExtra("nickname" , nickname);
                intent.putExtra("dob" , dob);
                intent.putExtra("profession" ,profession);
                intent.putExtra("maritalstatus" , maritalstatus);
                intent.putExtra("educationlevel" , education);
                intent.putExtra("country" , country);
                intent.putExtra("religion" , religion);
                intent.putExtra("prayer" , prayer);
                intent.putExtra("soonmarried" , soonmarried);
                intent.putExtra("eat" , eat);
                intent.putExtra("smoke" , no.getText());
                startActivity(intent);
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