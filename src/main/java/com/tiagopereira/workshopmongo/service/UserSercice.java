package com.tiagopereira.workshopmongo.service;

import com.tiagopereira.workshopmongo.entity.User;
import com.tiagopereira.workshopmongo.repository.UserRepository;
import com.tiagopereira.workshopmongo.service.exception.ObjectNotFoundExcepion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSercice {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return  user.orElseThrow(() -> new ObjectNotFoundExcepion("Objeto não encontrado"));
    }
}
