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
import com.jtp.hcontactlist.classlist.statelist;
import com.jtp.hcontactlist.databinding.ItemStatesBinding;

import java.util.List;

public class StateAdapter  extends RecyclerView.Adapter<StateAdapter.StateViewHolder> {
    List<statelist> sl;
    Context context;
    public StateAdapter(List<statelist> sl){
        this.sl=sl;
    }

    @NonNull
    @Override
    public StateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        ItemStatesBinding binding=ItemStatesBinding.inflate(LayoutInflater.from(context));
        return new StateViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull StateViewHolder holder, int position) {
        statelist s=sl.get(position);

        Glide.with(context).load(s.getImg()).into(holder.im);
        holder.cnm.setText(s.getCmname());
        holder.nm.setText(s.getName());

    }

    @Override
    public int getItemCount() {
        return sl.size();
    }

    static class StateViewHolder extends RecyclerView.ViewHolder{
        ImageView im;
        TextView nm;
        TextView cnm;

        public StateViewHolder(@NonNull View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.stateICv);
            nm=itemView.findViewById(R.id.snameI);
            cnm=itemView.findViewById(R.id.statecmI);
        }
    }
}
