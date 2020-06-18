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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dropoutsolutions.betterhalf.Adaptor.HomeitemAdapter;
import com.dropoutsolutions.betterhalf.ChatActivity;
import com.dropoutsolutions.betterhalf.Continue;
import com.dropoutsolutions.betterhalf.HomeActivity;
import com.dropoutsolutions.betterhalf.OnclickDetails;
import com.dropoutsolutions.betterhalf.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView recyclerView ;
    private View view ;
    private DatabaseReference userref ;
    private FirebaseAuth mAuth ;
    private DatabaseReference favref ;
    String currentuserid;
    public HomeFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        mAuth = FirebaseAuth.getInstance();
        currentuserid = mAuth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users");
        favref = FirebaseDatabase.getInstance().getReference().child("Favourites");
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
                            if (isAdded())
                            {
                                String name = (String) dataSnapshot.child("Name").getValue();
                                String Profession = (String) dataSnapshot.child("Profession").getValue();
                                String Age = (String) dataSnapshot.child("DateOfBirth").getValue();
                                String count = (String) dataSnapshot.child("Country").getValue();
                                if (dataSnapshot.hasChild("Status"))
                                {
                                    String status = dataSnapshot.child("Status").getValue().toString() ;
                                    if (status.equals("d"))
                                    {
                                        startActivity(new Intent(getContext() , Continue.class));
                                    }

                                }
                                String Image = (String) dataSnapshot.child("ProfileImage").getValue();
                                Glide.with(getContext()).load(Image).into(userViewHOlder.roundedImageView);
                                userViewHOlder.name.setText(name);
                                userViewHOlder.age.setText(Age);
                                userViewHOlder.profession.setText(Profession);
                                userViewHOlder.country.setText(count);

                                userViewHOlder.roundedImageView.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        Intent intent = new Intent(getContext() , OnclickDetails.class);
                                        intent.putExtra("Userid" , postid);
                                        startActivity(intent);
                                    }
                                });

                                if (postid.equals(currentuserid))
                                {
                                    userViewHOlder.messageimage.setVisibility(View.GONE);
                                }
                                else
                                {
                                    userViewHOlder.messageimage.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {

                                            Intent intent = new Intent(getContext() , ChatActivity.class);
                                            intent.putExtra("Userid" , postid);
                                            startActivity(intent);
                                        }
                                    });
                                }

                                if (postid.equals(currentuserid))
                                {
                                    userViewHOlder.fav.setVisibility(View.GONE);
                                }
                                else
                                {
                                    userViewHOlder.fav.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Toast.makeText(getActivity(),"Favourite", Toast.LENGTH_SHORT).show();
                                            HashMap hashMap = new HashMap();
                                            hashMap.put("Like by" , currentuserid);
                                            favref.child(currentuserid).child(postid).updateChildren(hashMap).addOnCompleteListener(
                                                    new OnCompleteListener() {
                                                        @Override
                                                        public void onComplete(@NonNull Task task) {
                                                            if (task.isSuccessful())
                                                            {
                                                                Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
                                                            }
                                                        }
                                                    }
                                            );
                                        }
                                    });

                                }


                            }

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
        private CircleImageView messageimage  , fav;
        public UserViewHOlder(@NonNull View itemView) {
            super(itemView);

            messageimage = itemView.findViewById(R.id.message);
            roundedImageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
            fav = itemView.findViewById(R.id.fav);
            profession = itemView.findViewById(R.id.profession);
            country = itemView.findViewById(R.id.country);
        }
    }

}
