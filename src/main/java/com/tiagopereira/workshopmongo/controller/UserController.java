package com.tiagopereira.workshopmongo.controller;

import com.tiagopereira.workshopmongo.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1", "Maria Silva", "maria@gmail.com");
        User alex = new User("2", "Alex Alves", "alex@gmail.com");
        //ArrayList é uma implementação de List<>
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex ));
        return ResponseEntity.ok().body(list);
    }
}
