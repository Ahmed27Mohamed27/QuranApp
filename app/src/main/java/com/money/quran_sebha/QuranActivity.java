package com.money.quran_sebha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuranActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    QuranViewModel quranViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran);

        recyclerView = findViewById(R.id.rec);

        quranViewModel = ViewModelProviders.of(this).get(QuranViewModel.class);

        quranViewModel.getPosts();
        final QuranAdapter adapter = new QuranAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        quranViewModel.postsMutableLiveData.observe(this, new Observer<List<QuranModel>>() {
            @Override
            public void onChanged(List<QuranModel> postModels) {
                adapter.setList(postModels);
            }
        });

    }
}