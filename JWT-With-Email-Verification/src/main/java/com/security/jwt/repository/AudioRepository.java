package com.security.jwt.repository;

import com.security.jwt.model.Audio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioRepository extends JpaRepository<Audio, String> {
}
