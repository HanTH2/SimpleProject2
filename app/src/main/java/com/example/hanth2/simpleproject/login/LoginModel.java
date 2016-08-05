package com.example.hanth2.simpleproject.login;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public class LoginModel {
    public String username;
    public String password;
    public String token;
    public int errorcode;

    public LoginModel(LoginDto dto) {
        username = dto.username;
        password = dto.password;
        token = dto.token;
        errorcode = dto.errorcode;
        }
}
