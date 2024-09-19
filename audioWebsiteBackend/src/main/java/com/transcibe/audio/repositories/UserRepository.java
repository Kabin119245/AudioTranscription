package com.transcibe.audio.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.transcibe.audio.models.User;


@Repository
public interface UserRepository extends MongoRepository<User, String> {

  //  Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
