package ryhor.mudrahel.snva.bootcamp.quizplatform;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizLoader {

    static List<Question> load(String topic) {
        Connection connection = DbConnector.connect();

        List<Question> questions = new ArrayList<>();

        String selectQuery = "SELECT qd.id, qd.question, qd.score " +
                "FROM q_data qd " +
                "JOIN topics t ON qd.topic_id = t.id " +
                "WHERE t.topic = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            // Set the parameter for the topic name
            preparedStatement.setString(1, topic);

            // Execute the query
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                // Iterate through the result set and print each row
                while (resultSet.next()) {
                    int questionId = resultSet.getInt("id");
                    String question = resultSet.getString("question");
                    int score = resultSet.getInt("score");

                    questions.add(new QuestionImpl(questionId, question, score));
                }
            }

        } catch (SQLException e) {
            System.err.println("Failed to retrieve Questions from DB: " + e.getMessage());
        }

        return questions;
    }
}
