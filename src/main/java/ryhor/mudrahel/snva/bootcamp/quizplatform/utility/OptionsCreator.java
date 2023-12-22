package ryhor.mudrahel.snva.bootcamp.quizplatform.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptionsCreator {
    public static Map<String, Integer> insert(List<String> options) {
        Connection connection = DbConnector.connect();

        // SQL query to insert a record and retrieve the generated ID
        String insertQuery = buildInsertQuery(options.size());

        // Map to store the association between option values and generated IDs
        Map<String, Integer> optionsMap = new HashMap<>();

        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {

            for (int i = 0; i < options.size(); i++) {
                preparedStatement.setString(i + 1, options.get(i));

            }

            // Execute the insert query
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                int index = 0;
                // Retrieve the generated keys as a ResultSet
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    while (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        // Store the association in the map
                        optionsMap.put(options.get(index), generatedId);
                        index++;
                        System.out.println("Generated ID: " + generatedId);
                    }
                }
                return optionsMap;
            } else {
                System.out.println("No rows affected.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String buildInsertQuery(int options) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO q_option(q_option) VALUES ");
        for (int i = 0; i < options; i++) {
            sb.append("(?),");
        }

        sb.deleteCharAt(sb.length() - 1);// removing extra comma

        return sb.toString();
    }
}
