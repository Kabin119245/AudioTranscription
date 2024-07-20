package com.transcibe.audio.repositories;

import com.transcibe.audio.models.Audio;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AudioRepository extends MongoRepository<Audio,String> {
}
