package com.dropoutsolutions.betterhalf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.hbb20.CountryCodePicker;

public class CountryActivity extends AppCompatActivity {

    CountryCodePicker countryCodePicker ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        countryCodePicker = findViewById(R.id.countrycodepicker);


        countryCodePicker.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                startActivity(new Intent(CountryActivity.this , ReligionActivity.class));
            }
        });
    }
}