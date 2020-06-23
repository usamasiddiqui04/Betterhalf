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

import com.dropoutsolutions.betterhalf.CountryActivity;
import com.dropoutsolutions.betterhalf.R;
import com.dropoutsolutions.betterhalf.ReligionActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

import java.util.HashMap;

public class CountryFragment extends Fragment {

    View view ;

    public CountryFragment() {
        // Required empty public constructor
    }

    CountryCodePicker countryCodePicker ;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_country, container, false);
        mauth = FirebaseAuth.getInstance() ;
        Currentuserid = mauth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(Currentuserid);
        countryCodePicker = view.findViewById(R.id.countrycodepicker);

        countryCodePicker.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                HashMap<String, Object> user = new HashMap<>();
                user.put("Country" , countryCodePicker.getSelectedCountryName());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {

                        }

                    }
                });
            }

        });
        countryCodePicker = view.findViewById(R.id.countrycodepicker);

        return view;
    }
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment); // give your fragment container id in first parameter
        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
        transaction.commit();
    }
}