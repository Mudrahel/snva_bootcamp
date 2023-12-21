package ryhor.mudrahel.snva.bootcamp.quizplatform;

import java.util.List;

public class QuestionImpl implements Question {
    private String question;
    private List<String> options;
    private String correctAnswer;
    private int score;

    public QuestionImpl(String question, List<String> options, String correctAnswer, int score) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.score = score;
    }

    @Override
    public Question getQuestion() {
        return this;
    }

    @Override
    public String getTheQuestion() {
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
