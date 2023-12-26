package ryhor.mudrahel.snva.bootcamp.quizplatform.utility;

import ryhor.mudrahel.snva.bootcamp.quizplatform.questions.Question;
import ryhor.mudrahel.snva.bootcamp.quizplatform.questions.QuestionImpl;

import java.util.*;

public class AddQuestionToDB {

    public static void main(String[] args) {
        int topicId = 1;//Java
//        int topicId = 2;//Python
//        int topicId = 1;//.Net
        int score = 2;

        Question question = new QuestionImpl(
                "the question string?"
                , Arrays.asList("Option A", "Option B"
                , "Option C", "Option D") //list of 4 options
                , Arrays.asList("Option A", "Option C")//correct options
                , score
        );

        addQuestion(question, topicId);

    }

    private static void addQuestion(Question question, int topicId) {
        System.out.println("Inserting question in q_data");
        int questionId = insertQuestion(question.getQuestionStr(), question.getScore(), topicId);
        question.setQuestionId(questionId);

        System.out.println("Inserting options in q_option");
        Map<String, Integer> options = insertOptions(question.getOptions());

        System.out.println("Connecting questions with options in q_data_option");
        connectOptionsWithQuestion(question.getQuestionId(), options.values());

        System.out.println("Detecting correct answers");
        List<String> correctOptionsList = question.getCorrectAnswer();
        Map<String, Integer> correctOptionsMap = gatherCorrectAnswers(options, correctOptionsList);

        System.out.println("Connecting questions with answers in q_data_answers");
        connectCorrectOptionsWithQuestion(question.getQuestionId(), correctOptionsMap.values());
    }

    private static Map<String, Integer> gatherCorrectAnswers(Map<String, Integer> options, List<String> correctOptions) {
        Map<String, Integer> filteredMap = new HashMap<>();

        for (String key : correctOptions) {
            if (options.containsKey(key)) {
                // Add the entry to the filtered map
                filteredMap.put(key, options.get(key));
            }
        }

        return filteredMap;
    }

    private static void connectOptionsWithQuestion(int questionId, Collection<Integer> values) {
        QuestionOptionConnector.connect(questionId, values);
    }

    private static void connectCorrectOptionsWithQuestion(int questionId, Collection<Integer> values) {
        QuestionCorrOptionConnector.connect(questionId, values);
    }

    private static Map<String, Integer> insertOptions(List<String> options) {
        return OptionsCreator.insert(options);
    }

    private static int insertQuestion(String question, int score, int topicId) {
        return QuestionCreator.insert(question, score, topicId);
    }
}
