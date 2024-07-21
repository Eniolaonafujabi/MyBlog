package data.services;

import data.models.Post;
import data.repository.PostRepository;
import data.repository.PostRepositoryimpl;
import java.util.List;

public class PostServiceImpli implements PostService {

    private PostRepository repo = new PostRepositoryimpl();

    @Override
    public Post addPost(String title, String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        boolean doesTitleExit = titleExitFor(title);
        throwexpection(doesTitleExit);
        repo.save(post);
        return post;
    }

    private void throwexpection(boolean doesTitleExit) {
        if(doesTitleExit){
            throw  new IllegalArgumentException("title already exit");
        }
    }

    private boolean titleExitFor(String title) {
        List<Post> posts = repo.findAll();
        for(Post post : posts){
            if(post.getTitle().equals(title))return true;
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
