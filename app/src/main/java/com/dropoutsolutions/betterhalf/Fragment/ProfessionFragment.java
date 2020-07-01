package com.dropoutsolutions.betterhalf.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;

import com.dropoutsolutions.betterhalf.Adaptor.ProfessionAdaptor;
import com.dropoutsolutions.betterhalf.GetString;
import com.dropoutsolutions.betterhalf.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfessionFragment extends Fragment {



    private ArrayList<String> text = new ArrayList<>();

    public ProfessionFragment() {
        // Required empty public constructor
    }
    private RecyclerView recyclerView ;
    private View view ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profession, container, false);
        text.clear();
        text.add("Accountant");
        text.add("Actor");
        text.add("Architect");
        text.add("Astronomer");
        text.add("Author");
        text.add("Baker");
        text.add("Bricklayer");
        text.add("Bus driver");
        text.add("Butcher");
        text.add("Carpenter");
        text.add("Chef");
        text.add("Cleaner");
        text.add("Dentist");
        text.add("Designer");
        text.add("Doctor");
        text.add("Electrician");
        text.add("Engineer");
        text.add("Factory worker");
        text.add("Farmer");
        text.add("Fireman");
        text.add("Gardener");
        text.add("Journalist");
        text.add("Hairdresser");
        text.add("Judge");
        text.add("Lawyer");
        text.add("Lecturer");
        text.add("Librarian");
        text.add("Lifeguard");
        text.add("Mechanic");
        text.add("Model");
        text.add("Newsreader");
        text.add("Nurse");
        text.add("Optician");
        text.add("Painter");
        text.add("Pharmacist");
        text.add("Photograph");
        text.add("Pilot");
        text.add("Receptionist");
        text.add("Teacher");
        text.add("Waiter");
        text.add("Soldier");


//        recyclerView = view.findViewById(R.id.recyclerview);
//        ProfessionAdaptor professionAdaptor = new ProfessionAdaptor(text , getContext() );
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setNestedScrollingEnabled(false);
//        professionAdaptor.notifyDataSetChanged();
//        recyclerView.setAdapter(professionAdaptor);

        return view ;
    }

}
