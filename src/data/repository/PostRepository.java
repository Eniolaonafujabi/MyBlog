package data.repository;

import data.models.Post;

import java.util.List;

public interface PostRepository {

    void save(Post post);

    List<Post> findAll();

    Post findById(int id);

    void delete(int id);

    void deleteAll();

    long count();

    boolean isEmpty();
}