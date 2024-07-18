package data.repository;

import data.models.Comment;
import data.models.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostCommentRepositoryimpliTest {

    private PostCommentRepository repository;
    private Post post = new Post();
    private PostRepositoryimpl repo = new PostRepositoryimpl();

    @BeforeEach
    public void setUp() {
        repository = new PostCommentRepositoryimpli();
        repo.save(post);
    }

    @Test
    public void checkIfListIsEmpty(){
        assertTrue(repository.isEmpty());
    }

        @Test
    public void testThatMyRepositoryHasIncreasedByOne() {
        Comment comment = new Comment();
        repository.save(comment,post.getId());
        assertEquals(repository.count(),1);
    }

        @Test
    public void testThatMyRepositoryHasIncreasedByTwoAndRemoveLastElement() {
        Comment comment = new Comment();
        Comment comment1 = new Comment();
        repository.save(comment,post.getId());
        repository.save(comment1,post.getId());
        assertEquals(repository.count(),2);
        repository.deleteByCommentId(comment1.getCommentId());
        assertEquals(repository.count(),1);
    }

        @Test
    public void testThatMyRepositoryHasIncreasedByFourAndRemoveMiddleElement() {
        Comment comment = new Comment();
        Comment comment1 = new Comment();
        Comment comment2 = new Comment();
        Comment comment3 = new Comment();
        repository.save(comment,post.getId());
        repository.save(comment1,post.getId());
        repository.save(comment2,post.getId());
        repository.save(comment3,post.getId());
        assertEquals(repository.count(),4);
        repository.deleteByCommentId(comment1.getCommentId());
        assertEquals(repository.count(),3);
    }

        @Test
    public void testThatICanDeleteAllPost(){
        Comment comment = new Comment();
        Comment comment1 = new Comment();
        repository.save(comment,post.getId());
        repository.save(comment1,post.getId());
        assertEquals(repository.count(),2);
        repository.deleteAll();
        assertTrue(repository.isEmpty());
    }

    @Test
    public void testThatICanFindAllPost(){
        Comment comment = new Comment();
        Comment comment1 = new Comment();
        repository.save(comment,post.getId());
        repository.save(comment1,post.getId());
        assertEquals(repository.findAll().size(),2);
    }

//    @Test
//    public void testThatICanFindCommentByUserId(){
//        Comment comment = new Comment();
//        Comment comment1 = new Comment();
//        repository.save(comment,post.getId());
//        repository.save(comment1,post.getId());
//        repository.findByPostId(comment.getPostId());
//        assertEquals(repository.findByUserId(comment1.getUserId()),comment1);
//    }

        @Test
    public void testThatICanFindCommentByUserIdAndDelete(){
        Comment comment = new Comment();
        Comment comment1 = new Comment();
        repository.save(comment,post.getId());
        repository.save(comment1,post.getId());
        repository.deleteByPostId(comment.getUserId());
        assertEquals(repository.count(),1);
    }
}