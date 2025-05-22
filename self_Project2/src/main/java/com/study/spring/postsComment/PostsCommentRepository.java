package com.study.spring.postsComment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsCommentRepository extends JpaRepository<EPostsComment, Long> {

}
