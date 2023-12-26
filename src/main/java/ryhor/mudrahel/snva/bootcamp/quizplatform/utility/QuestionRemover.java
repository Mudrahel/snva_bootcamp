package ryhor.mudrahel.snva.bootcamp.quizplatform.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuestionRemover {
    public static void remove(int questionId) {

        Connection connection = DbConnector.connect();

        String selectQuery = "DELETE FROM q_data WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);) {

            preparedStatement.setInt(1, questionId);

            int deletedRows = preparedStatement.executeUpdate();

            System.out.println("Deleted " + deletedRows + " from q_data");

        } catch (SQLException e) {
            System.err.println("Failed to delete a record from from q_data " + e.getMessage());
        }

    }
}
