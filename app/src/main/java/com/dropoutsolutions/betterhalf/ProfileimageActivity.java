package com.dropoutsolutions.betterhalf;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileimageActivity extends AppCompatActivity {

    private Button cont ;
    private Uri imageuri ;
    private StorageReference postimages ;
    private ProgressDialog progressDialog ;
    private CircleImageView profileimage ;
    FirebaseAuth mauth ;
    private DatabaseReference userref ;
    String currentuserid  , myurl = "" ;
    String nickname ;
    String dob , children  , move  , convert , details;
    String gender ;
    String profession ;
    String prfileimage , maritalstatus , education , country , religion , prayer , soonmarried , eat , smoke , drink ;
    private String CurrentDate , CurrentTime  , randomname , downloadurl ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);
        profileimage = findViewById(R.id.profileimage);
        postimages = FirebaseStorage.getInstance().getReference();
        progressDialog = new ProgressDialog(this);
        mauth = FirebaseAuth.getInstance();
        currentuserid = mauth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(currentuserid);

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
        eat = getIntent().getStringExtra("eat");
        soonmarried = getIntent().getStringExtra("soonmarried");
        smoke = getIntent().getStringExtra("smoke");
        drink = getIntent().getStringExtra("drink");
        children = getIntent().getStringExtra("children");
        move = getIntent().getStringExtra("movetoabroad");
        convert = getIntent().getStringExtra("convert");
        details = getIntent().getStringExtra("details");

        cont = findViewById(R.id.cont);
        cont.setOnClickListener(v -> {

            if (cont.getText().equals("Select Image"))
            {
                Intent galleryintent = new Intent();
                galleryintent.setAction(Intent.ACTION_GET_CONTENT);
                galleryintent.setType("image/*");
                startActivityForResult(Intent.createChooser(galleryintent ,"Select Image") ,438);
            }
            else
            {
                Toast.makeText(this, "Select Profile Image", Toast.LENGTH_SHORT).show();
            }

        });
        Calendar calendarfordate = Calendar.getInstance();
        SimpleDateFormat currentdate = new SimpleDateFormat("dd-MMMM-yyyy");
        CurrentDate = currentdate.format(calendarfordate.getTime());
        Calendar calendarfortime = Calendar.getInstance();
        SimpleDateFormat currenttime = new SimpleDateFormat("HH:mm:ss");
        CurrentTime = currenttime.format(calendarfortime.getTime());
        randomname = CurrentTime + CurrentDate ;

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
                            hashMap.put("Name" , nickname);
                            hashMap.put("DateOfBirth" , dob);
                            hashMap.put("Gender" , gender);
                            hashMap.put("Profession" , profession);
                            hashMap.put("ProfileImage" , downloadurl);
                            hashMap.put("MaritalStatus" , maritalstatus);
                            hashMap.put("EducationLevel" , education);
                            hashMap.put("Country" , country);
                            hashMap.put("Religious" , religion);
                            hashMap.put("Prayer" , prayer);
                            hashMap.put("EatHalal" , eat);
                            hashMap.put("SoonMarried" , soonmarried);
                            hashMap.put("Smoke" , smoke);
                            hashMap.put("Drink" , drink);
                            hashMap.put("HaveChildren" , children);
                            hashMap.put("MoveToAbroad" , move);
                            hashMap.put("Convert" , convert);
                            hashMap.put("AboutDetails" , details);

                            userref.updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful())
                                    {
                                        Intent intent = new Intent(ProfileimageActivity.this , HomeActivity.class);
                                        startActivity(intent);
                                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                                    }

                                }
                            });
                        }
                    });

                }
            });

        }
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
