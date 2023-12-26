package ryhor.mudrahel.snva.bootcamp.quizplatform.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionReader {

    public static int get(String question, int topicId) {
        Connection connection = DbConnector.connect();

        String selectQuery = "SELECT id FROM q_data WHERE question = ? and topic_id = ? limit 1; ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);) {

            // Set the values for the parameters in the query
            preparedStatement.setString(1, question);
            preparedStatement.setInt(2, topicId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id");
            }else {
                System.out.println("No question found");
            }

        } catch (SQLException e) {
            System.err.println("Failed to retrieve a question from q_data " + e.getMessage());
        }

        return -1;
    }
}
