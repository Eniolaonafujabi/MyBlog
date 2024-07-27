package data.repository;

import com.semicolon.data.models.Comment;
import com.semicolon.data.models.Post;
import com.semicolon.data.repository.CommentRepository;
import com.semicolon.data.repository.CommentRepositoryimpli;
import com.semicolon.data.repository.PostRepositoryimpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommentRepositoryimpliTest {

    private CommentRepository repository;
    private Post post = new Post();
    private PostRepositoryimpl repo = new PostRepositoryimpl();

    @BeforeEach
    public void setUp() {
        repository = new CommentRepositoryimpli();
        repo.save(post);
    }

    @Test
    public void checkIfListIsEmpty(){
        assertTrue(repository.isEmpty());
    }

        @Test
    public void testThatMyRepositoryHasIncreasedByOne() {
        Comment comment = new Comment();
        repository.save(comment);
        assertEquals(repository.count(),1);
    }

        @Test
    public void testThatMyRepositoryHasIncreasedByTwoAndRemoveLastElement() {
        Comment comment = new Comment();
        Comment comment1 = new Comment();
        repository.save(comment);
        repository.save(comment1);
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
        repository.save(comment);
        repository.save(comment1);
        repository.save(comment2);
        repository.save(comment3);
        assertEquals(repository.count(),4);
        repository.deleteByCommentId(comment1.getCommentId());
        assertEquals(repository.count(),3);
    }

        @Test
    public void testThatICanDeleteAllPost(){
        Comment comment = new Comment();
        Comment comment1 = new Comment();
        repository.save(comment);
        repository.save(comment1);
        assertEquals(repository.count(),2);
        repository.deleteAll();
        assertTrue(repository.isEmpty());
    }

    @Test
    public void testThatICanFindAllPost(){
        Comment comment = new Comment();
        Comment comment1 = new Comment();
        repository.save(comment);
        repository.save(comment1);
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
        repository.save(comment);
        repository.save(comment1);
        repository.deleteByPostId(comment.getUserId());
        assertEquals(repository.count(),1);
    }
}