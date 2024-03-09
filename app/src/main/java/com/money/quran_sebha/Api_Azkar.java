package com.money.quran_sebha;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_Azkar {
    @GET("azkar-json.json")
    Call<List<AzkarModel>> getAzkar();
}
