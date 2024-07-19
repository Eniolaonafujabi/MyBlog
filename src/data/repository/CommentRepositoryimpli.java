package data.repository;

import data.models.Comment;
import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryimpli implements CommentRepository {
        private List<Comment> comments = new ArrayList<Comment>();
        private int count;


    @Override
    public void save(Comment comment) {
        int generatedNumber = generateUniqueId();
        comment.setCommentId(generatedNumber);
        comments.add(comment);
    }

    private int generateUniqueId() {
        return ++count;
    }

    @Override
    public List<Comment> findAll() {
        return comments;
    }

    @Override
    public Comment findByCommentId(int id) {
        for (Comment comment : comments) if (comment.getCommentId() == id) return comment;
        return null;
    }


    @Override
    public Comment findByPostId(int id) {
        for (Comment comment : comments) if (comment.getUserId() == id) return comment;
        return null;
    }

    @Override
    public void deleteByCommentId(int id) {
        comments.remove(findByCommentId(id));
    }

    @Override
    public void deleteByPostId(int id) {
        comments.remove(findByPostId(id));
    }

    @Override
    public void deleteAll() {
        comments.clear();
    }

    @Override
    public long count() {
        return comments.size();
    }

//    @Override
//    public boolean equals(Object obj) {
//        Comment comment = (Comment) obj;
//        for(Comment comment1 : comments){
//            if(comment1.equals(comment))return true;
//        }
//        return false;
//    }

    @Override
    public boolean isEmpty() {
        return comments.isEmpty();
    }
}
