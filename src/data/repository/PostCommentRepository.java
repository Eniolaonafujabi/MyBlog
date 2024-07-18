package data.repository;

import data.models.Comment;

import java.util.List;

public interface PostCommentRepository {

    void save(Comment comment,int postId);

    List<Comment> findAll();

    Comment findByCommentId(int id);


    Comment findByPostId(int id);

    void deleteByCommentId(int id);

    void deleteByPostId(int id);

    void deleteAll();

    long count();

    boolean isEmpty();

}
