package com.dropoutsolutions.betterhalf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.dropoutsolutions.betterhalf.Fragment.MaritalstatusFragment;
import com.dropoutsolutions.betterhalf.Fragment.NickName;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FrameLayout frame = new FrameLayout(this);
        frame.setId(R.id.frameLayout);
        setContentView(frame, new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));

        if (savedInstanceState == null) {
            loadFragment(new MaritalstatusFragment());
        }

    }
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadFragment(new MaritalstatusFragment());
    }
}