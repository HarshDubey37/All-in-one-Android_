package com.jtp.hcontactlist.Univercity;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jtp.hcontactlist.R;
import com.jtp.hcontactlist.databinding.ItemUlistsBinding;
import com.jtp.hcontactlist.model.University;

import java.util.List;

public class UnivercityAdapter extends RecyclerView.Adapter<UnivercityAdapter.UnivercityViewHolder> {
    List<University> ul;
    Context context;

    public UnivercityAdapter(List<University> ul) {
        this.ul=ul;
    }

    public void setFilteredList(List<University> ful){
        this.ul=ful;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UnivercityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        ItemUlistsBinding binding=ItemUlistsBinding.inflate(LayoutInflater.from(context));
        Log.d("Message aa","line no Adapter 32");
        return new UnivercityViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull UnivercityAdapter.UnivercityViewHolder holder, int position) {
            University ull=ul.get(position);
            holder.uname.setText(ull.getName());
        holder.cname.setText(ull.getCountry());
        holder.sname.setText(ull.getStateProvince());
        holder.code.setText(ull.getAlphaTwoCode());

    }

    @Override
    public int getItemCount() {
        return ul.size();
    }

    public static class UnivercityViewHolder extends RecyclerView.ViewHolder{
        TextView uname;
        TextView cname;
        TextView sname;
        TextView code;

        public UnivercityViewHolder(@NonNull View itemView) {
            super(itemView);
            uname=itemView.findViewById(R.id.NameuTV);
            cname=itemView.findViewById(R.id.CountryUTV);
            sname=itemView.findViewById(R.id.StateUTV);
            code=itemView.findViewById(R.id.alphaTV);

        }
    }
}
