package com.tiagopereira.workshopmongo.service;

import com.tiagopereira.workshopmongo.entity.User;
import com.tiagopereira.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSercice {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
