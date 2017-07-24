package com.diodev.mva;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static Retrofit.Builder mBuilder;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static final String API_BASE_URL = "http://caratos.herokuapp.com/api/";


    public static RetrofitHelper getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final RetrofitHelper INSTANCE = new RetrofitHelper();
    }

    public RetrofitHelper() {
        mBuilder = new Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(GsonConverterFactory.create());
    }

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = mBuilder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }

}