package com.dropoutsolutions.betterhalf;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.dropoutsolutions.betterhalf.Fragment.DashBoardFragment;
import com.dropoutsolutions.betterhalf.Fragment.HomeFragment;
import com.dropoutsolutions.betterhalf.Fragment.MessageFragment;
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

public class HomeActivity extends AppCompatActivity  {

    BottomNavigationView navView ;
    private DatabaseReference userref ;
    private String Currentuserid ;
    private FirebaseAuth firebaseAuth ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        navView = findViewById(R.id.nav_view);
        userref = FirebaseDatabase.getInstance().getReference().child("Users");
        firebaseAuth = FirebaseAuth.getInstance() ;
        Currentuserid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new HomeFragment());


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
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();

        userref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!dataSnapshot.hasChild(Currentuserid))
                {
                    gotosetupactitvity();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void gotosetupactitvity() {
        Intent intent = new Intent(HomeActivity.this , Continue.class);
        startActivity(intent);
    }
}
