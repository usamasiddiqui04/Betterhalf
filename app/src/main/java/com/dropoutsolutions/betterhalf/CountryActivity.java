package com.dropoutsolutions.betterhalf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

import java.util.HashMap;

public class CountryActivity extends AppCompatActivity {

    CountryCodePicker countryCodePicker ;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;
    long mlastclicktime = 0 ;
    String nickname ;
    String dob ;
    String gender ;
    String profession ;
    String prfileimage , maritalstatus , education ;
    Button cont ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        mauth = FirebaseAuth.getInstance() ;
        Currentuserid = mauth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(Currentuserid);

        cont = findViewById(R.id.cont);
        nickname = getIntent().getStringExtra("nickname");
        dob = getIntent().getStringExtra("dob");
        gender = getIntent().getStringExtra("gender");
        profession = getIntent().getStringExtra("profession");
        maritalstatus = getIntent().getStringExtra("maritalstatus");
        education = getIntent().getStringExtra("educationlevel");
        countryCodePicker = findViewById(R.id.countrycodepicker);

        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CountryActivity.this, ReligionActivity.class);
                intent.putExtra("gender" , gender);
                intent.putExtra("nickname" , nickname);
                intent.putExtra("dob" , dob);
                intent.putExtra("profession" ,profession);
                intent.putExtra("maritalstatus" , maritalstatus);
                intent.putExtra("educationlevel" , education);
                intent.putExtra("country" , countryCodePicker.getDefaultCountryName());
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        countryCodePicker.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                Intent intent = new Intent(CountryActivity.this, ReligionActivity.class);
                intent.putExtra("gender" , gender);
                intent.putExtra("nickname" , nickname);
                intent.putExtra("dob" , dob);
                intent.putExtra("profession" ,profession);
                intent.putExtra("maritalstatus" , maritalstatus);
                intent.putExtra("educationlevel" , education);
                intent.putExtra("country" , countryCodePicker.getSelectedCountryName());
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