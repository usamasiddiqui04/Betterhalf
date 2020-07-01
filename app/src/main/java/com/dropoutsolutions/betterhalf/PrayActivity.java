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

public class PrayActivity extends AppCompatActivity {

    TextView  apray , upray , spray , npray ;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;
    long mlastclicktime = 0 ;
    String nickname ;
    String dob ;
    String gender ;
    String profession ;
    String prfileimage , maritalstatus , education , country , religion ;
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
        nickname = getIntent().getStringExtra("nickname");
        dob = getIntent().getStringExtra("dob");
        gender = getIntent().getStringExtra("gender");
        profession = getIntent().getStringExtra("profession");
        prfileimage = getIntent().getStringExtra("profileimage");
        maritalstatus = getIntent().getStringExtra("maritalstatus");
        education = getIntent().getStringExtra("educationlevel");
        country = getIntent().getStringExtra("country");
        religion = getIntent().getStringExtra("religion");

        apray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apray.setPadding(20 , 10 , 20 , 10);
                apray.setBackgroundResource(R.drawable.edittextback);
                spray.setBackgroundResource(R.drawable.resetbackground);
                npray.setBackgroundResource(R.drawable.resetbackground);
                upray.setBackgroundResource(R.drawable.resetbackground);

                Intent intent = new Intent(PrayActivity.this , SoonmarreidActivity.class);
                intent.putExtra("gender" , gender);
                intent.putExtra("nickname" , nickname);
                intent.putExtra("dob" , dob);
                intent.putExtra("profession" ,profession);
                intent.putExtra("educationlevel" , education);
                intent.putExtra("country" , country);
                intent.putExtra("religion" , religion);
                intent.putExtra("prayer" , apray.getText());
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

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
                Intent intent = new Intent(PrayActivity.this , SoonmarreidActivity.class);
                intent.putExtra("gender" , gender);
                intent.putExtra("nickname" , nickname);
                intent.putExtra("dob" , dob);
                intent.putExtra("profession" ,profession);
                intent.putExtra("maritalstatus" , maritalstatus);
                intent.putExtra("educationlevel" , education);
                intent.putExtra("country" , country);
                intent.putExtra("religion" , religion);
                intent.putExtra("prayer" , upray.getText());
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

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
                Intent intent = new Intent(PrayActivity.this , SoonmarreidActivity.class);
                intent.putExtra("gender" , gender);
                intent.putExtra("nickname" , nickname);
                intent.putExtra("dob" , dob);
                intent.putExtra("profession" ,profession);
                intent.putExtra("maritalstatus" , maritalstatus);
                intent.putExtra("educationlevel" , education);
                intent.putExtra("country" , country);
                intent.putExtra("religion" , religion);
                intent.putExtra("prayer" , spray.getText());
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

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
                Intent intent = new Intent(PrayActivity.this , SoonmarreidActivity.class);
                intent.putExtra("gender" , gender);
                intent.putExtra("nickname" , nickname);
                intent.putExtra("dob" , dob);
                intent.putExtra("profession" ,profession);
                intent.putExtra("maritalstatus" , maritalstatus);
                intent.putExtra("educationlevel" , education);
                intent.putExtra("country" , country);
                intent.putExtra("religion" , religion);
                intent.putExtra("prayer" , apray.getText());
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