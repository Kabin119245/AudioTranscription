package com.security.jwt.repository;

import com.security.jwt.model.UnbiasedText;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnbiasedTextRepository extends JpaRepository<UnbiasedText,Long> {
}
