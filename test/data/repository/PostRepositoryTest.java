package data.repository;

import com.semicolon.data.models.Post;
import com.semicolon.data.repository.PostRepository;
import com.semicolon.data.repository.PostRepositoryimpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryTest {

    private PostRepository repository;

    @BeforeEach
    void setUp() {
        repository = new PostRepositoryimpl();
    }

    @Test
    public void testThatMyRepositoryIsEmpty() {
        assertTrue(repository.isEmpty());
    }

    @Test
    public void testThatMyRepositoryHasIncreasedByOne() {
        Post post = new Post();
        repository.save(post);
        assertEquals(repository.count(),1);
    }

    @Test
    public void testThatMyRepositoryHasIncreasedByTwoAndRemoveLastElement() {
        Post post = new Post();
        Post post2 = new Post();
        repository.save(post);
        repository.save(post2);
        assertEquals(repository.count(),2);
        repository.delete(post2.getId());
        assertEquals(repository.count(),1);
    }

    @Test
    public void testThatMyRepositoryHasIncreasedByFourAndRemoveMiddleElement() {
        Post post = new Post();
        Post post2 = new Post();
        Post post3 = new Post();
        Post post4 = new Post();
        repository.save(post);
        repository.save(post2);
        repository.save(post3);
        repository.save(post4);
        assertEquals(repository.count(),4);
        repository.delete(post2.getId());
        assertEquals(repository.count(),3);
    }

    @Test
    public void testThatICanDeleteAllPost(){
        Post post = new Post();
        Post post2 = new Post();
        repository.save(post);
        repository.save(post2);
        assertEquals(repository.count(),2);
        repository.deleteAll();
        assertTrue(repository.isEmpty());
    }

    @Test
    public void testThatICanFindAllPost(){
        Post post = new Post();
        Post post2 = new Post();
        repository.save(post);
        repository.save(post2);
        assertEquals(repository.findAll().size(),2);
    }
}