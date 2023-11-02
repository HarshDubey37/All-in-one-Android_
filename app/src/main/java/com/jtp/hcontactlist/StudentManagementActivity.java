package com.jtp.hcontactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jtp.hcontactlist.StudentManagementPortal.RegistrationActivity;
import com.jtp.hcontactlist.StudentManagementPortal.ShowStudentActivity;
import com.jtp.hcontactlist.databinding.ActivityStudentBinding;

public class StudentManagementActivity extends AppCompatActivity {

    ActivityStudentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //registration button
        binding.registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StudentManagementActivity.this, RegistrationActivity.class);
                intent.putExtra("flag",0);
                startActivity(intent);
            }
        });

        //show button function to show data from database
        binding.showstdbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StudentManagementActivity.this, ShowStudentActivity.class);
                startActivity(intent);
            }
        });
    }
}