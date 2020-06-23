package com.dropoutsolutions.betterhalf.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dropoutsolutions.betterhalf.CountryActivity;
import com.dropoutsolutions.betterhalf.EducationActivity;
import com.dropoutsolutions.betterhalf.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class EducationFragment extends Fragment {


    public EducationFragment() {
        // Required empty public constructor
    }

    View view ;
    TextView bdegree , mdegree ,nondegree , college , doctorate ,other ;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_education, container, false);
        mauth = FirebaseAuth.getInstance() ;
        Currentuserid = mauth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(Currentuserid);
        bdegree = view.findViewById(R.id.bachlorsdegree);
        mdegree = view.findViewById(R.id.master);
        nondegree = view.findViewById(R.id.nondegree);
        college = view.findViewById(R.id.college);
        doctorate = view.findViewById(R.id.doctorate);
        other = view.findViewById(R.id.other);


        bdegree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bdegree.setPadding(20 , 10 , 20 , 10);
                bdegree.setBackgroundResource(R.drawable.edittextback);
                mdegree.setBackgroundResource(R.drawable.resetbackground);
                nondegree.setBackgroundResource(R.drawable.resetbackground);
                college.setBackgroundResource(R.drawable.resetbackground);
                doctorate.setBackgroundResource(R.drawable.resetbackground);
                other.setBackgroundResource(R.drawable.resetbackground);
                HashMap<String, Object> user = new HashMap<>();
                user.put("EducationLevel" , bdegree.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            loadFragment(new CountryFragment());
                        }

                    }
                });

            }
        });


        mdegree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mdegree.setPadding(20 , 10 , 20 , 10);
                mdegree.setBackgroundResource(R.drawable.edittextback);
                bdegree.setBackgroundResource(R.drawable.resetbackground);
                nondegree.setBackgroundResource(R.drawable.resetbackground);
                college.setBackgroundResource(R.drawable.resetbackground);
                doctorate.setBackgroundResource(R.drawable.resetbackground);
                other.setBackgroundResource(R.drawable.resetbackground);
                HashMap<String, Object> user = new HashMap<>();
                user.put("EducationLevel" , mdegree.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            loadFragment(new CountryFragment());
                        }

                    }
                });

            }
        });


        nondegree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nondegree.setPadding(20 , 10 , 20 , 10);
                nondegree.setBackgroundResource(R.drawable.edittextback);
                bdegree.setBackgroundResource(R.drawable.resetbackground);
                mdegree.setBackgroundResource(R.drawable.resetbackground);
                college.setBackgroundResource(R.drawable.resetbackground);
                doctorate.setBackgroundResource(R.drawable.resetbackground);
                HashMap<String, Object> user = new HashMap<>();
                user.put("EducationLevel" , nondegree.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            loadFragment(new CountryFragment());
                        }

                    }
                });

            }
        });

        college.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                college.setPadding(20 , 10 , 20 , 10);
                college.setBackgroundResource(R.drawable.edittextback);
                bdegree.setBackgroundResource(R.drawable.resetbackground);
                mdegree.setBackgroundResource(R.drawable.resetbackground);
                nondegree.setBackgroundResource(R.drawable.resetbackground);
                doctorate.setBackgroundResource(R.drawable.resetbackground);
                other.setBackgroundResource(R.drawable.resetbackground);
                HashMap<String, Object> user = new HashMap<>();
                user.put("EducationLevel" , college.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            loadFragment(new CountryFragment());
                        }

                    }
                });

            }
        });

        doctorate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doctorate.setPadding(20 , 10 , 20 , 10);
                doctorate.setBackgroundResource(R.drawable.edittextback);
                bdegree.setBackgroundResource(R.drawable.resetbackground);
                mdegree.setBackgroundResource(R.drawable.resetbackground);
                college.setBackgroundResource(R.drawable.resetbackground);
                nondegree.setBackgroundResource(R.drawable.resetbackground);
                other.setBackgroundResource(R.drawable.resetbackground);
                HashMap<String, Object> user = new HashMap<>();
                user.put("EducationLevel" , doctorate.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            loadFragment(new CountryFragment());
                        }

                    }
                });
            }
        });

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                other.setPadding(20, 10, 20, 10);
                other.setBackgroundResource(R.drawable.edittextback);
                bdegree.setBackgroundResource(R.drawable.resetbackground);
                mdegree.setBackgroundResource(R.drawable.resetbackground);
                college.setBackgroundResource(R.drawable.resetbackground);
                nondegree.setBackgroundResource(R.drawable.resetbackground);
                doctorate.setBackgroundResource(R.drawable.resetbackground);
                HashMap<String, Object> user = new HashMap<>();
                user.put("EducationLevel", other.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            loadFragment(new CountryFragment());
                        }

                    }
                });

            }
        });

        return  view ;
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment); // give your fragment container id in first parameter
        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
        transaction.commit();
    }
}