package com.money.quran_sebha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class NamesAllahActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    QuranViewModel quranViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names_allah);

        recyclerView = findViewById(R.id.rec);

        quranViewModel = ViewModelProviders.of(this).get(QuranViewModel.class);

        final NamesAllahAdapter adapter = new NamesAllahAdapter();
        quranViewModel.getNamesAllah();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        quranViewModel.NamesMutableLiveData.observe(this, new Observer<List<NamesAllahModel>>() {
            @Override
            public void onChanged(List<NamesAllahModel> namesAllahModels) {
                adapter.setList(namesAllahModels);
            }
        });

    }
}