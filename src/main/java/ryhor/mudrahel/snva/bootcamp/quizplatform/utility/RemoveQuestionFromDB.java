package ryhor.mudrahel.snva.bootcamp.quizplatform.utility;

import ryhor.mudrahel.snva.bootcamp.quizplatform.questions.Question;
import ryhor.mudrahel.snva.bootcamp.quizplatform.questions.QuestionImpl;

import java.util.*;

public class RemoveQuestionFromDB {

    public static void main(String[] args) {
        int topicId = 1;//Java
//        int topicId = 2;//Python
//        int topicId = 1;//.Net

        Question question = new QuestionImpl("the question string?");

        removeQuestion(question, topicId);

    }

    private static void removeQuestion(Question question, int topicId) {
        //TODO in future it would be good idea to wrap whole operation as transaction, if possible

        System.out.println("Pulling question from q_data");
        int questionId = pullQuestion(question.getQuestionStr(), topicId);
        question.setQuestionId(questionId);

        System.out.println("Removing answers from q_data_answers");
        removeCorrectOptions(question.getQuestionId());

        List<Integer> optionIds = pullOptions(questionId);

        System.out.println("Removing options from q_data_option");
        removeOptions(question.getQuestionId());

        System.out.println("Removing options from q_option");
        removeOptions(optionIds);

        System.out.println("Removing question from q_data");
        removeQuestionData(question.getQuestionId());

    }

    private static void removeQuestionData(int questionId) {
        QuestionRemover.remove(questionId);
    }

    private static List<Integer> pullOptions(int questionId) {
        return OptionsReader.read(questionId);
    }

    private static void removeOptions(int questionId) {
        OptionsRemover.remove(questionId);
    }

    private static void removeOptions(List<Integer> optionIds) {
        OptionsRemover.remove(optionIds);
    }


    private static void removeCorrectOptions(int questionId) {
        CorrectOptionsRemover.remove(questionId);
    }

    private static Map<String, Integer> insertOptions(List<String> options) {
        return OptionsCreator.insert(options);
    }

    private static int pullQuestion(String question, int topicId) {
        return QuestionReader.get(question, topicId);
    }
}
