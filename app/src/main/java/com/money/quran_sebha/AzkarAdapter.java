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

public class AzkarAdapter extends RecyclerView.Adapter<AzkarAdapter.AzkarViewHolder> {
    private List<AzkarModel> AzkarModel = new ArrayList<>();

    @NonNull
    @Override
    public AzkarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AzkarViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.azkar_custom, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AzkarViewHolder holder, int position) {
        holder.name_azkar.setText(AzkarModel.get(position).getCategory());
        holder.title_azkar.setText(AzkarModel.get(position).getText());
        holder.count.setText(" عدد التكرارات = " + AzkarModel.get(position).getCount());
    }

    @Override
    public int getItemCount() {
        return AzkarModel.size();
    }

    public void setList(List<AzkarModel> AzkarModel) {
        this.AzkarModel = AzkarModel;
        notifyDataSetChanged();
    }

    public class AzkarViewHolder extends RecyclerView.ViewHolder {
        TextView name_azkar, title_azkar, count;
        public AzkarViewHolder(@NonNull View itemView) {
            super(itemView);
            name_azkar = itemView.findViewById(R.id.name_sura);
            title_azkar = itemView.findViewById(R.id.title_sura);
            count = itemView.findViewById(R.id.count);
        }
    }
}