package com.example.service;

import com.example.bean.Cart;

import java.util.List;

public interface CartService {

    public List<Cart> getAllCartItem();
    public String saveCartItem(Cart c);

}
