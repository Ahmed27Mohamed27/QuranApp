package com.money.quran_sebha;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NamesAllahClient {
    private static final String BASE_URL = "https://raw.githubusercontent.com/Alsarmad/Names_Of_Allah_Json/main/";
    private Api_Names_Allah apiNamesAllah;
    private static NamesAllahClient INSTANCE;

    public NamesAllahClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiNamesAllah = retrofit.create(Api_Names_Allah.class);
    }

    public static NamesAllahClient getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new NamesAllahClient();
        }
        return INSTANCE;
    }
    public Call<List<NamesAllahModel>> getNamesAllah(){
        return apiNamesAllah.getNamesAllah();
    }
}