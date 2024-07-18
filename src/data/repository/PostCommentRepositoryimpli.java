package data.repository;

import data.models.Comment;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PostCommentRepositoryimpli implements PostCommentRepository {
        private List<Comment> comments = new ArrayList<Comment>();


    @Override
    public void save(Comment comment,int postId) {
        int generatedNumber = generateUniqueId();
        comment.setCommentId(generatedNumber);
        comment.setUserId(postId);
        comments.add(comment);
    }

    private int generateUniqueId() {
        return ThreadLocalRandom.current().nextInt(7,15);
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
