package com.rafael.cursomc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rafael.cursomc.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
