package com.study.spring.posts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<EPosts, Long> {
	
	List<EPosts> findTop10ByOrderByLikesDesc();
	List<EPosts> findAllByUserId(Long userId);

}
