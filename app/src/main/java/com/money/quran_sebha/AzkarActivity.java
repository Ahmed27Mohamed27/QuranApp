package com.money.quran_sebha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class AzkarActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    QuranViewModel quranViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar);

        recyclerView = findViewById(R.id.rec);

        quranViewModel = ViewModelProviders.of(this).get(QuranViewModel.class);

        final AzkarAdapter adapter = new AzkarAdapter();
        quranViewModel.getAzkar();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        quranViewModel.azkarMutableLiveData.observe(this, new Observer<List<AzkarModel>>() {
            @Override
            public void onChanged(List<AzkarModel> azkarModels) {
                adapter.setList(azkarModels);
            }
        });

    }
}