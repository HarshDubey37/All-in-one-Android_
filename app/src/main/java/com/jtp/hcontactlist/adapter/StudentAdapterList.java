package com.jtp.hcontactlist.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.jtp.hcontactlist.R;
import com.jtp.hcontactlist.StudentManagementPortal.RegistrationActivity;
import com.jtp.hcontactlist.classlist.Students;
import com.jtp.hcontactlist.databinding.ItemStudentlistBinding;
import com.jtp.hcontactlist.interfaces.OnDeleteStudentListener;

import java.util.List;

public class StudentAdapterList extends RecyclerView.Adapter<StudentAdapterList.StudentListViewHolder>{
    //declare globle variable
    List<Students> stdad;
    Context context;
    Activity activity;
    OnDeleteStudentListener o;

    //constructor of Adapter
    public StudentAdapterList(List<Students> stdad,OnDeleteStudentListener o,Activity activity){
        this.stdad=stdad;
        this.activity=activity;
        this.o=o;
    }

   //creation of view holder @method of recyclerView
    @NonNull
    @Override
    public StudentListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        ItemStudentlistBinding binding=ItemStudentlistBinding.inflate(LayoutInflater.from(context));
        return new StudentListViewHolder(binding.getRoot());
    }

    //binding view holder @method of recyclerview
    @Override
    public void onBindViewHolder(@NonNull StudentListViewHolder holder, int position) {
        Students sl=stdad.get(position);
        //holder conection from student class to view holder
        holder.candroid.setText(sl.getScourse2());
        holder.cjava.setText(sl.getScourse1());
        holder.name.setText(sl.getSname());
        holder.gender.setText(sl.getSgender());
        holder.email.setText(sl.getSemail());
        holder.mobile.setText(sl.getSmob());
        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                o.ondeletestudentClicked(sl.getId());
            }
        });
        //Update button click listener
        holder.updt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, RegistrationActivity.class);
                intent.putExtra("flag",1);
                intent.putExtra("id",sl.getId());
                intent.putExtra("name",sl.getSname());
                intent.putExtra("mobile",sl.getSmob());
                intent.putExtra("email",sl.getSemail());
                intent.putExtra("course1",sl.getScourse1());
                intent.putExtra("course2",sl.getScourse2());
                intent.putExtra("gender",sl.getSgender());
                activity.startActivityForResult(intent,1);
            }
        });
    }

    //geting student list size @methond of recyclerview
    @Override
    public int getItemCount() {
        return stdad.size();
    }

    //View Holder class decleare by yourself
    public static class StudentListViewHolder extends RecyclerView.ViewHolder{
        //declaration of variable
        TextView name,email,mobile,cjava,candroid,gender;
        ImageView del;
        CardView updt;
        //View Holder constructor
        public StudentListViewHolder(@NonNull View itemView) {
            super(itemView);
            //set data by holder to id of every field
            name=itemView.findViewById(R.id.NamestdTV);
            email=itemView.findViewById(R.id.EmailstdTV);
            mobile=itemView.findViewById(R.id.mobilestdTV);
            candroid=itemView.findViewById(R.id.androidstdTV);
            cjava=itemView.findViewById(R.id.javastdTV);
            gender=itemView.findViewById(R.id.genderstdTV);
            del=itemView.findViewById(R.id.delstdbtn);
            updt=itemView.findViewById(R.id.stdcarsupdtbtn);
        }
    }
}
