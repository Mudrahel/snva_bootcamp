package ryhor.mudrahel.snva.bootcamp.quizplatform.questions;

import java.util.List;

public interface Question {
    int getQuestionId();
    void setQuestionId(int id);

    List<String> getOptions();
    void setOptions(List<String> options);

    String getQuestionStr();
    List<String> getCorrectAnswer();
    void setCorrectAnswer(List<String> answers);

    int getScore();

}
