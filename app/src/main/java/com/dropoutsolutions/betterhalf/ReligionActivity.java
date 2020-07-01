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

public class ReligionActivity extends AppCompatActivity {

    TextView verypractising , practising ,modepractsing , notpractising ;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;
    String nickname ;
    String dob ;
    String gender ;
    String profession ;
    String prfileimage , maritalstatus , education , country ;
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
        nickname = getIntent().getStringExtra("nickname");
        dob = getIntent().getStringExtra("dob");
        gender = getIntent().getStringExtra("gender");
        profession = getIntent().getStringExtra("profession");
        maritalstatus = getIntent().getStringExtra("maritalstatus");
        education = getIntent().getStringExtra("educationlevel");
        country = getIntent().getStringExtra("country");
        verypractising.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verypractising.setPadding(20, 10, 20, 10);
                verypractising.setBackgroundResource(R.drawable.edittextback);
                practising.setBackgroundResource(R.drawable.resetbackground);
                modepractsing.setBackgroundResource(R.drawable.resetbackground);
                notpractising.setBackgroundResource(R.drawable.resetbackground);
                Intent intent = new Intent(ReligionActivity.this, PrayActivity.class);
                intent.putExtra("gender" , gender);
                intent.putExtra("nickname" , nickname);
                intent.putExtra("dob" , dob);
                intent.putExtra("profession" ,profession);
                intent.putExtra("maritalstatus" , maritalstatus);
                intent.putExtra("educationlevel" , education);
                intent.putExtra("country" , country);
                intent.putExtra("religion" , verypractising.getText());
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

        practising.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                practising.setPadding(20, 10, 20, 10);
                practising.setBackgroundResource(R.drawable.edittextback);
                verypractising.setBackgroundResource(R.drawable.resetbackground);
                modepractsing.setBackgroundResource(R.drawable.resetbackground);
                notpractising.setBackgroundResource(R.drawable.resetbackground);
                Intent intent = new Intent(ReligionActivity.this, PrayActivity.class);
                intent.putExtra("gender" , gender);
                intent.putExtra("nickname" , nickname);
                intent.putExtra("dob" , dob);
                intent.putExtra("profession" ,profession);
                intent.putExtra("maritalstatus" , maritalstatus);
                intent.putExtra("educationlevel" , education);
                intent.putExtra("country" , country);
                intent.putExtra("religion" , practising.getText());
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        modepractsing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modepractsing.setPadding(20 , 10 , 20 , 10);
                modepractsing.setBackgroundResource(R.drawable.edittextback);
                verypractising.setBackgroundResource(R.drawable.resetbackground);
                practising.setBackgroundResource(R.drawable.resetbackground);
                notpractising.setBackgroundResource(R.drawable.resetbackground);
                Intent intent = new Intent(ReligionActivity.this, PrayActivity.class);
                intent.putExtra("gender" , gender);
                intent.putExtra("nickname" , nickname);
                intent.putExtra("dob" , dob);
                intent.putExtra("profession" ,profession);
                intent.putExtra("maritalstatus" , maritalstatus);
                intent.putExtra("educationlevel" , education);
                intent.putExtra("country" , country);
                intent.putExtra("religion" , modepractsing.getText());
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

        notpractising.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notpractising.setPadding(20 , 10 , 20 , 10);
                notpractising.setBackgroundResource(R.drawable.edittextback);
                verypractising.setBackgroundResource(R.drawable.resetbackground);
                practising.setBackgroundResource(R.drawable.resetbackground);
                modepractsing.setBackgroundResource(R.drawable.resetbackground);
                Intent intent = new Intent(ReligionActivity.this, PrayActivity.class);
                intent.putExtra("gender" , gender);
                intent.putExtra("nickname" , nickname);
                intent.putExtra("dob" , dob);
                intent.putExtra("profession" ,profession);
                intent.putExtra("maritalstatus" , maritalstatus);
                intent.putExtra("educationlevel" , education);
                intent.putExtra("country" , country);
                intent.putExtra("religion" , notpractising.getText());
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