package com.dropoutsolutions.betterhalf.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dropoutsolutions.betterhalf.Adaptor.HomeitemAdapter;
import com.dropoutsolutions.betterhalf.Continue;
import com.dropoutsolutions.betterhalf.HomeActivity;
import com.dropoutsolutions.betterhalf.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.makeramen.roundedimageview.RoundedImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView recyclerView ;
    private View view ;
    private DatabaseReference userref ;
    private FirebaseAuth mAuth ;
    public HomeFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        mAuth = FirebaseAuth.getInstance();
        userref = FirebaseDatabase.getInstance().getReference().child("Users");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        return view ;
    }
    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerOptions options =
                new FirebaseRecyclerOptions.Builder<User>()
                        .setQuery(userref ,User.class)
                        .build();
        FirebaseRecyclerAdapter<User , UserViewHOlder> firebaseRecyclerAdapter
                = new FirebaseRecyclerAdapter<User, UserViewHOlder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull UserViewHOlder userViewHOlder, int i, @NonNull User user) {
                final String postid = getRef(i).getKey();
                userref.child(postid).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists())
                        {
                            String name = (String) dataSnapshot.child("Name").getValue();
                            String Profession = (String) dataSnapshot.child("Profession").getValue();
                            String Age = (String) dataSnapshot.child("DateOfBirth").getValue();
//                            if (dataSnapshot.hasChild("Status"))
//                            {
//                                String status = dataSnapshot.child("Status").getValue().toString() ;
//                                if (status.equals("d"))
//                                {
//                                    startActivity(new Intent(getContext() , Continue.class));
//                                }
//
//                            }
                            String Image = (String) dataSnapshot.child("ProfileImage").getValue();
                            Glide.with(getActivity()).load(Image).into(userViewHOlder.roundedImageView);
                            userViewHOlder.name.setText(name);
                            userViewHOlder.age.setText(Age);
                            userViewHOlder.profession.setText(Profession);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
            @NonNull
            @Override
            public UserViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mainhomerecylerview , parent , false);
                UserViewHOlder userViewHOlder = new UserViewHOlder(view);
                return userViewHOlder ;
            }

        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
        firebaseRecyclerAdapter.startListening();
    }

    public static class UserViewHOlder extends RecyclerView.ViewHolder {
        private RoundedImageView roundedImageView ;
        private TextView name , age , profession , country ;
        public UserViewHOlder(@NonNull View itemView) {
            super(itemView);

            roundedImageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
            profession = itemView.findViewById(R.id.profession);
            country = itemView.findViewById(R.id.country);
        }
    }

}
