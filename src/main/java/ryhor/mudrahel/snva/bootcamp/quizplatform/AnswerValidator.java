package ryhor.mudrahel.snva.bootcamp.quizplatform;

public class AnswerValidator {
    public static boolean isValid(String answer) {
        answer = answer.toLowerCase();
        boolean valid = true;
        if (answer.length() < 1 || answer.length() > 4) {
            return false;
        }

        // Check if each character is a, b, c, or d and occurs only once
        for (char c : answer.toCharArray()) {
            if (c != 'a' && c != 'b' && c != 'c' && c != 'd') {
                return false; // Character is not a, b, c, or d
            }
            // Check for duplicate characters
            if (answer.indexOf(c) != answer.lastIndexOf(c)) {
                return false; // Duplicate character found
            }
        }

        return true;
    }
}
