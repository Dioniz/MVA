package com.diodev.mva.entities;

public class Session {
    private static Session mSession;
    private String mSessionToken;
    private User mUser;

    private Session() {
        mSessionToken = "";
    }

    public static Session getInstance() {
        if (mSession == null) {
            mSession = new Session();
        }
        return mSession;
    }

    // getters & setters
    public String getSessionToken() {
        return mSessionToken;
    }
    public void setSessionToken(String mSessionToken) {
        this.mSessionToken = mSessionToken;
    }
    public User getUser() {
        return mUser;
    }
    public void setUser(User mUser) {
        this.mUser = mUser;
    }
}