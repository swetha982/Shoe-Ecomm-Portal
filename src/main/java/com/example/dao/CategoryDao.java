package com.example.dao;

import com.example.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {

    public boolean existsByName(String cname);

    public Category findByName(String name);

    @Query("select c.catId from Category c where c.name= ?1")
    public int getCatId(String name);
}
