package ryhor.mudrahel.snva.bootcamp.quizplatform.questions;

import java.util.List;

public class QuestionImpl implements Question {
    private int questionId;
    private String question;
    private List<String> options;
    private List<String> correctAnswer;
    private int score;


    public QuestionImpl(int id, String question, int score) {
        this.questionId = id;
        this.question = question;
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
    public void setOptions(List<String> options) {
        this.options=options;
    }

    @Override
    public List<String> getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public void setCorrectAnswer(List<String> correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public int getScore() {
        return score;
    }
}
