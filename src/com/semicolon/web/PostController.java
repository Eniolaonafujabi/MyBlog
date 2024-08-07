package com.semicolon.web;

import com.semicolon.data.models.Post;
import com.semicolon.dtos.CreatePostRequest;
import com.semicolon.services.PostService;
import com.semicolon.services.PostServiceImpli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;


@RestController
public class PostController {
    @Autowired
    private  PostService postService;
    @PostMapping("/try1")
    public String createPost(@RequestBody CreatePostRequest request) {
        Post createdPost;
        try{
            createdPost = postService.addPost(request.getTitle(),request.getContent());
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
       return String.format("""
               Title: %s
               Content: %s
               Post id: %d
               DateCreated: %s
               UpdatedCreated: %s
               
               """,createdPost.getTitle(),createdPost.getContent(),createdPost.getId(),createdPost.getCreatedTime(),createdPost.getUpdatedTime());
    }

    @GetMapping("/try2{id}")
    public String getPost(@PathVariable("id") int id) {
        Post post= postService.findPostById(id);
        return String.format("""
                Title: %s
                Content: %s
                Post id: %d
                DateCreated: %s
                UpdatedCreated: %s
         
                """, post.getTitle(), post.getContent(), post.getId(), post.getCreatedTime(), post.getUpdatedTime());
    }
}

