package com.study.spring.posts;

import com.study.spring.posts.DPosts;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostsController {

    private final PostsService postsService;

    @PostMapping
    public Long createPost(@RequestBody DPosts.Request request) {
        return postsService.createPost(request);
    }

    @GetMapping("/{id}")
    public DPosts.Response getPost(@PathVariable Long id) {
        return postsService.getPost(id);
    }
    
//    //list all posts with comments
//    @GetMapping("/with-comments")
//    public List<DPosts.Response> getAllPostsWithComments() {
//        return postsService.getAllPostsWithComments();
//    }
    
    @GetMapping
    public Page<DPosts.Response> getAllPosts(@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return postsService.getAllPosts(pageable);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody DPosts.Request request) {
        postsService.updatePost(id, request);
    }
    
    @GetMapping("/top10")
    public List<DPosts.Response> getTop10Posts(){
    	return postsService.getTop10PostsByLikes();
    }
    
    @PostMapping("/{postId}/like")
    public void likePost(@PathVariable Long postId, @RequestParam Long userId) {
    	postsService.likePost(userId, postId);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postsService.deletePost(id);
    }
}

