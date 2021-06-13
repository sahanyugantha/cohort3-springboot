package com.sahan.appone.service;

import com.sahan.appone.dao.UserRepository;
import com.sahan.appone.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Retrieving all the users
     * @return List of users
     */
    public List<User> getUsers(){
       return userRepository.findAll();
    }

}
