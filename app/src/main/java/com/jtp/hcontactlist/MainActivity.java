package com.jtp.hcontactlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.jtp.hcontactlist.RefreshTime.Refresh.RefreshActivity;
import com.jtp.hcontactlist.TicTocToGame.TicTocActivity;
import com.jtp.hcontactlist.Univercity.UnivercityActivity;
import com.jtp.hcontactlist.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Animation am= AnimationUtils.loadAnimation(this,R.anim.designfirstpage);
        LinearLayout ll=findViewById(R.id.mainll);
        ll.setAnimation(am);;

        //Contact Activity
        binding.contactCv.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(MainActivity.this,MainActivity2.class);
              startActivity(intent);
          }
      });

        //Company Activity
        binding.companiCvm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainActivity4mob.class);
                startActivity(intent);
            }
        });

        //State Activity
        binding.stateCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainActivity3st.class);
                startActivity(intent);
            }
        });

        //Student Management Activity
        binding.studentmanagementCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StudentManagementActivity.class);
                startActivity(intent);

            }
        });

        //Tic Toc Game Detail Activity
        binding.GameZCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TicTocActivity.class);
                startActivity(intent);
            }
        });

        //University Details Activity
        binding.UnivercityCVM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, UnivercityActivity.class);
                startActivity(intent);
            }
        });

        //Refresh yourself
        binding.RandCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, RefreshActivity.class);
                startActivity(intent);
            }
        });

        //Travel Details Activity
        binding.TravelCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}