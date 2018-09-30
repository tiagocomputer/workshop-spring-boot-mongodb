package com.tiagopereira.workshopmongo.controller;

import com.tiagopereira.workshopmongo.entity.User;
import com.tiagopereira.workshopmongo.service.UserSercice;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserSercice userSercice;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
         //ArrayList é uma implementação de List<>
        List<User> list = userSercice.findAll();
        return ResponseEntity.ok().body(list);
    }
}
