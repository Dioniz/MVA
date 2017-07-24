package com.diodev.mva;

import com.diodev.mva.entities.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface IAppUsers {
    @Headers("Content-Type: application/json; charset=utf-8")
    @POST("appusers/login")
    Call<LoginResponse> login(@Body String credential);
}