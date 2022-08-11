package com.example.dao;

import com.example.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    public boolean existsByEmail(String mailId);

    public boolean existsByEmailAndPwd(String mail, String pwd) throws Exception;

    @Query("select count(1) from User u where u.email=?1 and u.pwd=?2")
    public int checkLogin(String mail, String pwd);
}
