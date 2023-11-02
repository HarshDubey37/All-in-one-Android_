package com.jtp.hcontactlist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jtp.hcontactlist.databinding.ActivityTravelBinding;

public class TravelActivity extends AppCompatActivity {
    ActivityTravelBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTravelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}