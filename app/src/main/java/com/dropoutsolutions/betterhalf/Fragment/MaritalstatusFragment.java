package com.dropoutsolutions.betterhalf.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dropoutsolutions.betterhalf.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MaritalstatusFragment extends Fragment {

    TextView nevermarried , divorced ,seprated ,annulled , widowed ;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;
    View view ;

    public
    MaritalstatusFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_maritalstatus, container, false);

        nevermarried = view.findViewById(R.id.never);
        divorced = view.findViewById(R.id.divorced);
        seprated = view.findViewById(R.id.seprated);
        annulled = view.findViewById(R.id.annulled);
        widowed = view.findViewById(R.id.widowed);

        mauth = FirebaseAuth.getInstance();
        Currentuserid = mauth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(Currentuserid);

        nevermarried.setOnClickListener(v -> {
            nevermarried.setPadding(20, 10, 20, 10);
            nevermarried.setBackgroundResource(R.drawable.edittextback);
            divorced.setBackgroundResource(R.drawable.resetbackground);
            seprated.setBackgroundResource(R.drawable.resetbackground);
            annulled.setBackgroundResource(R.drawable.resetbackground);
            widowed.setBackgroundResource(R.drawable.resetbackground);
            HashMap<String, Object> user = new HashMap<>();
            user.put("MaritalStatus", nevermarried.getText());
            userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        loadFragment(new EducationFragment());
                    }

                }
            });
        });

        divorced.setOnClickListener(v -> {
            divorced.setPadding(20, 10, 20, 10);
            divorced.setBackgroundResource(R.drawable.edittextback);
            nevermarried.setBackgroundResource(R.drawable.resetbackground);
            seprated.setBackgroundResource(R.drawable.resetbackground);
            annulled.setBackgroundResource(R.drawable.resetbackground);
            widowed.setBackgroundResource(R.drawable.resetbackground);
            HashMap<String, Object> user = new HashMap<>();
            user.put("MaritalStatus", divorced.getText());
            userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        loadFragment(new EducationFragment());
                    }

                }
            });

        });

        seprated.setOnClickListener(v -> {
            seprated.setPadding(20, 10, 20, 10);
            seprated.setBackgroundResource(R.drawable.edittextback);
            nevermarried.setBackgroundResource(R.drawable.resetbackground);
            divorced.setBackgroundResource(R.drawable.resetbackground);
            annulled.setBackgroundResource(R.drawable.resetbackground);
            widowed.setBackgroundResource(R.drawable.resetbackground);
            HashMap<String, Object> user = new HashMap<>();
            user.put("MaritalStatus", seprated.getText());
            userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        loadFragment(new EducationFragment());
                    }
                }
            });
        });

        annulled.setOnClickListener(v -> {
            annulled.setPadding(20, 10, 20, 10);
            annulled.setBackgroundResource(R.drawable.edittextback);
            nevermarried.setBackgroundResource(R.drawable.resetbackground);
            divorced.setBackgroundResource(R.drawable.resetbackground);
            seprated.setBackgroundResource(R.drawable.resetbackground);
            widowed.setBackgroundResource(R.drawable.resetbackground);
            HashMap<String, Object> user = new HashMap<>();
            user.put("MaritalStatus", annulled.getText());
            userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        loadFragment(new EducationFragment());
                    }

                }
            });


        });

        widowed.setOnClickListener(v -> {
            widowed.setPadding(20, 10, 20, 10);
            widowed.setBackgroundResource(R.drawable.edittextback);
            nevermarried.setBackgroundResource(R.drawable.resetbackground);
            divorced.setBackgroundResource(R.drawable.resetbackground);
            seprated.setBackgroundResource(R.drawable.resetbackground);
            annulled.setBackgroundResource(R.drawable.resetbackground);
            HashMap<String, Object> user = new HashMap<>();
            user.put("MaritalStatus", widowed.getText());
            userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        loadFragment(new EducationFragment());

                    }

                }
            });

        });

        return view;
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment); // give your fragment container id in first parameter
        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
        transaction.commit();
    }
}