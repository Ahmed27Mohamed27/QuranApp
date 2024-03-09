package com.money.quran_sebha;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuranViewModel extends ViewModel {
    MutableLiveData<List<QuranModel>> postsMutableLiveData = new MutableLiveData<>();
    MutableLiveData<List<AzkarModel>> azkarMutableLiveData = new MutableLiveData<>();
    MutableLiveData<List<NamesAllahModel>> NamesMutableLiveData = new MutableLiveData<>();
    MutableLiveData<String> posts = new MutableLiveData<>();
    public void getPosts() {
        QuranClient.getINSTANCE().getPosts().enqueue(new Callback<List<QuranModel>>() {
            @Override
            public void onResponse(Call<List<QuranModel>> call, Response<List<QuranModel>> response) {
                postsMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<QuranModel>> call, Throwable t) {
                posts.setValue("errr");
            }
        });
    }
    public void getAzkar() {
        AzkarClient.getINSTANCE().getAzkar().enqueue(new Callback<List<AzkarModel>>() {
            @Override
            public void onResponse(Call<List<AzkarModel>> call, Response<List<AzkarModel>> response) {
                azkarMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<AzkarModel>> call, Throwable t) {
                posts.setValue("errr");
            }
        });
    }

    public void getNamesAllah() {
        NamesAllahClient.getINSTANCE().getNamesAllah().enqueue(new Callback<List<NamesAllahModel>>() {
            @Override
            public void onResponse(Call<List<NamesAllahModel>> call, Response<List<NamesAllahModel>> response) {
                NamesMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<NamesAllahModel>> call, Throwable t) {

            }
        });
    }
}