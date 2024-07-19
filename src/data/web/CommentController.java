package data.web;


import data.models.Comment;
import data.services.CommentService;
import data.services.CommentServiceImpl;

public class CommentController {
        private CommentService commentService = new CommentServiceImpl();

    public String createComment(String content) {
        String createdService;
        return commentService.addComment(content);

    }

    public Comment getPost(int id) {
        return commentService.findCommentById(id);
    }
}
