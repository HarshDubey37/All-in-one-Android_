package com.jtp.hcontactlist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.jtp.hcontactlist.adapter.StateAdapter;
import com.jtp.hcontactlist.classlist.statelist;
import com.jtp.hcontactlist.databinding.ActivityMainActivity3stBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3st extends AppCompatActivity {

     ActivityMainActivity3stBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainActivity3stBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<statelist> sl=new ArrayList<>();

        statelist asus=new statelist();
        asus.setImg("https://tse3.explicit.bing.net/th?id=OIP.GWxIHVoh9eyKB8histvODAHaDS&pid=Api&P=0&h=220");
        asus.setCmname("7236029193");
        asus.setName("ASUS");
        sl.add(asus);

        statelist hp=new statelist();
        hp.setImg("https://tse3.mm.bing.net/th?id=OIP.vCOK11lB3OxWKrQ5NsG_SwHaGH&pid=Api&P=0&h=220");
        hp.setName("HP");
        hp.setCmname("7236029193");
        sl.add(hp);

        statelist lenovo=new statelist();
        lenovo.setImg("https://tse1.mm.bing.net/th?id=OIP.rnjhkEeOi14Q79tHkFTJZwHaEo&pid=Api&P=0&h=220");
        lenovo.setName("LENOVO");
        lenovo.setCmname("7236029193");
        sl.add(lenovo);

        statelist apple=new statelist();
        apple.setImg("https://cdn-icons-png.flaticon.com/128/0/747.png");
        apple.setName("APPLE");
        apple.setCmname("7236029193");
        sl.add(apple);

        statelist acer=new statelist();
        acer.setImg("https://tse4.mm.bing.net/th?id=OIP.49ia5ObkePa3AphbFf4UzwHaCO&pid=Api&P=0&h=220");
        acer.setName("ACER");
        acer.setCmname("7236029193");
        sl.add(acer);

        statelist dell=new statelist();
        dell.setImg("https://tse1.mm.bing.net/th?id=OIP.NdSKtdh9dev9189IXRWmkgHaFQ&pid=Api&P=0&h=220");
        dell.setName("DELL");
        dell.setCmname("7236029193");
        sl.add(dell);
        sl.add(dell);
        sl.add(dell);
        sl.add(dell);
        sl.add(dell);
        sl.add(dell);


        StateAdapter sa=new StateAdapter(sl);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        binding.stateRv.setLayoutManager(linearLayoutManager);
        binding.stateRv.setHasFixedSize(true);
        binding.stateRv.setAdapter(sa);


        //phone call



    }
}