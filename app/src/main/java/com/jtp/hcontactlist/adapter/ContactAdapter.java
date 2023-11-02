package com.jtp.hcontactlist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jtp.hcontactlist.R;
import com.jtp.hcontactlist.classlist.contactlist;
import com.jtp.hcontactlist.databinding.ItemContactBinding;
import com.jtp.hcontactlist.interfaces.OnCalllClickListener;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    List<contactlist> cl;
    OnCalllClickListener onCalllClickListener;

    Context context;
     public ContactAdapter(List<contactlist> cl,OnCalllClickListener onCalllClickListener){
        this.cl=cl;
        this.onCalllClickListener=onCalllClickListener;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         context=parent.getContext();
        ItemContactBinding binding=ItemContactBinding.inflate(LayoutInflater.from(context));
        return new ContactViewHolder(binding.getRoot());
    }
    @Override
    public int getItemCount() {
        return cl.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ContactViewHolder holder, int position) {
         contactlist c=cl.get(position);

         Glide.with(context).load(c.getImg()).into(holder.img);
         holder.mobile.setText(c.getMob());
         holder.name.setText(c.getName());
         holder.cal.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 onCalllClickListener.onCallCLicked(c.getMob());
             }
         });

    }


static class ContactViewHolder extends RecyclerView.ViewHolder {

    ImageView img;
    ImageView cal;
    TextView name;
    TextView mobile;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);

        img=itemView.findViewById(R.id.contactICv);
        name=itemView.findViewById(R.id.nameI);
        mobile=itemView.findViewById(R.id.mobileI);
        cal=itemView.findViewById(R.id.callId);
    }
}
}
