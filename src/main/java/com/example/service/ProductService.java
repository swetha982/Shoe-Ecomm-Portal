package com.example.service;

import com.example.bean.Product;

import java.util.List;

public interface ProductService {
    public String saveProduct(Product p, int id,String name);

    public List<Product> showProducts();

    public Product getProduct(int id);
}
