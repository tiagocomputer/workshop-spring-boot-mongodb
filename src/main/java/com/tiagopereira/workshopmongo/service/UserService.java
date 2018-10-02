package com.tiagopereira.workshopmongo.service;

import com.tiagopereira.workshopmongo.dto.UserDTO;
import com.tiagopereira.workshopmongo.entity.User;
import com.tiagopereira.workshopmongo.repository.UserRepository;
import com.tiagopereira.workshopmongo.service.exception.ObjectNotFoundExcepion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return  user.orElseThrow(() -> new ObjectNotFoundExcepion("Objeto não encontrado"));
    }

    public User insert(User user){
        return userRepository.insert(user);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User user){
        User newUser = findById(user.getId());
        updateData(newUser, user);
        return  userRepository.save(newUser);
    }

    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
