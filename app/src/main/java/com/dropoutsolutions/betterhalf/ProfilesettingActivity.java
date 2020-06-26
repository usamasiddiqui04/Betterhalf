package com.dropoutsolutions.betterhalf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.invoke.ConstantCallSite;

public class ProfilesettingActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth ;
    DatabaseReference userref ;
    String currentuser ;
    TextView name  , dob , gender , status , about  , education ,employee,
            prfession , jobtitle , employer , ethnicgroup , ethnicorigin , sect , convert , religion ,
            praying ,halalfood , alcohol ,smooker , maritalstatus , childern , marriagehorizon , relocation ;
    ConstraintLayout setclayout ,ethnicgrouplayout,employeelayour,joblayout ,nicknamelayout , doblayout , genderlayout , statuslayout , aboutlayout ,eductionalayout  , professionlayout;
    ConstraintLayout convertlayout , religionlayout , praylayout , halalayout , alcohollayout , smookerlayout,
    maritallayout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilesetting);
        firebaseAuth = FirebaseAuth.getInstance();
        currentuser = firebaseAuth.getCurrentUser().getUid() ;
        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(currentuser);

        convertlayout = findViewById(R.id.convertlayout);
        religionlayout = findViewById(R.id.religiositylayout);
        praylayout = findViewById(R.id.prayinglayout);
        halalayout = findViewById(R.id.halalfoodlayout);
        alcohollayout = findViewById(R.id.alcohollayout);
        smookerlayout = findViewById(R.id.smookerlayout);
        nicknamelayout = findViewById(R.id.nicknamelayout);
        doblayout = findViewById(R.id.doblayout);
        genderlayout = findViewById(R.id.genderlayout);
        statuslayout = findViewById(R.id.statuslayout);
        aboutlayout = findViewById(R.id.aboutlayout);
        name = findViewById(R.id.getnickname);
        dob = findViewById(R.id.getdateofbirth);
        gender = findViewById(R.id.getgender);
        status = findViewById(R.id.getstatus);
        about = findViewById(R.id.getaboutyou);
        maritallayout = findViewById(R.id.maritalstatuslayout);
        education = findViewById(R.id.geteducation);
        prfession = findViewById(R.id.getprofession);
        jobtitle = findViewById(R.id.getjob);
        employer = findViewById(R.id.getemploy);
        ethnicgroup = findViewById(R.id.getethnicity);
        ethnicorigin = findViewById(R.id.getethnicityorigin);
        sect = findViewById(R.id.getsect);
        convert = findViewById(R.id.getconvert);
        religion = findViewById(R.id.getreligiosity);
        praying = findViewById(R.id.getprayer);
        halalfood = findViewById(R.id.gethalalfood);
        alcohol = findViewById(R.id.getalcohol);
        smooker = findViewById(R.id.getsmoker);
        maritalstatus = findViewById(R.id.getmaritalstatus);
        childern = findViewById(R.id.getchildern);
        marriagehorizon = findViewById(R.id.getmarraigehorizon);
        relocation = findViewById(R.id.getrelocation);
        eductionalayout = findViewById(R.id.eduaction);
        professionlayout = findViewById(R.id.professionlayout);
        joblayout = findViewById(R.id.jobtitlelayout);
        employeelayour = findViewById(R.id.employeelayout);
        ethnicgrouplayout = findViewById(R.id.ethnicgrouplayout);
        setclayout =findViewById(R.id.sectlayout);

        convertlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this ,GetconvertActivity.class));
            }
        });

        maritallayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this ,GetmaritalStatusActivity.class));
            }
        });

        religionlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , GetReligionActivity.class));
            }
        });

        praylayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , GetPrayingActivity.class));
            }
        });

        halalayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , GethalalActivity.class));
            }
        });

        alcohollayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , GetAlcoholActivity.class));
            }
        });

        smookerlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , GetSmookerActivity.class));
            }
        });

        doblayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , EditdobActivity.class));
            }
        });

        nicknamelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , Editnickname.class));
            }
        });

        genderlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , SetgenderActivity.class));
            }
        });
        aboutlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , SetdetailsActivity.class));
            }
        });

        eductionalayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , EditEducationActivity.class));
            }
        });

        statuslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , OnlinestatusActivity.class));
            }
        });

        professionlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , SetProfessionActivity.class));
            }
        });

        joblayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , JobActivity.class));
            }
        });

        employeelayour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , EmployerActivity.class));
            }
        });

        ethnicgrouplayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , GetcountryActivity.class));
            }
        });
        setclayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , SectActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        userref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String Name = (String) dataSnapshot.child("Name").getValue();
                    String Profession = (String) dataSnapshot.child("Profession").getValue();
                    String Age = (String) dataSnapshot.child("DateOfBirth").getValue();
                    String Count = (String) dataSnapshot.child("Country").getValue();
                    String Image = (String) dataSnapshot.child("ProfileImage").getValue();
                    String Mstatus = (String) dataSnapshot.child("MaritalStatus").getValue();
                    String longstatus = (String) dataSnapshot.child("AboutDetails").getValue();
                    String Education = (String) dataSnapshot.child("EducationLevel").getValue();
                    String Prcatising = (String) dataSnapshot.child("Religious").getValue();
                    String Prayer = (String) dataSnapshot.child("Prayer").getValue();
                    String Eathalal = (String) dataSnapshot.child("EatHalal").getValue();
                    String Drink = (String) dataSnapshot.child("Drink").getValue();
                    String Smoke = (String) dataSnapshot.child("Smoke").getValue();
                    String Soon = (String) dataSnapshot.child("SoonMarried").getValue();
                    String Abroad = (String) dataSnapshot.child("MoveToAbroad").getValue();
                    String Gender = (String) dataSnapshot.child("Gender").getValue();
                    String Child = (String) dataSnapshot.child("HaveChildren").getValue();
                    String con = (String) dataSnapshot.child("Convert").getValue();


                    if (dataSnapshot.hasChild("OnlineStatus"))
                    {
                        String Status = (String) dataSnapshot.child("OnlineStatus").getValue();
                        status.setText(Status);
                    }

                    name.setText(Name);
                    dob.setText(Age);
                    gender.setText(Gender);
                    about.setText(longstatus);
                    ethnicgroup.setText(Count);
                    marriagehorizon.setText(Soon);
                    relocation.setText(Abroad);
                    smooker.setText(Smoke);
                    alcohol.setText(Drink);
                    halalfood.setText(Eathalal);
                    praying.setText(Prayer);
                    religion.setText(Prcatising);
                    education.setText(Education);
                    maritalstatus.setText(Mstatus);
                    prfession.setText(Profession);
                    childern.setText(Child);
                    convert.setText(con);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}