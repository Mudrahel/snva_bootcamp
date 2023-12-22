package ryhor.mudrahel.snva.bootcamp.quizplatform;

import java.util.List;

public class QuestionImpl implements Question {
    private int questionId;
    private String question;
    private List<String> options;
    private String correctAnswer;
    private int score;


    public QuestionImpl(int id, String question, int score) {
        this.questionId = id;
        this.question = question;
        this.score = score;
    }

    public QuestionImpl(String question, List<String> options, String correctAnswer, int score) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.score = score;
    }

    public int getQuestionId() {
        return questionId;
    }

    @Override
    public String getQuestionStr() {
        return question;
    }

    @Override
    public List<String> getOptions() {
        return options;
    }

    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public int getScore() {
        return score;
    }
}
