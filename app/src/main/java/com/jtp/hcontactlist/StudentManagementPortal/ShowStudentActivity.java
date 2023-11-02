package com.jtp.hcontactlist.StudentManagementPortal;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.jtp.hcontactlist.R;
import com.jtp.hcontactlist.StudentManagementPortal.DataBase.Dbmanager;
import com.jtp.hcontactlist.adapter.StudentAdapterList;
import com.jtp.hcontactlist.classlist.Students;
import com.jtp.hcontactlist.databinding.ActivityShowStudentBinding;
import com.jtp.hcontactlist.interfaces.OnDeleteStudentListener;

import java.util.List;

public class ShowStudentActivity extends AppCompatActivity implements OnDeleteStudentListener {

    ActivityShowStudentBinding binding;
    Dbmanager db=new Dbmanager(this);
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityShowStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

            showstudent();
    }

    //Show student from data base and Adapter conection
    void showstudent(){
        List<Students> std=db.getAllStudent();
        StudentAdapterList ad=new StudentAdapterList(std, this,ShowStudentActivity.this);
        LinearLayoutManager ll=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        binding.showstdRV.setHasFixedSize(true);
        binding.showstdRV.setLayoutManager(ll);
        binding.showstdRV.setAdapter(ad);
    }

    //Activity Result to show result of updates at run time
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    //delete student data from database
    @Override
    public void ondeletestudentClicked(int i) {
        id=i;
        confirm();
    }
    //delete all data
    public void deletealldata(){

    }
    void confirm(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Delete this Student");
        builder.setMessage("Are you sure you want to delete??");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int r=db.deleteStudent(id);
                if (r>0)
                    showstudent();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                toastF();
            }
        });
        builder.create().show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.deleteall,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.deletealls);
        confirmAll();
        return super.onOptionsItemSelected(item);
    }

    private void confirmAll() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Delete All??");
        builder.setMessage("Are you sure ??");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                db.deleteall();
                finish();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                toastF();
            }
        });
        builder.create().show();
    }
    void toastF(){
        Toast.makeText(this,"Failled!!",Toast.LENGTH_SHORT).show();
    }
}