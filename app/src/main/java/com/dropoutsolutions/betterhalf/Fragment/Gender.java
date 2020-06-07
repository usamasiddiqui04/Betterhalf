package com.dropoutsolutions.betterhalf.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dropoutsolutions.betterhalf.Fragment.BirthdayFragment;
import com.dropoutsolutions.betterhalf.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class Gender extends Fragment {

    public Gender() {
        // Required empty public constructor
    }

    private View view ;
    private TextView male , female ;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.genderlayout, container, false);
        male = view.findViewById(R.id.male);
        female = view.findViewById(R.id.female);
        mauth = FirebaseAuth.getInstance() ;
        Currentuserid = mauth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(Currentuserid);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setPadding(20 , 10 , 20 , 10);
                male.setBackgroundResource(R.drawable.edittextback);
                female.setBackgroundResource(R.drawable.resetbackground);
                Handler mainLooperHandler = new Handler(Looper.getMainLooper());

                mainLooperHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        HashMap<String, Object> user = new HashMap<>();
                        user.put("Gender" , male.getText().toString());
                        userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful())
                                {
                                    loadFragment(new BirthdayFragment());
                                }

                            }
                        });

                    }
                }, 1000);



            }
        });

        female.setOnClickListener(v -> {
            female.setPadding(20, 10, 20, 10);
            female.setBackgroundResource(R.drawable.edittextback);
            male.setBackgroundResource(R.drawable.resetbackground);
            Handler mainLooperHandler = new Handler(Looper.getMainLooper());

            mainLooperHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    HashMap<String, Object> user = new HashMap<>();
                    user.put("Gender" , female.getText().toString());
                    userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful())
                            {
                                loadFragment(new BirthdayFragment());
                            }

                        }
                    });
                }
            }, 500);
        });
        return view ;
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment); // give your fragment container id in first parameter
        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
        transaction.commit();
    }
}
