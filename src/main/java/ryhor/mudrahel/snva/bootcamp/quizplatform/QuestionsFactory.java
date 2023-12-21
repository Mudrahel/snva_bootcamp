package ryhor.mudrahel.snva.bootcamp.quizplatform;

import java.util.*;

public class QuestionsFactory {

    public static Map<String, List<String>> produce(){
        Map<String, List<String>> questions = new LinkedHashMap<String,List<String>>();

        // Question 1
        questions.put("What is the interface for a resizable array in Java?",
                Arrays.asList(
                        "A) ArrayList", // Correct Answer
                        "B) LinkedList",
                        "C) Vector", // Correct Answer
                        "D) HashSet"));

        // Question 2
        questions.put("Which of the following collections guarantees the order of elements?",
                Arrays.asList(
                        "A) HashSet",
                        "B) HashMap",
                        "C) LinkedHashSet", // Correct Answer
                        "D) TreeMap"));

        // Question 3
        questions.put("What is the purpose of the java.util.Collections class?",
                Arrays.asList(
                        "A) To provide synchronized collection classes", // Correct Answer
                        "B) To provide utility methods for collections",
                        "C) To provide methods for sorting and searching",
                        "D) To provide immutable collection classes"));

        // Question 4
        questions.put("Which collection class allows duplicate elements?",
                Arrays.asList(
                        "A) HashSet",
                        "B) TreeSet",
                        "C) ArrayList", // Correct Answer
                        "D) LinkedHashSet"));

        // Question 5
        questions.put("What is the difference between HashSet and TreeSet?",
                Arrays.asList(
                        "A) HashSet allows duplicate elements", // Correct Answer
                        "B) TreeSet is sorted", // Correct Answer
                        "C) HashSet is synchronized",
                        "D) TreeSet allows null elements"));

        return questions;
    }
}
