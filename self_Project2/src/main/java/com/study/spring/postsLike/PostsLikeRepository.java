package com.study.spring.postsLike;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.spring.posts.DPosts.Response;

public interface PostsLikeRepository extends JpaRepository<EPostsLike, Long> {

	boolean existsByUserAndPostId(Long userId, Long postId);
	List<EPostsLike> findAllByUserId(Long userId);

}
