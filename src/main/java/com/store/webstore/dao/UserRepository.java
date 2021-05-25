package com.store.webstore.dao;


import com.store.webstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("select u from User u where u.userName= ?1")
    User findByUserName(String userName);


}
