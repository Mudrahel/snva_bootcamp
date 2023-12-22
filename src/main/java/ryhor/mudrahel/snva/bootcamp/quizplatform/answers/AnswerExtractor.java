package ryhor.mudrahel.snva.bootcamp.quizplatform.answers;

import java.util.ArrayList;
import java.util.List;

public class AnswerExtractor {

    public static List<String> extract(List<String> options, String answer) {
        List<String> userAnswer = new ArrayList<>();

        for (int i = 0; i < answer.length(); i++) {
            int intValue = charToInt(answer.charAt(i));
            userAnswer.add(options.get(intValue - 1));
        }
        return userAnswer;
    }

    private static int charToInt(char c) {
        // Assuming the char represents a digit ('0' to '9')
        return c - '0';
    }
}
