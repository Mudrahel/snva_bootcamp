package ryhor.mudrahel.snva.bootcamp.quizplatform;

import ryhor.mudrahel.snva.bootcamp.quizplatform.utility.ConsoleReader;
import ryhor.mudrahel.snva.bootcamp.quizplatform.utility.ConsoleReaderImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class QuizPlatform {

    public static void run() {

        ConsoleReader console = new ConsoleReaderImpl();
        UserBank userBank = new UserBankImpl();
        int menuOption;

        while (true) {
            System.out.println("Welcome to Quiz Platform. What would you like to do?");
            System.out.println("Option 1. Register");
            System.out.println("Option 2. Take a quiz");

            menuOption = console.readInt();
            if (menuOption == 1) {
                System.out.println("register scenario");
                System.out.println("Please enter username");
                String username = console.readString();
                userBank.store(new User(username));
            } else if (menuOption == 2) {
                break;
            } else {
                System.out.println("incorrect option selected. try again");
            }
        }

        printUsers(userBank.getUsers());

        if (menuOption == 2) {
            System.out.println("Quiz scenario");
            while (true) {
                System.out.println("Please enter registered username:");
                String username = console.readString();
                if (userBank.getUsers().contains(new User(username))) {
                    System.out.println("Welcome " + username);
                    break;
                } else {
                    System.out.println("user not found. try again");
                }
            }
        }

        Map<String, List<String>> questions = QuestionsFactory.produce();

        System.out.println("Quiz has began.");
        for (Map.Entry<String, List<String>> entry : questions.entrySet()) {
            String answer = "";
            while (true) {
                printQuestion(entry.getKey(), entry.getValue());
                System.out.print("Your answer:");
                answer = console.readString();
                if (AnswerValidator.isValid(answer)) {
                    break;
                } else {
                    System.out.println("Incorrect answer. Please enter only available options, like 'ab' or 'bc'");
                }
            }
        }

//        printQuestions(questions);

    }

    private static void printQuestion(String question, List<String> answers) {
        System.out.println(question);
        for (String option : answers) {
            System.out.println("  " + option);
        }
        System.out.println();
    }

    private static void printQuestions(Map<String, List<String>> questions) {
        // Print the questions and answers
        for (Map.Entry<String, List<String>> entry : questions.entrySet()) {
            System.out.println(entry.getKey());
            for (String option : entry.getValue()) {
                System.out.println("  " + option);
            }
            System.out.println();
        }
    }

    private static void printUsers(Set<User> users) {
        System.out.println("Registered users");
        for (User user : users) {
            System.out.println("User:" + user.getUsername());
        }
    }
}
