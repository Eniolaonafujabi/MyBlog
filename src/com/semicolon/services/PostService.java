package com.semicolon.services;

import com.semicolon.data.models.Post;

public interface PostService {

    Post addPost(String title, String content);

    Post findPostById(int id);
}
