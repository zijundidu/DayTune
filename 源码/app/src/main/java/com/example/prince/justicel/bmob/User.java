package com.example.prince.justicel.bmob;

import cn.bmob.v3.BmobUser;

public class User extends BmobUser{
    private String username;
    private String password;


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
