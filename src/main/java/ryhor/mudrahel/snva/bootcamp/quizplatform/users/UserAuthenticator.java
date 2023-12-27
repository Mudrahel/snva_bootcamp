package ryhor.mudrahel.snva.bootcamp.quizplatform.users;

import ryhor.mudrahel.snva.bootcamp.quizplatform.utility.DbConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAuthenticator {

    public static boolean authenticate(String username, String password) {
        Connection connection = DbConnector.connect();

        // SQL query to check if the user exists
        String selectQuery = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            // Set values for parameters in the prepared statement
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // Execute the SELECT query
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Check if any rows are returned
                return resultSet.next();
            }

        } catch (SQLException e) {
            System.err.println("Failed to validate a user into users: " + e.getMessage());
        }
        return false;

    }
}
