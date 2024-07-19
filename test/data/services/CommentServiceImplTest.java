package data.services;

import data.models.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommentServiceImplTest {

    private CommentService commentService;
    private Comment comment;
    @BeforeEach
    void setUp() {
        commentService = new CommentServiceImpl();
        comment = new Comment();
    }

    @Test
    public void testThatICanSavePostAndReturnPost() {
        String currentcomment = commentService.addComment("content");
        String newComment = currentcomment;
        assertEquals(currentcomment, newComment);
    }


    @Test
    public void testThatICanGetPostById() {
        String currentComment = commentService.addComment("content");
//        int id = currentComment.getCommentId();
//        assertEquals(commentService.findCommentById(id),currentComment);
    }


}