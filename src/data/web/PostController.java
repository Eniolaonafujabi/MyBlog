package data.web;

import data.models.Post;
import data.services.PostService;
import data.services.PostServiceImpli;

public class PostController {
    private PostService postService = new PostServiceImpli();

    public String createPost(String title, String content) {
        Post createdPost;
        try{
            createdPost = postService.addPost(title,content);
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
       return String.valueOf(createdPost);
    }

    public Post getPost(int id) {
        return postService.findPostById(id);
    }
}
