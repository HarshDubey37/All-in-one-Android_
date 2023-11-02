package com.jtp.hcontactlist;

import static com.jtp.hcontactlist.utilities.Contants.PHONE_CALL_PERMISSION_CODE;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.jtp.hcontactlist.adapter.ContactAdapter;
import com.jtp.hcontactlist.classlist.contactlist;
import com.jtp.hcontactlist.databinding.ActivityMain2Binding;
import com.jtp.hcontactlist.interfaces.OnCalllClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements OnCalllClickListener {

    ActivityMain2Binding binding;
    String phoneNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<contactlist> cl = new ArrayList<>();

        contactlist asus = new contactlist();
        asus.setImg("https://tse3.explicit.bing.net/th?id=OIP.GWxIHVoh9eyKB8histvODAHaDS&pid=Api&P=0&h=220");
        asus.setMob("7236029193");
        asus.setName("ASUS");
        cl.add(asus);

        contactlist hp = new contactlist();
        hp.setImg("https://tse3.mm.bing.net/th?id=OIP.vCOK11lB3OxWKrQ5NsG_SwHaGH&pid=Api&P=0&h=220");
        hp.setName("HP");
        hp.setMob("7236029193");
        cl.add(hp);

        contactlist lenovo = new contactlist();
        lenovo.setImg("https://tse1.mm.bing.net/th?id=OIP.rnjhkEeOi14Q79tHkFTJZwHaEo&pid=Api&P=0&h=220");
        lenovo.setName("LENOVO");
        lenovo.setMob("7236029193");
        cl.add(lenovo);

        contactlist apple = new contactlist();
        apple.setImg("https://cdn-icons-png.flaticon.com/128/0/747.png");
        apple.setName("APPLE");
        apple.setMob("7236029193");
        cl.add(apple);

        contactlist acer = new contactlist();
        acer.setImg("https://tse4.mm.bing.net/th?id=OIP.49ia5ObkePa3AphbFf4UzwHaCO&pid=Api&P=0&h=220");
        acer.setName("ACER");
        acer.setMob("7236029193");
        cl.add(acer);

        contactlist dell = new contactlist();
        dell.setImg("https://tse1.mm.bing.net/th?id=OIP.NdSKtdh9dev9189IXRWmkgHaFQ&pid=Api&P=0&h=220");
        dell.setName("DELL");
        dell.setMob("7236029193");
        cl.add(dell);
        cl.add(dell);
        cl.add(dell);
        cl.add(dell);
        cl.add(dell);
        cl.add(dell);

        ContactAdapter contactAdapter = new ContactAdapter(cl,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.contactRv.setLayoutManager(linearLayoutManager);
        binding.contactRv.setHasFixedSize(true);
        binding.contactRv.setAdapter(contactAdapter);
    }


        //phone call

        // Function to check and request permission

        @Override
        public void onRequestPermissionsResult ( int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);


            if (requestCode == PHONE_CALL_PERMISSION_CODE) {

                // Checking whether user granted the permission or not.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    makeACall();

                    // Showing the toast message
                    Toast.makeText(MainActivity2.this, "Phone Call Permission Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity2.this, "Phone Call Permission Denied", Toast.LENGTH_SHORT).show();
                }
            }
        }


    public void makeACall() {
        String uri = "tel:" + phoneNo;
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }



    @Override
    public void onCallCLicked(String  phoneNo) {
        this.phoneNo = phoneNo;
       // checkPermission(Manifest.permission.CALL_PHONE, PHONE_CALL_PERMISSION_CODE);
        checkPermission(Manifest.permission.CALL_PHONE,PHONE_CALL_PERMISSION_CODE);

        Toast.makeText(MainActivity2.this, "Phone Number" + phoneNo, Toast.LENGTH_SHORT).show();
    }

    public void checkPermission(String permission, int requestCode) {

        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(MainActivity2.this, permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(MainActivity2.this, new String[]{permission}, requestCode);
        } else {

            makeACall();
            Toast.makeText(MainActivity2.this, "Permission already granted", Toast.LENGTH_SHORT).show();
        }
    }
}

