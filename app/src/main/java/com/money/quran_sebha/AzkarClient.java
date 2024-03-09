package com.money.quran_sebha;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AzkarClient {
    private static final String BASE_URL = "https://raw.githubusercontent.com/Ahmed27Mohamed27/Ahmed27Mohamed27/main/";
    private Api_Azkar api_azkar;
    private static AzkarClient INSTANCE;

    public AzkarClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api_azkar = retrofit.create(Api_Azkar.class);
    }

    public static AzkarClient getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new AzkarClient();
        }
        return INSTANCE;
    }
    public Call<List<AzkarModel>> getAzkar(){
        return api_azkar.getAzkar();
    }
}