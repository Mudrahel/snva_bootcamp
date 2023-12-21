package ryhor.mudrahel.snva.bootcamp.quizplatform;

import java.util.List;

public interface Question {
    Question getQuestion();

    List<String> getOptions();

    String getTheQuestion();
    String getCorrectAnswer();

    int getScore();

}
