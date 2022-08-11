package com.example.service;

import com.example.bean.Product;
import com.example.bean.User;

import java.util.List;


public interface UserService {

    public String saveSignUpInfo(User u);

    public boolean checkUser(String mail, String pwd);


}
