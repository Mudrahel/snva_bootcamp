package ryhor.mudrahel.snva.bootcamp.quizplatform.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CorrectOptionsRemover {
    public static void remove(int questionId) {

        Connection connection = DbConnector.connect();

        String query = "DELETE FROM q_data_answers WHERE question_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            preparedStatement.setInt(1, questionId);

            int deletedRows = preparedStatement.executeUpdate();

            System.out.println("Deleted "+deletedRows+" from q_data_answers");

        } catch (SQLException e) {
            System.err.println("Failed to delete records from from q_data_answers " + e.getMessage());
        }

    }

}
