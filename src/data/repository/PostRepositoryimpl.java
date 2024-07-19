package data.repository;
import data.models.Post;
import java.util.ArrayList;
import java.util.List;

public class PostRepositoryimpl implements PostRepository {

    private List<Post> posts = new ArrayList<Post>();
    private int count;

    @Override
    public Post findById(int id) {
        for (Post post : posts) if (post.getId() == id) return post;
        return null;
    }

    @Override
    public void delete(int id) {
        posts.remove(findById(id));
    }

    @Override
    public void deleteAll() {
        posts.clear();
    }

    @Override
    public long count() {
        return posts.size();
    }

    @Override
    public boolean isEmpty() {
        return (posts.isEmpty());
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    private boolean doesPostExit(Post post) {
        for (Post post1 : posts) if (post.getId() == post1.getId()) return true;
        return false;
    }

    private Integer getIndexOfThePost(Post post) {
        Integer result = null;
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId() == post.getId()) {
                result = i;
                break;
            }
        }
        return result;
    }

    private int generateUniqueId() {
        return ++count;
    }

    @Override
    public Post save(Post post) {
        boolean check = doesPostExit(post);
        if (check) {
            int index = getIndexOfThePost(post);
            posts.add(index, post);
        } else {
            int generatedNumber = generateUniqueId();
            post.setId(generatedNumber);
            posts.add(post);
        }
        return post;
    }

}



