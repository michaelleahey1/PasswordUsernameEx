package com.ust.util.passwordEx.PasswordEx.model;

public class RequiredInfo {
    private int uid;
    private String username;
    private String pword;

    //constructors


    public RequiredInfo() {
    }

    public RequiredInfo(int uid, String username, String pword) {
        this.uid = uid;
        this.username = username;
        this.pword = pword;
    }

    //getters/setters
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPword() {
        return pword;
    }
    public void setPword(String pword) {
        this.pword = pword;
    }


    @Override
    public String toString() {
        return "RequiredInfo{" +
                "id=" + uid +
                ", username='" + username + '\'' +
                ", password='" + pword + '\'' +
                '}';
    }
}
