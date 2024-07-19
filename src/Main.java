import data.web.PostController;

import java.util.Scanner;

public class Main {

    private PostController postController = new PostController();
    private Scanner scanner = new Scanner(System.in);

    private String input(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public  void main(String[] args) {
        String forntDisplay = """
                Press one of this option
                1) Create a new post
                2) Display a post
               """;
        char userInput = input(forntDisplay).charAt(0);
        switch (userInput) {
            case '1':   createPost();
            case '2':   displayPost();
        }
    }

    private void displayPost() {
//        int userInputForPost = input("Enter post id");
    }

    private void createPost() {
        String userInputForTitle = input("Enter title: ");
        String userInputForContent = input("Enter content: ");
        prompt(postController.createPost(userInputForTitle, userInputForContent));
    }

    private void prompt(String post) {
        System.out.println(post);
    }

}
