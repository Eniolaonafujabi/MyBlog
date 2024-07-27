////import com.semicolon.web.PostController;
////import java.util.Scanner;
////import static java.lang.Integer.parseInt;
////
//public class Main222 {
////
////   static private PostController postController = new PostController();
////    static private  Scanner scanner = new Scanner(System.in);
////
////    private static String input(String prompt) {
////        System.out.println(prompt);
////        return scanner.nextLine();
////    }
////
////    public static void main(String... args) {
////        mainMain();
////    }
////
////    private static void mainMain(){
////        String frontDisplay = """
////             Press one of this option
////               1) Create a new post
////               2) Display a post
////             """;
////        char userInput = input(frontDisplay).charAt(0);
////        switch (userInput) {
////            case '1':   createPost();
////            case '2':   displayPost();
////            default:    mainMain();
////        }
////    }
//
//    private static void displayPost() {
//        int userInputForPost = parseInt(input("Enter post id"));
//        postController.getPost(userInputForPost);
//        mainMain();
//    }
//
//    private static void createPost() {
//        String userInputForTitle = input("Enter title: ");
//        String userInputForContent = input("Enter content: ");
//        prompt(postController.createPost(userInputForTitle, userInputForContent));
//        mainMain();
//    }
//
//    private static void prompt(String post) {
//        System.out.println(post);
//    }
//
//}
//
