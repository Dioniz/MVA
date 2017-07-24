package com.diodev.mva.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class User {
    @SerializedName("address")
    @Expose
    private String mAddress;
    @SerializedName("phone")
    @Expose
    private Integer mPhone;
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("birthdate")
    @Expose
    private String mBirthdate;
    @SerializedName("surname")
    @Expose
    private String mSurname;
    @SerializedName("photo")
    @Expose
    private String mPhoto;
    @SerializedName("username")
    @Expose
    private String mUsername;
    @SerializedName("email")
    @Expose
    private String mEmail;
    @SerializedName("emailVerified")
    @Expose
    private Boolean mEmailVerified;
    @SerializedName("status")
    @Expose
    private String mStatus;
    @SerializedName("id")
    @Expose
    private String mId;

    public User() {}
    public User(String id) {
        mId = id;
    }

    // getters & setters
    public String getAddress() {
        return mAddress;
    }
    public void setAddress(String address) {
        mAddress = address;
    }
    public Integer getPhone() {
        return mPhone;
    }
    public void setPhone(Integer phone) {
        mPhone = phone;
    }
    public String getName() {
        return mName;
    }
    public void setName(String name) {
        mName = name;
    }
    public String getBirthdate() {
        return mBirthdate;
    }
    public void setBirthdate(String birthdate) {
        mBirthdate = birthdate;
    }
    public String getSurname() {
        return mSurname;
    }
    public void setSurname(String surname) {
        mSurname = surname;
    }
    public String getPhoto() {
        return mPhoto;
    }
    public void setPhoto(String photo) {
        mPhoto = photo;
    }
    public String getUsername() {
        return mUsername;
    }
    public void setUsername(String username) {
        mUsername = username;
    }
    public String getEmail() {
        return mEmail;
    }
    public void setEmail(String email) {
        mEmail = email;
    }
    public Boolean getEmailVerified() {
        return mEmailVerified;
    }
    public void setEmailVerified(Boolean emailVerified) {
        mEmailVerified = emailVerified;
    }
    public String getStatus() {
        return mStatus;
    }
    public void setStatus(String status) {
        mStatus = status;
    }
    public String getId() {
        return mId;
    }
    public void setId(String id) {
        mId = id;
    }
}

