package com.example.dao;

import com.example.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {

    @Query("select p from Product p")
    public List<Product> showAllProd();

    public Product findByProductId(int id);
}
