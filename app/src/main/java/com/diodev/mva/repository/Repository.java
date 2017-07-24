package com.diodev.mva.repository;


import com.diodev.mva.IAppUsers;
import com.diodev.mva.RetrofitHelper;
import com.diodev.mva.activity.IMainActivity;
import com.diodev.mva.entities.Credential;
import com.diodev.mva.entities.LoginResponse;
import com.diodev.mva.entities.Session;
import com.diodev.mva.entities.User;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository implements IRepository {

    private IMainActivity mIMainActivity;
    private RetrofitHelper mRetrofitHelper;
    private IAppUsers mIAppUsers;
    private Session mSession;

    public Repository(IMainActivity iMainActivity) {
        mIMainActivity = iMainActivity;
        mRetrofitHelper = RetrofitHelper.getInstance();
        mIAppUsers = mRetrofitHelper.createService(IAppUsers.class);
        mSession = Session.getInstance();
    }

    @Override
    public void login(String email, String password) {
        doLogin(new Credential(email, password));
    }

    public void doLogin(Credential credential) {
        Gson gson = new Gson();
        Call<LoginResponse> callVersion = mIAppUsers.login(gson.toJson(credential));
        callVersion.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    mSession.setSessionToken(loginResponse.getToken());
                    mSession.setUser(new User(loginResponse.getUserId()));
                    loginSuccess();
                } else {
                    loginError("Response unsuccessful");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                loginError("Response fail");
            }
        });
    }

    private void loginSuccess() {
        if (mIMainActivity != null){
            mIMainActivity.onLoginSuccess();
        }
    }

    private void loginError(String error) {
        if (mIMainActivity != null) {
            mIMainActivity.onLoginError(error);
        }
    }
}