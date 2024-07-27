package com.semicolon.data.repository;

import com.semicolon.data.models.Post;

import java.util.List;

public interface PostRepository {

    Post save(Post post);

    List<Post> findAll();

    Post findById(int id);

    void delete(int id);

    void deleteAll();

    long count();

    boolean isEmpty();
}
