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
    String nickname ;
    String dob ;
    String gender ;
    String profession ;
    String prfileimage , maritalstatus , education , country , religion , prayer ;

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
        nickname = getIntent().getStringExtra("nickname");
        dob = getIntent().getStringExtra("dob");
        gender = getIntent().getStringExtra("gender");
        profession = getIntent().getStringExtra("profession");
        prfileimage = getIntent().getStringExtra("profileimage");
        maritalstatus = getIntent().getStringExtra("maritalstatus");
        education = getIntent().getStringExtra("educationlevel");
        country = getIntent().getStringExtra("country");
        religion = getIntent().getStringExtra("religion");
        prayer = getIntent().getStringExtra("prayer");

        asap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asap.setPadding(20, 10, 20, 10);
                asap.setBackgroundResource(R.drawable.edittextback);
                one.setBackgroundResource(R.drawable.resetbackground);
                three.setBackgroundResource(R.drawable.resetbackground);
                four.setBackgroundResource(R.drawable.resetbackground);
                Intent intent = new Intent(SoonmarreidActivity.this , EatActivity.class);
                intent.putExtra("gender" , gender);
                intent.putExtra("nickname" , nickname);
                intent.putExtra("dob" , dob);
                intent.putExtra("profession" ,profession);
                intent.putExtra("maritalstatus" , maritalstatus);
                intent.putExtra("educationlevel" , education);
                intent.putExtra("country" , country);
                intent.putExtra("religion" , religion);
                intent.putExtra("prayer" , prayer);
                intent.putExtra("soonmarried" , asap.getText());
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

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
                Intent intent = new Intent(SoonmarreidActivity.this , EatActivity.class);
                intent.putExtra("gender" , gender);
                intent.putExtra("nickname" , nickname);
                intent.putExtra("dob" , dob);
                intent.putExtra("profession" ,profession);
                intent.putExtra("maritalstatus" , maritalstatus);
                intent.putExtra("educationlevel" , education);
                intent.putExtra("country" , country);
                intent.putExtra("religion" , religion);
                intent.putExtra("prayer" , prayer);
                intent.putExtra("soonmarried" , one.getText());
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


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
                Intent intent = new Intent(SoonmarreidActivity.this , EatActivity.class);
                intent.putExtra("gender" , gender);
                intent.putExtra("nickname" , nickname);
                intent.putExtra("dob" , dob);
                intent.putExtra("profession" ,profession);
                intent.putExtra("maritalstatus" , maritalstatus);
                intent.putExtra("educationlevel" , education);
                intent.putExtra("country" , country);
                intent.putExtra("religion" , religion);
                intent.putExtra("prayer" , prayer);
                intent.putExtra("soonmarried" , three.getText());
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


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
                Intent intent = new Intent(SoonmarreidActivity.this , EatActivity.class);
                intent.putExtra("gender" , gender);
                intent.putExtra("nickname" , nickname);
                intent.putExtra("dob" , dob);
                intent.putExtra("profession" ,profession);
                intent.putExtra("maritalstatus" , maritalstatus);
                intent.putExtra("educationlevel" , education);
                intent.putExtra("country" , country);
                intent.putExtra("religion" , religion);
                intent.putExtra("prayer" , prayer);
                intent.putExtra("soonmarried" ,four.getText());
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