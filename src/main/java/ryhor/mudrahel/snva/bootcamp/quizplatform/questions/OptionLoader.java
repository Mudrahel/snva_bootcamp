package ryhor.mudrahel.snva.bootcamp.quizplatform.questions;

import ryhor.mudrahel.snva.bootcamp.quizplatform.questions.Question;
import ryhor.mudrahel.snva.bootcamp.quizplatform.utility.DbConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OptionLoader {

    public static void load(List<Question> questions) {
        Connection connection = DbConnector.connect();

        String selectQuery = "SELECT qo.q_option " +
                "FROM q_option qo " +
                "JOIN q_data_option qd ON qd.option_id=qo.id " +
                "WHERE qd.question_id = ?;";

        for (Question question : questions) {

            List<String> options = new ArrayList<>();

            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                // Set the parameter for the topic name
                preparedStatement.setInt(1, question.getQuestionId());

                // Execute the query
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Iterate through the result set and print each row
                    while (resultSet.next()) {
                        options.add(resultSet.getString("q_option"));
                    }
                }
                question.setOptions(options);

            } catch (SQLException e) {
                System.err.println("Failed to retrieve Options from DB: " + e.getMessage());
            }
        }
    }
}
