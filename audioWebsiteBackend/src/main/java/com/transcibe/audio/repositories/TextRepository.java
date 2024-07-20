package com.transcibe.audio.repositories;

import com.transcibe.audio.models.Text;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TextRepository extends MongoRepository<Text, String> {
}
