package com.dropoutsolutions.betterhalf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.makeramen.roundedimageview.RoundedImageView;

import org.w3c.dom.Text;

public class OnclickDetails extends AppCompatActivity {
    String postid ;
    private DatabaseReference userref ;
    private FirebaseAuth mAuth ;
    RoundedImageView imageview ;
    TextView name , dob , profession , country , statusshort , mstatus , hieght , countryname ,
    language , statuslong , education , profession2 , jobtitle ,employer , sect ,practising ,
    paryer , eathalal , drink , smoke , soon , abroad ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onclick_details);
        mAuth = FirebaseAuth.getInstance();
        userref = FirebaseDatabase.getInstance().getReference().child("Users");

        postid = getIntent().getStringExtra("Userid");

        imageview = findViewById(R.id.imageView);
        name = findViewById(R.id.name);
        dob = findViewById(R.id.age);
        profession = findViewById(R.id.profession);
        country = findViewById(R.id.country);
        statusshort = findViewById(R.id.shortstatus);
        mstatus = findViewById(R.id.mstatus);
        hieght = findViewById(R.id.hieght);
        countryname = findViewById(R.id.countryname);
        language = findViewById(R.id.language);
        statuslong = findViewById(R.id.statuslong);
        education = findViewById(R.id.education);
        profession2 = findViewById(R.id.profession2);
        jobtitle = findViewById(R.id.jobtitle);
        employer = findViewById(R.id.emploertype);
        sect = findViewById(R.id.sect);
        practising = findViewById(R.id.practising);
        paryer = findViewById(R.id.prayer);
        eathalal = findViewById(R.id.halal);
        drink = findViewById(R.id.alcohol);
        smoke = findViewById(R.id.smoke);
        soon = findViewById(R.id.soon);
        abroad = findViewById(R.id.abroad);

        userref.child(postid).addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    if (dataSnapshot.hasChild("AboutDetails"))
                    {
                        String Name = (String) dataSnapshot.child("Name").getValue();
                        String Profession = (String) dataSnapshot.child("Profession").getValue();
                        String Age = (String) dataSnapshot.child("DateOfBirth").getValue();
                        String Count = (String) dataSnapshot.child("Country").getValue();
                        String Image = (String) dataSnapshot.child("ProfileImage").getValue();
                        String Mstatus = (String) dataSnapshot.child("MaritalStatus").getValue();
                        String Countryname = (String) dataSnapshot.child("Country").getValue();
                        String longstatus = (String) dataSnapshot.child("AboutDetails").getValue();
                        String Education = (String) dataSnapshot.child("EducationLevel").getValue();
                        String Prcatising = (String) dataSnapshot.child("Religious").getValue();
                        String Prayer = (String) dataSnapshot.child("Prayer").getValue();
                        String Eathalal = (String) dataSnapshot.child("EatHalal").getValue();
                        String Drink = (String) dataSnapshot.child("Drink").getValue();
                        String Smoke = (String) dataSnapshot.child("Smoke").getValue();
                        String Soon = (String) dataSnapshot.child("SoonMarried").getValue();
                        String Abroad = (String) dataSnapshot.child("MoveToAbroad").getValue();

                        if (dataSnapshot.hasChild("OnlineStatus"))
                        {
                            String Shortstatus = (String) dataSnapshot.child("OnlineStatus").getValue();
                            statusshort.setText(Shortstatus);
                        }
                        if (dataSnapshot.hasChild("JobTitle"))
                        {
                            String Jobtitle = (String) dataSnapshot.child("JobTitle").getValue();
                            jobtitle.setText(Jobtitle);
                        }

                        if (dataSnapshot.hasChild("EmployeePosition"))
                        {
                            String Employee = (String) dataSnapshot.child("EmployeePosition").getValue();
                            employer.setText(Employee);
                        }

                        if (dataSnapshot.hasChild("Sect"))
                        {
                            String Sect = (String) dataSnapshot.child("Sect").getValue();
                            sect.setText(Sect);
                        }

                        mstatus.setText(Mstatus);
                        countryname.setText(Countryname);
                        education.setText(Education);
                        profession2.setText(Profession);
                        statuslong.setText(longstatus);
                        practising.setText(Prcatising);
                        paryer.setText(Prayer);
                        eathalal.setText(Eathalal);

                        if (Drink.equals("Yes"))
                        {
                            drink.setText("Drink Alcohol");
                        }
                        else
                        {
                            drink.setText("Don't Drink Alcohol");
                        }

                        if (Smoke.equals("Yes"))
                        {
                            smoke.setText("Smoke");
                        }
                        else
                        {
                            smoke.setText("Does't smoke");
                        }

                        if (Soon.equals("As soon as possible"))
                        {
                            soon.setText("Seeking marriage " + Soon);
                        }
                        else if (Soon.equals("1-2 years"))
                        {
                            soon.setText("Seeking marriage with in " + Soon);
                        }
                        else if (Soon.equals("3-4 years"))
                        {
                            soon.setText("Seeking marriage with in " + Soon);
                        }
                        else
                            soon.setText("Seeking marriage with in " + Soon);

                        if (Abroad.equals("Yes"))
                            abroad.setText("Will move abroad");
                        else
                            abroad.setText("Will not move abroad");

                        Glide.with(getApplicationContext()).load(Image).into(imageview);
                        name.setText(Name);
                        profession.setText(Profession);
                        dob.setText(Age);
                        country.setText(Count);
                    }


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }
}