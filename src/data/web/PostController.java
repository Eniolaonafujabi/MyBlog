package data.web;

import data.models.Post;
import data.services.PostService;
import data.services.PostServiceImpli;

public class PostController {
    private final PostService postService = new PostServiceImpli();

    public String createPost(String title, String content) {
        Post createdPost;
        try{
            createdPost = postService.addPost(title,content);
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

    public String getPost(int id) {
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

