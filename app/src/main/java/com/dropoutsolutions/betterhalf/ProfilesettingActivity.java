package com.dropoutsolutions.betterhalf;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.lang.invoke.ConstantCallSite;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfilesettingActivity extends AppCompatActivity {

    CircleImageView profileimage ;
    ImageView alertnickname , alertdob , alertgender ,alertstatus ,alertabout ,alerteducation , alertprofession ,
    alertjob , alertemploye , alertethnicgroup , alertethnicorigin , alertsect , alertconvert , alertreligion ,
    alertpraying , alerthalal , alertalcohol ,alertsmoke , alertmaritalstatus ,alertchildern ,alertplan , alertrelocation;
    FirebaseAuth firebaseAuth ;
    ProgressDialog progressDialog ;
    DatabaseReference userref ;
    private StorageReference postimages ;
    ImageView addimage ;
    TextView done ;
    private Uri imageuri ;
    String currentuser ;
    TextView name  , dob , gender , status , about  , education ,
            prfession , jobtitle , employer , ethnicgroup , ethnicorigin , sect , convert , religion ,
            praying ,halalfood , alcohol ,smooker , maritalstatus , childern , marriagehorizon , relocation ;
    ConstraintLayout ethnicoriginlayout , setclayout ,ethnicgrouplayout,employeelayour,joblayout ,nicknamelayout , doblayout , genderlayout , statuslayout , aboutlayout ,eductionalayout  , professionlayout;
    ConstraintLayout convertlayout , religionlayout , praylayout , halalayout , alcohollayout , smookerlayout,
    maritallayout , childrenlayout , getmaarriagehorizon , relocationlayout ;

    private String CurrentDate , CurrentTime  , randomname , downloadurl ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilesetting);
        firebaseAuth = FirebaseAuth.getInstance();
        currentuser = firebaseAuth.getCurrentUser().getUid() ;
        postimages = FirebaseStorage.getInstance().getReference();
        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(currentuser);
        addimage = findViewById(R.id.addimage);

        profileimage = findViewById(R.id.profileimage);

        alertabout = findViewById(R.id.alertabout);
        alerthalal = findViewById(R.id.alerthalal);
        progressDialog = new ProgressDialog(this);
        alertsmoke = findViewById(R.id.alertsmoke);
        alertalcohol = findViewById(R.id.alertalcohol);
        alertmaritalstatus = findViewById(R.id.alertmarital);
        alertconvert = findViewById(R.id.alertcpnvert);
        alertplan = findViewById(R.id.alertplans);
        ethnicoriginlayout = findViewById(R.id.ethnicoriginlayout);
        alertrelocation = findViewById(R.id.alertrelocation);
        alerteducation = findViewById(R.id.alerteducation);
        alertprofession = findViewById(R.id.alertprofession);
        alertethnicgroup = findViewById(R.id.alertethinicgroup);
        alertethnicorigin = findViewById(R.id.alertethinicorigin);
        alertchildern = findViewById(R.id.alertchildern);
        alertreligion = findViewById(R.id.alertreligion);
        alertpraying = findViewById(R.id.alertpray);
        alertnickname = findViewById(R.id.alertname);
        alertdob = findViewById(R.id.alertdob);
        alertgender = findViewById(R.id.alertgender);
        alertstatus = findViewById(R.id.alertstatus);
        alertjob = findViewById(R.id.alertjob);
        alertsect =findViewById(R.id.alertsect);
        alertemploye = findViewById(R.id.alertemployee);



        convertlayout = findViewById(R.id.convertlayout);
        religionlayout = findViewById(R.id.religiositylayout);
        praylayout = findViewById(R.id.prayinglayout);
        halalayout = findViewById(R.id.halalfoodlayout);
        relocationlayout = findViewById(R.id.relocation);
        alcohollayout = findViewById(R.id.alcohollayout);
        smookerlayout = findViewById(R.id.smookerlayout);
        nicknamelayout = findViewById(R.id.nicknamelayout);
        doblayout = findViewById(R.id.doblayout);
        getmaarriagehorizon = findViewById(R.id.getmarriagehorizon);
        genderlayout = findViewById(R.id.genderlayout);
        statuslayout = findViewById(R.id.statuslayout);
        aboutlayout = findViewById(R.id.aboutlayout);
        childrenlayout = findViewById(R.id.chidernlayout);
        name = findViewById(R.id.getnickname);
        dob = findViewById(R.id.getdateofbirth);
        gender = findViewById(R.id.getgender);
        status = findViewById(R.id.getstatus);
        about = findViewById(R.id.getaboutyou);
        marriagehorizon = findViewById(R.id.marraigehorizon);
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
        relocation = findViewById(R.id.getrelocation);
        eductionalayout = findViewById(R.id.eduaction);
        professionlayout = findViewById(R.id.professionlayout);
        joblayout = findViewById(R.id.jobtitlelayout);
        employeelayour = findViewById(R.id.employeelayout);
        ethnicgrouplayout = findViewById(R.id.ethnicgrouplayout);
        setclayout =findViewById(R.id.sectlayout);

        done = findViewById(R.id.done);
        Calendar calendarfordate = Calendar.getInstance();
        SimpleDateFormat currentdate = new SimpleDateFormat("dd-MMMM-yyyy");
        CurrentDate = currentdate.format(calendarfordate.getTime());
        Calendar calendarfortime = Calendar.getInstance();
        SimpleDateFormat currenttime = new SimpleDateFormat("HH:mm:ss");
        CurrentTime = currenttime.format(calendarfortime.getTime());
        randomname = CurrentTime + CurrentDate ;

        addimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryintent = new Intent();
                galleryintent.setAction(Intent.ACTION_GET_CONTENT);
                galleryintent.setType("image/*");
                startActivityForResult(Intent.createChooser(galleryintent ,"Select Image") ,438);
            }
        });

        ethnicoriginlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this ,EthnicoriginActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        relocationlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this ,Getrelocation.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        getmaarriagehorizon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this ,Getsoonmarriage.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        childrenlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this ,getchildern.class));
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        convertlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this ,GetconvertActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        maritallayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this ,GetmaritalStatusActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        religionlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , GetReligionActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        praylayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , GetPrayingActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        halalayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , GethalalActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();

            }
        });

        alcohollayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , GetAlcoholActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        smookerlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , GetSmookerActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        doblayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , EditdobActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        nicknamelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , Editnickname.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        genderlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , SetgenderActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });
        aboutlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , SetdetailsActivity.class));
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        eductionalayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , EditEducationActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        statuslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , OnlinestatusActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        professionlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , SetProfessionActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        joblayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , JobActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        employeelayour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , EmployerActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        ethnicgrouplayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , GetcountryActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });
        setclayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilesettingActivity.this , SectActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
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
                    String origin = (String) dataSnapshot.child("Origin").getValue();

                    Glide.with(getApplicationContext()).load(Image).into(profileimage);

                    if (!dataSnapshot.hasChild("Origin") || origin.isEmpty())
                    {
                        alertethnicorigin.setVisibility(View.VISIBLE);
                    }

                    if (!dataSnapshot.hasChild("Name") || Name.isEmpty())
                    {
                        alertnickname.setVisibility(View.VISIBLE);
                        name.setText("Please enter your name");
                    }
                    if (!dataSnapshot.hasChild("Profession") || Profession.isEmpty())
                    {
                        alertprofession.setVisibility(View.VISIBLE);
                        prfession.setText("Please enter your profession");
                    }
                    if (!dataSnapshot.hasChild("DateOfBirth") || Age.isEmpty())
                    {
                        alertdob.setVisibility(View.VISIBLE);
                        dob.setText("Please enter you date of birth");
                    }

                    if (!dataSnapshot.hasChild("Country") || Count.isEmpty())
                    {
                        alertethnicgroup.setVisibility(View.VISIBLE);
                        ethnicgroup.setText("Please select your country");
                    }

                    if (!dataSnapshot.hasChild("MaritalStatus") || Mstatus.isEmpty())
                    {
                        alertmaritalstatus.setVisibility(View.VISIBLE);
                        maritalstatus.setText("Please enter your marital status");
                    }

                    if (!dataSnapshot.hasChild("AboutDetails")|| longstatus.isEmpty())
                    {
                        alertabout.setVisibility(View.VISIBLE);
                        about.setText("Please enter your details");
                    }

                    if (!dataSnapshot.hasChild("EducationLevel") || Education.isEmpty())
                    {
                        alerteducation.setVisibility(View.VISIBLE);
                    }

                    if (!dataSnapshot.hasChild("Religious") || Prcatising.isEmpty())
                    {
                        alertreligion.setVisibility(View.VISIBLE);
                    }

                    if (!dataSnapshot.hasChild("Prayer") || Prayer.isEmpty())
                    {
                        alertpraying.setVisibility(View.VISIBLE);
                    }

                    if (!dataSnapshot.hasChild("EatHalal") || Eathalal.isEmpty())
                    {
                        alerthalal.setVisibility(View.VISIBLE);
                    }

                    if (!dataSnapshot.hasChild("Drink") || Drink.isEmpty())
                    {
                        alertalcohol.setVisibility(View.VISIBLE);
                    }

                    if (!dataSnapshot.hasChild("Smoke") || Smoke.isEmpty())
                    {
                        alertsmoke.setVisibility(View.VISIBLE);
                    }

                    if (!dataSnapshot.hasChild("SoonMarried") || Soon.isEmpty())
                    {
                        alertplan.setVisibility(View.VISIBLE);
                    }

                    if (!dataSnapshot.hasChild("MoveToAbroad") || Abroad.isEmpty())
                    {
                        alertrelocation.setVisibility(View.VISIBLE);
                    }

                    if (!dataSnapshot.hasChild("Gender") || Gender.isEmpty())
                    {
                        alertgender.setVisibility(View.VISIBLE);
                    }

                    if (!dataSnapshot.hasChild("HaveChildren") || Child.isEmpty())
                    {
                        alertchildern.setVisibility(View.VISIBLE);
                    }
                    if (!dataSnapshot.hasChild("Convert") || con.isEmpty())
                    {
                        alertconvert.setVisibility(View.VISIBLE);
                    }





                    if (dataSnapshot.hasChild("OnlineStatus"))
                    {
                        String Status = (String) dataSnapshot.child("OnlineStatus").getValue();
                        status.setText(Status);
                    }
                    else
                    {
                        alertstatus.setVisibility(View.VISIBLE);
                    }

                    if (dataSnapshot.hasChild("JobTitle"))
                    {
                        String Jobtitle = (String) dataSnapshot.child("JobTitle").getValue();
                        jobtitle.setText(Jobtitle);
                    }
                    else
                    {
                        alertjob.setVisibility(View.VISIBLE);
                    }

                    if (dataSnapshot.hasChild("EmployeePosition"))
                    {
                        String eomployeepostion = (String) dataSnapshot.child("EmployeePosition").getValue();
                        employer.setText(eomployeepostion);
                    }
                    else
                    {
                        alertemploye.setVisibility(View.VISIBLE);
                    }

                    if (dataSnapshot.hasChild("Sect"))
                    {
                        String Sect = (String) dataSnapshot.child("Sect").getValue();
                        sect.setText(Sect);
                    }
                    else
                    {
                        alertsect.setVisibility(View.VISIBLE);
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
                    ethnicorigin.setText(origin);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 438 && resultCode == RESULT_OK && data.getData() != null)
        {
            progressDialog.setTitle("Please wait");
            progressDialog.setMessage("setting your profile picture");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            imageuri = data.getData();
            final StorageReference filepath = postimages.child("Profile Images").child(imageuri.getLastPathSegment() +
                    randomname + ".jpg");
            filepath.putFile(imageuri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    final Task<Uri> firebaseUri = taskSnapshot.getStorage().getDownloadUrl();
                    firebaseUri.addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            downloadurl = uri.toString();
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("ProfileImage" , downloadurl);

                            userref.updateChildren(hashMap).isSuccessful();
                            progressDialog.dismiss();
                        }
                    });
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}