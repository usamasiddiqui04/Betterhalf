package com.dropoutsolutions.betterhalf.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dropoutsolutions.betterhalf.Adaptor.HomeitemAdapter;
import com.dropoutsolutions.betterhalf.HomeActivity;
import com.dropoutsolutions.betterhalf.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    int [] images = {R.drawable.lovepic , R.drawable.lovepic , R.drawable.lovepic};
    String [] name = {"Usama Ali" , "Laiba Farooq" , "Hassam Saeed"};
    private HomeitemAdapter homeitemAdapter  = new HomeitemAdapter(getContext() , images , name);
    private RecyclerView recyclerView ;
    private View view ;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        homeitemAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(homeitemAdapter);
        return view ;
    }

}
