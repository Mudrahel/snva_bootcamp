package ryhor.mudrahel.snva.bootcamp.quizplatform.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OptionsReader {
    public static List<Integer> read(int questionId) {
        Connection connection = DbConnector.connect();

        List<Integer> optionIds = null;

        String selectQuery = "SELECT option_id FROM q_data_option WHERE question_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);) {

            // Set the values for the parameters in the query
            preparedStatement.setInt(1, questionId);

            ResultSet resultSet = preparedStatement.executeQuery();

            optionIds = new ArrayList<>();
            while (resultSet.next()) {
                optionIds.add(resultSet.getInt("option_id"));
            }

            System.out.println("Gathered " + optionIds.size() + " options");

        } catch (SQLException e) {
            System.err.println("Failed to retrieve options ids from q_data_option " + e.getMessage());
        }

        return optionIds;
    }
}
