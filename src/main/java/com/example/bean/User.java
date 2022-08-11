package com.example.bean;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String gender;
    private String email;
    private String pwd;

    public User(String name,int age, String gender, String email, String pwd){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.email=email;
        this.pwd=pwd;
    }

    public User(String email, String pwd){
        this.email=email;
        this.pwd=pwd;
    }

    public User(){}


}
