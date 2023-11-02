package com.jtp.hcontactlist.StudentManagementPortal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.jtp.hcontactlist.R;
import com.jtp.hcontactlist.StudentManagementActivity;
import com.jtp.hcontactlist.StudentManagementPortal.DataBase.Dbmanager;
import com.jtp.hcontactlist.classlist.Students;
import com.jtp.hcontactlist.databinding.ActivityRegistrationBinding;

public class RegistrationActivity extends AppCompatActivity {
    ActivityRegistrationBinding binding;
    String gender="Male";
    Students std = new Students();
    Dbmanager db = new Dbmanager(RegistrationActivity.this);
    EditText name, mobile, email;
    RadioGroup rdg;
    CheckBox cou1, cou2;
    Button subb;
    String n, m, ml, c1, c2, g;
    int gen1,gen2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        name = findViewById(R.id.edtname);
        email = findViewById(R.id.edtmail);
        mobile = findViewById(R.id.edtmob);
        cou1 = findViewById(R.id.scjava);
        cou2 = findViewById(R.id.scandroid);
        gen1 =R.id.rdmale;
        gen2 = R.id.rdfemale;
        rdg=findViewById(R.id.radiogrp);
        subb = findViewById(R.id.submitbtn);
        Intent i = getIntent();

        //for first time registration
        if (i.getIntExtra("flag", -1) == 0) {
            //radio group function and implementation
            radiofun();
            //submit button implementation
            subb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setsubmit();
                    long id = db.saveStudent(std);
                    //Toast message
                    if (id > 0) {
                        Toast.makeText(RegistrationActivity.this, "Registation Success!!", Toast.LENGTH_LONG).show();
                        finish();
                    }
                    else
                        Toast.makeText(RegistrationActivity.this, "Registration Failed???", Toast.LENGTH_LONG).show();
                }
            });
        }
        //for update previous details
        else if (i.getIntExtra("flag", -1) == 1) {
            //get and set intent data
            getsetintentdata();
            //setting title on action bar
            ActionBar a=getSupportActionBar();
            if (a!=null)
                a.setTitle(n);
           //radio button click listener
           // kk=0;
            radiofun();
            //change text of Button from Submit to Update for Updation function
            subb.setText(R.string.updatebtntext);
            //click listener on update button
            subb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setsubmit();
                    int k=i.getIntExtra("id",-1);
                    db.updateStudent(std,k);
                    recreate();
                    Toast.makeText(RegistrationActivity.this, "Student Updated!!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
        //if error occurred
        else {
            Intent intent = new Intent(RegistrationActivity.this, StudentManagementActivity.class);
            Toast.makeText(this, "ERROR!!", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
    }

    //Setting data from editText to student class object
    private void setsubmit() {
        String name = binding.edtname.getText().toString();
        String mob = binding.edtmob.getText().toString();
        String email = binding.edtmail.getText().toString();

        std.setSemail(email);
        std.setSmob(mob);
        std.setSname(name);

        if (binding.scjava.isChecked()) {
            String java = binding.scjava.getText().toString();
            std.setScourse1(java);
        }
        if (binding.scandroid.isChecked()) {
            String android = binding.scandroid.getText().toString();
            std.setScourse2(android);
        }
        std.setSgender(gender);
    }

    // Radio button function
    private void radiofun() {
        rdg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rdmale:
                        gender = binding.rdmale.getText().toString();
                        break;
                    case R.id.rdfemale:
                        gender = binding.rdfemale.getText().toString();
                        break;
                    default:
                        gender = "Gender not selected";
                }
            }
        });
    }

    //Get and set Data from Intent
    private void getsetintentdata() {
            Intent i=getIntent();
        if (i.hasExtra("id") && i.hasExtra("name") && i.hasExtra("mobile") && i.hasExtra("email")) {
            boolean c11=true,c22=true;
            //getting data from intent
            n = i.getStringExtra("name");
            m = i.getStringExtra("mobile");
            ml = i.getStringExtra("email");
            c1 = i.getStringExtra("course1");
            c2 = i.getStringExtra("course2");
            g=i.getStringExtra("gender");
            //seting data of check box
            if(c1==null)
                c11=false;
            if (c2==null)
                c22=false;
            //seting radio button
            if (g.equals("Male")) {
                rdg.check(gen1);
                gender=g;
            }
            else {
                rdg.check(gen2);
                gender="Female";
            }
            //set string data to editText field
            name.setText(n);
            email.setText(ml);
            mobile.setText(m);
            cou1.setChecked(c11);
            cou2.setChecked(c22);
        }
    }

}