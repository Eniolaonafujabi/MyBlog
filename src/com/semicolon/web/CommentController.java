package com.semicolon.web;


import com.semicolon.services.CommentServiceImpl;
import com.semicolon.data.models.Comment;
import com.semicolon.services.CommentService;

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
