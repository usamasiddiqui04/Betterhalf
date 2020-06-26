package com.dropoutsolutions.betterhalf.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dropoutsolutions.betterhalf.EducationActivity;
import com.dropoutsolutions.betterhalf.FragmentActivity;
import com.dropoutsolutions.betterhalf.GoogleFacebookLogin;
import com.dropoutsolutions.betterhalf.MaritalstatusActivity;
import com.dropoutsolutions.betterhalf.OnclickDetails;
import com.dropoutsolutions.betterhalf.ProfilesettingActivity;
import com.dropoutsolutions.betterhalf.R;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {

    ConstraintLayout logout  , profileview , profilesetting;
    View view ;
    TextView username ;
    CircleImageView profileimage ;
    CardView constraintLayout;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;
    TextView email ;

    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_setting, container, false);
        logout = view.findViewById(R.id.logout);
        profileview = view.findViewById(R.id.profileview);
        profilesetting = view.findViewById(R.id.profilesetting);

        username = view.findViewById(R.id.username);
        profileimage = view.findViewById(R.id.profileimage);

        profilesetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext() , ProfilesettingActivity.class);
                startActivity(intent);
            }
        });

        mauth = FirebaseAuth.getInstance() ;
        Currentuserid = mauth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users");
        profileview.setOnClickListener(v ->
                userref.child(Currentuserid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    if (!dataSnapshot.hasChild("AboutDetails"))
                    {
                        Intent intent = new Intent(getActivity() , MaritalstatusActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Intent intent = new Intent(getContext() , OnclickDetails.class);
                        intent.putExtra("Userid" , Currentuserid);
                        startActivity(intent);
                    }



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }));

//
//        if (Currentuserid != null)
//        {
//            GoogleSignInAccount googleSignInAccount = GoogleSignIn.getLastSignedInAccount(getContext());
//            if (googleSignInAccount.getEmail() == null)
//                 email.setText(googleSignInAccount.getEmail());
//        }




        logout.setOnClickListener(v -> {

            for (UserInfo user: FirebaseAuth.getInstance().getCurrentUser().getProviderData()) {
                if (user.getProviderId().equals("facebook.com")) {
                    LoginManager.getInstance().logOut();
                    Intent intent = new Intent(getContext() , GoogleFacebookLogin.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else
                {
                    FirebaseAuth.getInstance().signOut();
                    GoogleSignInOptions gso = new GoogleSignInOptions.
                            Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).
                            build();

                    GoogleSignInClient googleSignInClient=GoogleSignIn.getClient(getContext(),gso);
                    googleSignInClient.signOut();
                    Intent intent = new Intent(getContext() , GoogleFacebookLogin.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }
            }


        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        userref.child(Currentuserid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    String name = (String) dataSnapshot.child("Name").getValue();
                    String image = (String) dataSnapshot.child("ProfileImage").getValue();

                    username.setText(name);
                    Glide.with(getContext()).load(image).into(profileimage);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
