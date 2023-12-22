package ryhor.mudrahel.snva.bootcamp.quizplatform.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class QuestionCreator {

    public static int insert(String question, int score, int topicId) {
        Connection connection = DbConnector.connect();

        // SQL query to insert a record and retrieve the generated ID
        String insertQuery = "INSERT INTO q_data(question, score, topic_id) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {

            // Set the values for the parameters in the query
            preparedStatement.setString(1, question);
            preparedStatement.setInt(2, score);
            preparedStatement.setInt(3, topicId);

            // Execute the insert query
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                // Retrieve the generated keys (in this case, the generated ID)
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        long generatedId = generatedKeys.getLong(1);
                        System.out.println("Record inserted with ID: " + generatedId);
                        return (int)generatedId;
                    } else {
                        System.out.println("No ID obtained.");
                    }
                }
            } else {
                System.out.println("No rows affected.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;

    }
}
