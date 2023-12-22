package ryhor.mudrahel.snva.bootcamp.quizplatform;

import ryhor.mudrahel.snva.bootcamp.quizplatform.utility.DbConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Topic {

    public static List<String> getAll(){
        Connection connection = DbConnector.connect();

        List<String> topics = new ArrayList<>();

        String selectQuery = "SELECT topic FROM topics";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Iterate through the result set and add topics to the list
            while (resultSet.next()) {
                String topic = resultSet.getString("topic");
                topics.add(topic);
            }

        } catch (SQLException e) {
            System.err.println("Failed to retrieve list of topics " + e.getMessage());
        }

        return topics;
    }
}
