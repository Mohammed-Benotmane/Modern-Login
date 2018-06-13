package com.example.mohamed.loginui;

/**
 * Created by mohamed on 13/06/18.
 */

public class User {
    private int id;
    private String username,password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}');
        return sb.toString();
    }
}


