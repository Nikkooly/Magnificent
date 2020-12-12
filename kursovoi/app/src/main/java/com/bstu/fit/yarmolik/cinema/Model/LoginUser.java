package com.bstu.fit.yarmolik.cinema.Model;

public class LoginUser {
    private String Login;
    private String Password;
    public LoginUser(String login, String password){
        Login=login;
        Password=password;
    }
    public String getLogin() {
        return Login;
    }
    public void setLogin(String login) {
        Login = login;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
}
