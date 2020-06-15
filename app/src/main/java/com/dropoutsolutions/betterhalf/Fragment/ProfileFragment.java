package com.dropoutsolutions.betterhalf.Fragment;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.dropoutsolutions.betterhalf.HomeActivity;
import com.dropoutsolutions.betterhalf.R;
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

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    private Button cont ;
    private Uri imageuri ;
    private StorageReference postimages ;
    private ProgressDialog progressDialog ;


    public ProfileFragment() {
        // Required empty public constructor
    }
    private LottieAnimationView lottieAnimationView ;
    private View view ;
    private CircleImageView profileimage ;
    FirebaseAuth mauth ;
    private DatabaseReference userref ;
    String currentuserid  , myurl = "" ;
    private String CurrentDate , CurrentTime  , randomname , downloadurl ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        lottieAnimationView = view.findViewById(R.id.profilelottie);
        profileimage = view.findViewById(R.id.profileimage);
        postimages = FirebaseStorage.getInstance().getReference();
        progressDialog = new ProgressDialog(getContext());
        mauth = FirebaseAuth.getInstance();
        currentuserid = mauth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(currentuserid);

        cont = view.findViewById(R.id.cont);
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
                Toast.makeText(getContext(), "Select Profile Image", Toast.LENGTH_SHORT).show();
            }

        });
        lottieAnimationView.setOnClickListener(v -> {

        });
        Calendar calendarfordate = Calendar.getInstance();
        SimpleDateFormat currentdate = new SimpleDateFormat("dd-MMMM-yyyy");
        CurrentDate = currentdate.format(calendarfordate.getTime());

        Calendar calendarfortime = Calendar.getInstance();
        SimpleDateFormat currenttime = new SimpleDateFormat("HH:mm:ss");
        CurrentTime = currenttime.format(calendarfortime.getTime());

        randomname = CurrentTime + CurrentDate ;

        return view ;

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
                            HashMap<String, Object> user = new HashMap<>();
                            user.put("ProfileImage" , downloadurl);
                            user.put("Status" , "e");
                            userref.updateChildren(user).addOnCompleteListener(task -> {
                                if (task.isSuccessful())
                                {
                                    progressDialog.dismiss();
                                    Intent intent = new Intent(getActivity() , HomeActivity.class);
                                    startActivity(intent);
                                }
                                else
                                {
                                    progressDialog.dismiss();
                                }

                            });

                        }
                    });

                }
            });

        }
    }


}
