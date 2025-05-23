package com.study.spring.postsComment;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts/{postId}/comments")
@RequiredArgsConstructor
public class PostsCommentController {

    private final PostsCommentService postscommentService;

    @PostMapping
    public Long createComment(@PathVariable Long postId, @RequestBody DPostsComment.Request request) {
        return postscommentService.createComment(postId, request);
    }
    
    //view
    @GetMapping
    public List<DPostsComment.Response> getComments(@PathVariable Long postId) {
        return postscommentService.getCommentsByPost(postId);
    }
    

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        postscommentService.deleteComment(commentId);
    }
}