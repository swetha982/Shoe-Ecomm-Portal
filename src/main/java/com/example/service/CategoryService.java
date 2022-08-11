package com.example.service;

import com.example.bean.Category;

import java.util.List;

public interface CategoryService {

    public String saveCategory(String cname);

    public List<Category> showCategory();

    public Category getCat(String name);
    public  int showId(String name);
}
