package com.semicolon.data.repository;

import com.semicolon.data.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment,String> {

//    Comment save(Comment comment);
//
//    List<Comment> findAll();
//
//    Comment findByCommentId(int id);
//
//
//    Comment findByPostId(int id);
//
//    void deleteByCommentId(int id);
//
//    void deleteByPostId(int id);
//
//    void deleteAll();
//
//    long count();
//
//    boolean isEmpty();

}
