package com.money.quran_sebha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class NamesAllahAdapter extends RecyclerView.Adapter<NamesAllahAdapter.NamesViewHolder> {

    private List<NamesAllahModel> NamesAllahModel = new ArrayList<>();

    @NonNull
    @Override
    public NamesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NamesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.names_allah_custom, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NamesViewHolder holder, int position) {
        holder.name.setText(NamesAllahModel.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return NamesAllahModel.size();
    }

    public void setList(List<NamesAllahModel> NamesAllahModel) {
        this.NamesAllahModel = NamesAllahModel;
        notifyDataSetChanged();
    }

    public class NamesViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        public NamesViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}