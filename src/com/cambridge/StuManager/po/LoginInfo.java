package com.cambridge.StuManager.po;

public class LoginInfo {
    private int id;
    private String name;
    private String identity;
    private String account;
    private String password;

    public LoginInfo(String name,String identity, String account, String password) {
        this.name=name;
        this.identity = identity;
        this.account = account;
        this.password = password;
    }

    public LoginInfo(String identity, String account, String password) {
        this.identity = identity;
        this.account = account;
        this.password = password;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
