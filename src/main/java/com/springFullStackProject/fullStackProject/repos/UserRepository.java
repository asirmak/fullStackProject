package com.springFullStackProject.fullStackProject.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springFullStackProject.fullStackProject.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
