package ryhor.mudrahel.snva.bootcamp.quizplatform.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OptionsRemover {
    public static void remove(int questionId) {

        Connection connection = DbConnector.connect();

        String selectQuery = "DELETE FROM q_data_option WHERE question_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);) {

            preparedStatement.setInt(1, questionId);

            int deletedRows = preparedStatement.executeUpdate();

            System.out.println("Deleted " + deletedRows + " from q_data_option");

        } catch (SQLException e) {
            System.err.println("Failed to delete records from from q_data_option " + e.getMessage());
        }

    }

    public static void remove(List<Integer> optionIds) {

        Connection connection = DbConnector.connect();

        String query = buildDeleteQuery(optionIds);

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            int i = 1;
            for (Integer id : optionIds) {
                preparedStatement.setInt(i, id);
                i++;
            }

            int deletedRows = preparedStatement.executeUpdate();

            System.out.println("Deleted " + deletedRows + " from q_option");

        } catch (SQLException e) {
            System.err.println("Failed to delete records from from q_option " + e.getMessage());
        }

    }

    private static String buildDeleteQuery(List<Integer> optionIds) {
        if (optionIds.isEmpty()) {
            System.out.println("error. empty list of option Ids provided");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM q_option WHERE id IN (");
        for (Integer id : optionIds) {
            sb.append("?,");
        }
        sb.deleteCharAt(sb.length() - 1);// removing extra comma
        sb.append(");");

        return sb.toString();
    }

}
