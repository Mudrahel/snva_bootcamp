package ryhor.mudrahel.snva.bootcamp.quizplatform.answers;

import java.util.Arrays;

public class AnswerVerifier {
    public static boolean isCorrect(String answer,String correctAnswer) {
        answer = answer.toLowerCase();
        // Check if the lengths are equal
        if (answer.length() != correctAnswer.length()) {
            return false;
        }

        // Convert strings to char arrays and sort them
        char[] charArray1 = answer.toCharArray();
        char[] charArray2 = correctAnswer.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Compare the sorted char arrays
        return Arrays.equals(charArray1, charArray2);

    }
}
