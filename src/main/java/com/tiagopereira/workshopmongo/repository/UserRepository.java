package com.tiagopereira.workshopmongo.repository;

import com.tiagopereira.workshopmongo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
