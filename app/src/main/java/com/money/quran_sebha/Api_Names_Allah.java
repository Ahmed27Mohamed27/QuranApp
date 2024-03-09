package com.money.quran_sebha;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_Names_Allah {
    @GET("Names_Of_Allah.json")
    Call<List<NamesAllahModel>> getNamesAllah();
}
