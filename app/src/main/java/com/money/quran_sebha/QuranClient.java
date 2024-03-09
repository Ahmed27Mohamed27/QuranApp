package com.money.quran_sebha;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuranClient {
    private static final String BASE_URL = "https://raw.githubusercontent.com/Alsarmad/Quran-Json/main/";
    private Api_Quran postInterface;
    private static QuranClient INSTANCE;

    public QuranClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        postInterface = retrofit.create(Api_Quran.class);
    }

    public static QuranClient getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new QuranClient();
        }
        return INSTANCE;
    }

    public Call<List<QuranModel>> getPosts() {
        return postInterface.getQuran();
    }

}