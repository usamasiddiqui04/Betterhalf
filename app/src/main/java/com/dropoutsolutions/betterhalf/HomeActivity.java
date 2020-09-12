package com.dropoutsolutions.betterhalf;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dropoutsolutions.betterhalf.Fragment.DashBoardFragment;
import com.dropoutsolutions.betterhalf.Fragment.HomeFragment;
import com.dropoutsolutions.betterhalf.Fragment.MessageFragment;
import com.dropoutsolutions.betterhalf.Fragment.NickName;
import com.dropoutsolutions.betterhalf.Fragment.SearchFragment;
import com.dropoutsolutions.betterhalf.Fragment.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class HomeActivity extends AppCompatActivity  {

    BottomNavigationView navView ;
    ImageView cross ;
    private DatabaseReference userref ;
    private String Currentuserid ;
    private FirebaseAuth firebaseAuth ;
    TextView Completeprofile ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        navView = findViewById(R.id.nav_view);
        cross = findViewById(R.id.cross);
        Completeprofile = findViewById(R.id.completeprofile);
        userref = FirebaseDatabase.getInstance().getReference().child("Users");
        firebaseAuth = FirebaseAuth.getInstance() ;
        Currentuserid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new HomeFragment());

        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Completeprofile.setVisibility(View.GONE);
                cross.setVisibility(View.GONE);
            }
        });


        Completeprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this ,ProfilesettingActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId())
            {
                case R.id.navigation_home :
                    loadFragment(new HomeFragment());
                    return true ;
                case R.id.navigation_dashboard :
                    loadFragment(new DashBoardFragment());
                    return true ;
                case R.id.navigation_messgae :
                    loadFragment(new MessageFragment());
                    return true ;
                case R.id.navigation_setting :
                    loadFragment(new SettingFragment());
                    return true ;
                case R.id.navigation_search :
                    loadFragment(new SearchFragment());
                    return true ;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment, fragment).addToBackStack(null)
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        userref.child(Currentuserid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!dataSnapshot.hasChild("AboutDetails"))
                {
                    gotosetupactitvity();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        userref.child(Currentuserid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                {
                    long count = snapshot.getChildrenCount();

                    if (count != 23)
                    {
                        cross.setVisibility(View.VISIBLE);
                        Completeprofile.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        Completeprofile.setVisibility(View.GONE);
                        cross.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    private void gotosetupactitvity() {
        Intent intent = new Intent(HomeActivity.this , NicknameActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 1) {
            //Go back to previous Fragment
            fragmentManager.popBackStackImmediate();
        } else {
            //Nothing in the back stack, so exit
            super.onBackPressed();
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);
        }
    }



}
