package com.store.webstore.controller;

import com.store.webstore.model.User;
import com.store.webstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    /*
    * get all users in DS
    * */
    @GetMapping(value = "/api")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(value="/api")
    public User addUser(@RequestBody User user){
        User resp = userService.addUser(user);
        return resp;
    }

    @PutMapping(value = "/api")
    public User updateUser(@RequestBody User user){
        User user1 = userService.updateUser(user);
        return user1;
    }

    @DeleteMapping(value="/api/{username}")
    public String userDelete(@PathVariable String username){
        try{

            userService.deleteUserByUserName(username);
        }catch(UsernameNotFoundException e){
            return e.getMessage();
        }
        return username+" is Deleted";
    }
}
