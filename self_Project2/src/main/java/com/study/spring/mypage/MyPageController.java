package com.study.spring.mypage;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.posts.DPosts;
import com.study.spring.postsComment.DPostsComment;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/mypage")
@RequiredArgsConstructor
public class MyPageController {

    private final MyPageService myPageService;

    @GetMapping("/{userId}/posts")
    public List<DPosts.Response> getMyPosts(@PathVariable Long userId) {
        return myPageService.getMyPosts(userId);
    }

    @GetMapping("/{userId}/comments")
    public List<DPostsComment.Response> getMyComments(@PathVariable Long userId) {
        return myPageService.getMyComments(userId);
    }

    @GetMapping("/{userId}/likes")
    public List<DPosts.Response> getMyLikes(@PathVariable Long userId) {
        return myPageService.getMyLikes(userId);
    }
}
