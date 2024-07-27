package com.semicolon.services;

import com.semicolon.data.models.Comment;
import com.semicolon.data.repository.CommentRepository;
import com.semicolon.data.repository.CommentRepositoryimpli;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{

        private CommentRepository repo = new CommentRepositoryimpli();

    @Override
    public String addComment(String content) {
        Comment comment = new Comment();
        comment.setCommentText(content);
        repo.save(comment);
        return String.format("""
                Comment: %s
                Date: %s
                comment id: %s
                """, comment.getCommentText(), comment.getCommentCreatedAt(),comment.getCommentId());
    }


    @Override
    public Comment findCommentById(int id) {
        for(Comment comment : repo.findAll()) if(comment.getCommentId() == id) return comment;
        return null;
    }

}
