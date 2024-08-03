package com.security.jwt.repository;

import com.security.jwt.model.Text;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextRepository extends JpaRepository<Text, String> {}
