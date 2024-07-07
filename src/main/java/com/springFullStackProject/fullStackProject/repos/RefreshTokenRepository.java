package com.springFullStackProject.fullStackProject.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springFullStackProject.fullStackProject.entities.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{

	RefreshToken findByUserId(Long userId);

}
