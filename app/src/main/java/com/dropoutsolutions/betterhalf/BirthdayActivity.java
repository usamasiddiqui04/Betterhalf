package com.dropoutsolutions.betterhalf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.dropoutsolutions.betterhalf.Fragment.ProfessionFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class BirthdayActivity extends AppCompatActivity {
    private DatePicker datePicker ;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;
    private Fragment fragment = new ProfessionFragment();
    private int date , month , year ;
    private String birthdaydate ;
    private String gender ;
    private String nickname ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_birthday);
        Button button = findViewById(R.id.cont);
        datePicker = findViewById(R.id.datePicker);
        mauth = FirebaseAuth.getInstance() ;
        Currentuserid = mauth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(Currentuserid);
        gender = getIntent().getStringExtra("gender");
        nickname = getIntent().getStringExtra("nickname");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                birthdaydate = datePicker.getDayOfMonth() + "/" + datePicker.getMonth() + "/" + datePicker.getYear();

                Intent intent = new Intent(BirthdayActivity.this , ProfessionActivity.class);
                intent.putExtra("gender" , gender);
                intent.putExtra("nickname" , nickname);
                intent.putExtra("dob" , birthdaydate );
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