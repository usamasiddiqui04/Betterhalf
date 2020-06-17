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

import com.dropoutsolutions.betterhalf.GoogleFacebookLogin;
import com.dropoutsolutions.betterhalf.MaritalstatusActivity;
import com.dropoutsolutions.betterhalf.OnclickDetails;
import com.dropoutsolutions.betterhalf.R;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {

    TextView logout ;
    View view ;
    CardView constraintLayout;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;

    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_setting, container, false);
        logout = view.findViewById(R.id.logout);
        constraintLayout = view.findViewById(R.id.two);
        mauth = FirebaseAuth.getInstance() ;
        Currentuserid = mauth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users");
        constraintLayout.setOnClickListener(v ->
                userref.child(Currentuserid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    if (!dataSnapshot.hasChild("AboutDetails"))
                    {
                        startActivity(new Intent(getActivity() , MaritalstatusActivity.class));
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

        logout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            LoginManager.getInstance().logOut();

            startActivity(new Intent(getContext() , GoogleFacebookLogin.class));
        });
        return view;
    }
}
