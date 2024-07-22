package com.transcibe.audio.repositories;

import com.transcibe.audio.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepositroy extends MongoRepository<User, String> {

}
