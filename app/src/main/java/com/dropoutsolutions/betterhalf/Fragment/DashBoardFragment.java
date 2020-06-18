package com.dropoutsolutions.betterhalf.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dropoutsolutions.betterhalf.ChatActivity;
import com.dropoutsolutions.betterhalf.Continue;
import com.dropoutsolutions.betterhalf.OnclickDetails;
import com.dropoutsolutions.betterhalf.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoardFragment extends Fragment {
    RecyclerView recyclerView;
    private View view;
    private DatabaseReference userref;
    private FirebaseAuth mAuth;
    private DatabaseReference favref;
    String currentuserid;
    GridLayoutManager gridLayoutManager;

    public DashBoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dash_board, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        mAuth = FirebaseAuth.getInstance();
        currentuserid = mAuth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users");
        favref = FirebaseDatabase.getInstance().getReference().child("Favourites").child(currentuserid);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setNestedScrollingEnabled(true);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerOptions options =
                new FirebaseRecyclerOptions.Builder<User>()
                        .setQuery(favref, User.class)
                        .build();
        FirebaseRecyclerAdapter<User, UserViewHOlder> firebaseRecyclerAdapter
                = new FirebaseRecyclerAdapter<User, UserViewHOlder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull UserViewHOlder userViewHOlder, int i, @NonNull User user) {
                final String postid = getRef(i).getKey();
                userref.child(postid).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            if (isAdded()) {
                                String Image = (String) dataSnapshot.child("ProfileImage").getValue();
                                Glide.with(getContext()).load(Image).into(userViewHOlder.roundedImageView);

                                userViewHOlder.roundedImageView.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        Intent intent = new Intent(getContext(), OnclickDetails.class);
                                        intent.putExtra("Userid", postid);
                                        startActivity(intent);
                                    }
                                });

                                if (postid.equals(currentuserid)) {
                                    userViewHOlder.messageimage.setVisibility(View.GONE);
                                } else {
                                    userViewHOlder.messageimage.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {

                                            Intent intent = new Intent(getContext(), ChatActivity.class);
                                            intent.putExtra("Userid", postid);
                                            startActivity(intent);
                                        }
                                    });
                                }

                                if (postid.equals(currentuserid)) {
                                    userViewHOlder.fav.setVisibility(View.GONE);
                                } else {
                                    userViewHOlder.fav.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Toast.makeText(getActivity(), " un favourite", Toast.LENGTH_SHORT).show();
                                        }
                                    });

                                }


                            }

                        }
                        int margin = dptopx(12);

                        int top = dptopx(3);
                        int left = dptopx(3);
                        int right = dptopx(3);
                        int bottom = dptopx(3);

                        int spancount = 2 ;

                        boolean isfirst2items = i < spancount ;
                        boolean isislast2items = i > getItemCount() - spancount ;

                        if (isfirst2items)
                        {
                            top = dptopx(3);
                        }
                        if (isislast2items)
                        {
                            bottom = dptopx(3);
                        }

                        boolean isleftside = (i+1) % spancount != 0 ;
                        boolean isrightside = !isleftside ;

                        if (isleftside)
                        {
                            right = dptopx(3);
                        }
                        if (isrightside)
                        {
                            left = dptopx(3);
                        }



                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) userViewHOlder.constraintLayout.getLayoutParams();
                        layoutParams.setMargins(left , top , right , bottom);
                        userViewHOlder.constraintLayout.setLayoutParams(layoutParams);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
            private int dptopx ( int dp )
            {
                float px = dp * getContext().getResources().getDisplayMetrics().density;
                return (int) px ;
            }

            @NonNull
            @Override
            public UserViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favouriterecyclerview, parent, false);
                UserViewHOlder userViewHOlder = new UserViewHOlder(view);
                return userViewHOlder;
            }

        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
        firebaseRecyclerAdapter.startListening();
    }

    public static class UserViewHOlder extends RecyclerView.ViewHolder {
        private RoundedImageView roundedImageView;
        ConstraintLayout constraintLayout;
        private TextView name, age, profession, country;
        private CircleImageView messageimage, fav;

        public UserViewHOlder(@NonNull View itemView) {
            super(itemView);

            messageimage = itemView.findViewById(R.id.message);
            constraintLayout = itemView.findViewById(R.id.one);
            roundedImageView = itemView.findViewById(R.id.imageView);
            fav = itemView.findViewById(R.id.fav);
        }
    }
}
//
//    private void setupViewPager(ViewPager viewPager) {
//        ViewPagerAdapter adapter = new ViewPagerAdapter(getParentFragmentManager());
//        adapter.addFragment(new LikeFragment(), "Liked You");
//        adapter.addFragment(new LikedbyFragment(), "You Liked");
//        viewPager.setAdapter(adapter);
//
//    }
//
//    static class ViewPagerAdapter extends FragmentPagerAdapter {
//        private final List<Fragment> mFragmentList = new ArrayList<>();
//        private final List<String> mFragmentTitleList = new ArrayList<>();
//
//        ViewPagerAdapter(FragmentManager manager) {
//            super(manager);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return mFragmentList.get(position);
//        }
//
//        @Override
//        public int getCount() {
//            return mFragmentList.size();
//        }
//
//        public void addFragment(Fragment fragment, String title) {
//            mFragmentList.add(fragment);
//            mFragmentTitleList.add(title);
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return mFragmentTitleList.get(position);
//        }
//    }
//
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        setupViewPager(viewPager);
//    }

