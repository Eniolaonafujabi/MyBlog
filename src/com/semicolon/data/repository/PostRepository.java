package com.semicolon.data.repository;

import com.semicolon.data.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository  extends MongoRepository<Post,String> {

//    Post save(Post post);
//
//    List<Post> findAll();
//
//    Post findById(int id);
//
//    void delete(int id);
//
//    void deleteAll();
//
//    long count();
//
//    boolean isEmpty();
}
