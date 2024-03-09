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

public class QuranAdapter extends RecyclerView.Adapter<QuranAdapter.QuranViewHolder> {
    private List<QuranModel> QuranModel1 = new ArrayList<>();

    @NonNull
    @Override
    public QuranViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new QuranViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.quran_custom, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull QuranViewHolder holder, int position) {
        holder.name_sura.setText(" سورة " + QuranModel1.get(position).getName());
        holder.title_sura.setText(QuranModel1.get(position).getAr());

    }

    @Override
    public int getItemCount() {
        return QuranModel1.size();
    }

    public void setList(List<QuranModel> QuranModel1) {
        this.QuranModel1 = QuranModel1;
        notifyDataSetChanged();
    }

    public class QuranViewHolder extends RecyclerView.ViewHolder {
        TextView name_sura, title_sura;
        public QuranViewHolder(@NonNull View itemView) {
            super(itemView);
            name_sura = itemView.findViewById(R.id.name_sura);
            title_sura = itemView.findViewById(R.id.title_sura);
        }
    }
}