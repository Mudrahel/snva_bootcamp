package ryhor.mudrahel.snva.bootcamp.quizplatform;

import java.util.*;

public class QuestionsFactory {

    public static List<Question> produceQuestions() {
        List<Question> questions = new ArrayList<>();

        // Question 1
        Question question = new QuestionImpl("Which of the following are part of the Java Collection Framework?",
                Arrays.asList(
                        "A) Arrays",
                        "B) ArrayList", // Correct Answer
                        "C) HashMap", // Correct Answer
                        "D) String"),
                "bc",
                2);
        questions.add(question);

        // Question 2
        question = new QuestionImpl("Which of the following collections guarantees the order of elements?",
                Arrays.asList(
                        "A) LinkedList",// Correct Answer
                        "B) HashMap",
                        "C) LinkedHashSet", // Correct Answer
                        "D) ArrayList"), // Correct Answer
                "acd",
                3);
        questions.add(question);

        // Question 3
        question = new QuestionImpl("Which of the following are concurrent collections in Java?",
                Arrays.asList(
                        "A) ArrayList",
                        "B) CopyOnWriteArrayList", // Correct Answer
                        "C) HashSet",
                        "D) ConcurrentHashMap"), // Correct Answer
                "bd",
                2);
        questions.add(question);

        // Question 4
        question = new QuestionImpl("Which collection class allows duplicate elements?",
                Arrays.asList(
                        "A) HashSet",
                        "B) TreeSet",
                        "C) ArrayList", // Correct Answer
                        "D) LinkedHashSet"),
                "c",
                1);
        questions.add(question);

        // Question 5
        question = new QuestionImpl("What is the difference between HashMap and HashSet?",
                Arrays.asList(
                        "A) HashMap allows null elements", // Correct Answer
                        "B) HashSet is sorted",
                        "C) HashSet allows duplicates",
                        "D) HashSet doesn't allow duplicates"),// Correct Answer
                "ad",
                2);
        questions.add(question);

        return questions;
    }
}
