package com.example.bean;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(name = "file_name")
    private String name;
    private  int quantity;



    @Column(name = "file_path")
    private String filePath;

    private int price;



    @ManyToOne
    @JoinColumn(name = "catId",nullable = false)
    private Category category;

    public Product(String fileName,int quantity, String path,int price) {
        name=fileName;
        this.quantity=quantity;
        filePath=path;
        this.price=price;
    }
    public Product(String fileName,int quantity, String path,int price,Category c) {
        name=fileName;
        this.quantity=quantity;
        filePath=path;
        this.price = price;
        category=c;
    }
    public Product(){}



    public int getPrice() {
        return price;
    }

    public int getProductId() {
        return productId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getName() {
        return name;
    }


}
