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
import com.jtp.hcontactlist.classlist.companilist;
import com.jtp.hcontactlist.databinding.ItemCompanylistBinding;

import java.util.List;

public class companiAdapter extends RecyclerView.Adapter<companiAdapter.companiViewHolder> {
    List<companilist> cml;
    Context context;
    public companiAdapter(List<companilist> cml){
        this.cml=cml;
    }
    @NonNull
    @Override
    public companiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        ItemCompanylistBinding binding=ItemCompanylistBinding.inflate(LayoutInflater.from(context));
        return new companiViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull companiAdapter.companiViewHolder holder, int position) {

        companilist cmll=cml.get(position);
        Glide.with(context).load(cmll.getLogo()).into(holder.img);
        holder.tn.setText(cmll.getName());
        holder.tc.setText(cmll.getCeo());
    }

    @Override
    public int getItemCount() {
        return cml.size();
    }

    public class companiViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView tn;
        TextView tc;

        public companiViewHolder(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.companiICv);
            tn=itemView.findViewById(R.id.companinameI);
            tc=itemView.findViewById(R.id.companiceoI);
        }
    }
}
