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

//    @GetMapping
//    public List<DPosts.Response> getAllPosts() {
//        return postsService.getAllPosts();
//    }
    @GetMapping
    public Page<DPosts.Response> getAllPosts(@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return postsService.getAllPosts(pageable);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody DPosts.Request request) {
        postsService.updatePost(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postsService.deletePost(id);
    }
}

