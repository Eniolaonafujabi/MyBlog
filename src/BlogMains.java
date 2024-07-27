import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogMains {
    static PostController controller;
//    private static  PostController postController = new PostController();

    public static void main(String[] args) {
        SpringApplication.run(BlogMains.class, args);
    }

record PostController(String createPost, String content){}

}
