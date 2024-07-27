package com.semicolon.services;

import com.semicolon.data.models.Comment;

public interface CommentService {

    String addComment(String content);

    Comment findCommentById(int id);
}
