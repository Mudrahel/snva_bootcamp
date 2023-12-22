package ryhor.mudrahel.snva.bootcamp.quizplatform.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collection;

public class QuestionCorrOptionConnector {
    public static void connect(int questionId, Collection<Integer> optionIds) {

        Connection connection = DbConnector.connect();

        // SQL query to insert a record and retrieve the generated ID
        String insertQuery = buildInsertQuery(optionIds.size());

        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(insertQuery)) {
            int order = 1;
            for (Integer optionId : optionIds) {
                preparedStatement.setInt(order, questionId);
                order++;
                preparedStatement.setInt(order, optionId);
                order++;
            }

            // Execute the insert query
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println(affectedRows + " of records inserted");
            } else {
                System.out.println("No rows affected.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String buildInsertQuery(int records) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO q_data_answers(question_id,option_id) VALUES ");
        for (int i = 0; i < records; i++) {
            sb.append("(?,?),");
        }

        sb.deleteCharAt(sb.length() - 1);// removing extra comma

        return sb.toString();
    }

}
