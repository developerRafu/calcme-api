package com.br.calcme.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.br.calcme.models.User;

public interface UserRepository extends MongoRepository<User, String>{

}
