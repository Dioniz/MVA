package com.diodev.mva.entities;


import com.google.gson.annotations.SerializedName;

public class Credential {
    @SerializedName("email")
    private String mEmail;
    @SerializedName("password")
    private String mPassword;

    public Credential() {}

    public Credential(String email, String password) {
        mEmail = email;
        mPassword = password;
    }

    public String getEmail() {
        return mEmail;
    }
    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }
    public String getPassword() {
        return mPassword;
    }
    public void setPassword(String password) {
        mPassword = password;
    }
}