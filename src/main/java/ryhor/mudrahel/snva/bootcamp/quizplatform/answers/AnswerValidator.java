package ryhor.mudrahel.snva.bootcamp.quizplatform.answers;

public class AnswerValidator {
    public static boolean isValid(String answer) {
        if (answer.length() < 1 || answer.length() > 4) {
            return false;
        }

        // Check if each character is 1, 2, 3, or 4 and occurs only once
        for (char c : answer.toCharArray()) {
            if (c != '1' && c != '2' && c != '3' && c != '4') {
                return false;
            }
            // Check for duplicate characters
            if (answer.indexOf(c) != answer.lastIndexOf(c)) {
                return false; // Duplicate character found
            }
        }

        return true;
    }
}
