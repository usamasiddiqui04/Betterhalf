package com.dropoutsolutions.betterhalf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dropoutsolutions.betterhalf.Adaptor.ProfessionAdaptor;

import java.util.ArrayList;

public class ProfessionActivity extends AppCompatActivity {
    private ArrayList<String> text = new ArrayList<>();
    private RecyclerView recyclerView ;
    String nickname;
    String dob ;
    String gender ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profession);
        nickname = getIntent().getStringExtra("nickname");
        dob = getIntent().getStringExtra("dob");
        gender = getIntent().getStringExtra("gender");

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


        recyclerView = findViewById(R.id.recyclerview);
        ProfessionAdaptor professionAdaptor = new ProfessionAdaptor(text , this  , nickname , dob , gender);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.hasFixedSize();
        recyclerView.setNestedScrollingEnabled(true);
        professionAdaptor.notifyDataSetChanged();
        recyclerView.setAdapter(professionAdaptor);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}