package data.services;

import data.models.Post;
import data.repository.PostRepositoryimpl;

import java.util.ArrayList;
import java.util.List;

public class PostServiceImpli implements PostService {

    private PostRepositoryimpl repo = new PostRepositoryimpl();

    @Override
    public Post addPost(String title, String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        boolean doesTitleExit = titleExitFor(title);
        if(doesTitleExit){
            throw  new IllegalArgumentException("title already exit");
        }
        repo.save(post);
        return post;
    }

    private boolean titleExitFor(String title) {
        List<Post> post = repo.findAll();
        for(Post post1 : post){
            if(post1.getTitle().equals(title))return true;
        }
        return false;
    }

    @Override
    public Post findPostById(int id) {
        for(Post post : repo.findAll()) if(post.getId() == id) return post;
        return null;
    }

    @Override
    public String toString() {
        return "PostServiceImpli{" +
                "repo=" + repo +
                '}';
    }
}
