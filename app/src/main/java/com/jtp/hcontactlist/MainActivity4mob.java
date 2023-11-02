package com.jtp.hcontactlist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.jtp.hcontactlist.adapter.companiAdapter;
import com.jtp.hcontactlist.classlist.companilist;
import com.jtp.hcontactlist.classlist.statelist;
import com.jtp.hcontactlist.databinding.ActivityMainActivity4mobBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4mob extends AppCompatActivity {

    private ActivityMainActivity4mobBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainActivity4mobBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<companilist> cmll=new ArrayList<>();

        companilist asus=new companilist();
        asus.setLogo("https://tse3.explicit.bing.net/th?id=OIP.GWxIHVoh9eyKB8histvODAHaDS&pid=Api&P=0&h=220");
        asus.setCeo("7236029193");
        asus.setName("ASUS");
        cmll.add(asus);

        companilist hp=new companilist();
        hp.setLogo("https://tse3.mm.bing.net/th?id=OIP.vCOK11lB3OxWKrQ5NsG_SwHaGH&pid=Api&P=0&h=220");
        hp.setName("HP");
        hp.setCeo("7236029193");
        cmll.add(hp);
        cmll.add(hp);
        cmll.add(hp);
        cmll.add(hp);
        cmll.add(hp);
        cmll.add(hp);
        cmll.add(hp);
        cmll.add(hp);
        cmll.add(hp);


        companiAdapter cmad= new companiAdapter(cmll);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        binding.companiRv.setAdapter(cmad);
        binding.companiRv.setLayoutManager(linearLayoutManager);
        binding.companiRv.setHasFixedSize(true);

    }
}