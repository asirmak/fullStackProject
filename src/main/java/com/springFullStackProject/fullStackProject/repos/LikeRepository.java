package com.springFullStackProject.fullStackProject.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springFullStackProject.fullStackProject.entities.Like;

public interface LikeRepository extends JpaRepository<Like, Long>{

	List<Like> findByPostIdAndUserId(Optional<Long> postId, Optional<Long> userId);

	List<Like> findByPostId(Optional<Long> postId);

	List<Like> findByUserId(Optional<Long> userId);

}
