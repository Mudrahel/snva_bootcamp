package ryhor.mudrahel.snva.bootcamp.quizplatform;


/**
 * Online Quiz Platform:
 * Create an online quiz platform with multiple-choice questions. Allow users to register, take quizzes, and view their scores. Implement a question bank and a scoring system.
 * Use the following:
 * 1.	SOLID principles
 * 2.	Collections
 * 3.	Exception Handling
 * 4.	User Input Validations
 * Note: Your code should not break at any point of time, no matter what the input is. It should generate user friendly messages as and when necessary
 * <p>
 * Extend the code on the following lines:
 * 1.	Add a Database table to add new users (userid, username, password, email, address, mobile no, technologies interested:
 * Java Full Stack, Python full stack, DotNet, MEAN stack, MERN Stack, DevOps, Cloud)
 * 2.	Add a database table with questions and answers
 * 3.	Your application should validate users based on the details in the database (Username + password)
 * 4.	Depending on the user’s choice of tests (E.g. Java full stack), the test should be displayed.
 * <p>
 * Three quiz, Java, Python, DevOps
 */
public class Main {

    public static void main(String[] args) {

        QuizPlatform qp = new QuizPlatform();

        qp.run();
    }
}
