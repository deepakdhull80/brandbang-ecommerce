package com.store.webstore.service;

import com.store.webstore.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();

    User getUserById(int id);

    User getUserByUserName(String userName);

    User addUser(User user);

    User updateUser(User user);

    User deleteUserByUserName(String userName);

}
