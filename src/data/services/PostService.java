package data.services;

import data.models.Post;

public interface PostService {

    Post addPost(String title, String content);

    Post findPostById(int id);
}
