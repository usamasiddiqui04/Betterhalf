package com.dropoutsolutions.betterhalf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dropoutsolutions.betterhalf.Adaptor.ProfessionAdaptor;

import java.util.ArrayList;

public class SetProfessionActivity extends AppCompatActivity {

    private ArrayList<String> text = new ArrayList<>();
    private RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setprofession);

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
        text.add("Other");


        recyclerView = findViewById(R.id.recyclerview);
        SetProfessionAdaptor professionAdaptor = new SetProfessionAdaptor(text , this );
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.hasFixedSize();
        recyclerView.setNestedScrollingEnabled(true);
        professionAdaptor.notifyDataSetChanged();
        recyclerView.setAdapter(professionAdaptor);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this , ProfilesettingActivity.class));
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}