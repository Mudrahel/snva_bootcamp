package ryhor.mudrahel.snva.bootcamp.quizplatform;

import ryhor.mudrahel.snva.bootcamp.quizplatform.answers.AnswerExtractor;
import ryhor.mudrahel.snva.bootcamp.quizplatform.answers.AnswerLoader;
import ryhor.mudrahel.snva.bootcamp.quizplatform.answers.AnswerValidator;
import ryhor.mudrahel.snva.bootcamp.quizplatform.questions.OptionLoader;
import ryhor.mudrahel.snva.bootcamp.quizplatform.questions.Question;
import ryhor.mudrahel.snva.bootcamp.quizplatform.questions.QuestionLoader;
import ryhor.mudrahel.snva.bootcamp.quizplatform.users.User;
import ryhor.mudrahel.snva.bootcamp.quizplatform.users.UserAuthenticator;
import ryhor.mudrahel.snva.bootcamp.quizplatform.users.UserBank;
import ryhor.mudrahel.snva.bootcamp.quizplatform.users.UserBankImpl;
import ryhor.mudrahel.snva.bootcamp.quizplatform.utility.ConsoleReader;
import ryhor.mudrahel.snva.bootcamp.quizplatform.utility.ConsoleReaderImpl;

import java.sql.SQLOutput;
import java.util.*;

public class QuizPlatform {

    private ConsoleReader console;
    private UserBank userBank;

    private static int userScore = 0;
    private static int totalScore = 0;

    public QuizPlatform() {
        console = new ConsoleReaderImpl();
        userBank = new UserBankImpl();
    }

    public void run() {
        int menuOption;

        while (true) {
            System.out.println("Welcome to Quiz Platform. What would you like to do?");
            System.out.println("Option 1. Register");
            System.out.println("Option 2. Take a quiz");

            menuOption = console.readInt();
            if (menuOption == 1) {
                registerUser();
            } else if (menuOption == 2) {
                break;
            } else {
                System.out.println("incorrect option selected. try again");
            }
        }

        printUsers(userBank.getUsers());

        if (menuOption == 2) {
            login();
        }

        String topic = selectQuiz();
        System.out.println(topic + " quiz selected. Loading...");

        System.out.println("Quiz has began.");
        List<Question> questions = QuestionLoader.load(topic);
        OptionLoader.load(questions);
        AnswerLoader.load(questions);

        for (Question q : questions) {
            processQuestion(q);
        }

        System.out.println("Your score is " + userScore + " out of " + totalScore);

    }

    private void processQuestion(Question q) {
        System.out.println(q.getQuestionStr());
        displayOptions(q.getOptions());
        String answer = console.readString();
        if (!AnswerValidator.isValid(answer)) {
            System.out.println("Incorrect answer. Please enter only available options, like '1' or '23'");
        }
        List<String> userAnswers = AnswerExtractor.extract(q.getOptions(), answer);
        Collections.sort(userAnswers);
        Collections.sort(q.getCorrectAnswer());
        if (userAnswers.equals(q.getCorrectAnswer())) {
            userScore += q.getScore();
        }

        totalScore += q.getScore();
    }


    private void displayOptions(List<String> options) {
        for (int i = 0; i < options.size(); i++) {
            System.out.println("Option " + (i + 1) + " " + options.get(i));
        }
    }

    private void registerUser() {
        System.out.println("register scenario");
        System.out.println("Please enter username");
        String username = console.readString();
        System.out.println("Please enter password");
        String password = console.readString();
        System.out.println("Please enter email");
        String email = console.readString();
        System.out.println("Please enter address");
        String address = console.readLine();
        System.out.println("Please enter cellphone number");
        String mobileNo = console.readString();
        System.out.println("Please enter technical interests");
        String techInterest = console.readString();

        User user = new User(username, password, email, address, mobileNo, techInterest);

        userBank.store(user);
    }

    private void login() {
        System.out.println("Login screen:");
        while (true) {
            System.out.println("Please enter username:");
            String username = console.readString();
            System.out.println("Please enter password");
            String password = console.readString();

            if (UserAuthenticator.authenticate(username, password)) {
                System.out.println("Welcome " + username);
                break;
            } else {
                System.out.println("Incorrect username or password. Try again");
            }
        }
    }

    private String selectQuiz() {
        System.out.println("Please select a quiz topic:");
        List<String> topics = Topic.getAll();
        for (int i = 0; i < topics.size(); i++) {
            System.out.println("Option " + (i + 1) + " " + topics.get(i));
        }
        int topic;
        while (true) {
            topic = console.readInt();
            if (topic > 0 && topic <= topics.size()) {
                break;
            } else {
                System.out.println("There is not such option. Please try again");
            }
        }
        return topics.get(topic - 1);
    }

    private static void printQuestion(String question, List<String> answers) {
        System.out.println(question);
        for (String option : answers) {
            System.out.println("  " + option);
        }
        System.out.println();
    }

    private static void printUsers(Set<User> users) {
        System.out.println("Registered users");
        for (User user : users) {
            System.out.println("User:" + user.getUsername());
        }
    }
}
