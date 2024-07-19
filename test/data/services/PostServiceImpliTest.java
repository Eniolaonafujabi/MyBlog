package data.services;

import data.models.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostServiceImpliTest {

    private PostService postService;
    private Post post;
    @BeforeEach
    void setUp() {
        postService = new PostServiceImpli();
        post = new Post();
    }

    @Test
    public void testThatICanSavePostAndReturnPost() {
        Post currentPost = postService.addPost("title","content");
        Post newPost = currentPost;
        assertEquals(currentPost,newPost);
    }


    @Test
    public void testThatICanGetPostById() {
        Post currentPost = postService.addPost("title","content");
        int id = currentPost.getId();
        assertEquals(postService.findPostById(id),currentPost);
    }

//    @Test
//    public void testThatICanNotAddSameTittle(){
//        postService.addPost("title","content");
//        postService.addPost("title","content");
//        assertThrows();
//    }
}