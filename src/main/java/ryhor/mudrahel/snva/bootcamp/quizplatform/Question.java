package ryhor.mudrahel.snva.bootcamp.quizplatform;

import java.util.List;

public interface Question {
    int getQuestionId();

    List<String> getOptions();

    String getQuestionStr();
    String getCorrectAnswer();

    int getScore();

}
