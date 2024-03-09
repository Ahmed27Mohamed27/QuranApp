package com.money.quran_sebha;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_Quran {
    @GET("Quran.json")
    Call<List<QuranModel>> getQuran();
}
