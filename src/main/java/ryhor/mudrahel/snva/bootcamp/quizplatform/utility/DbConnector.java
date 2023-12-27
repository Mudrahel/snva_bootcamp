package ryhor.mudrahel.snva.bootcamp.quizplatform.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    private static Connection connection;

    public static Connection connect() {
        if (connection == null) {
            //TODO later move to configuration file
            // JDBC URL, username, and password of MySQL server
            String url = "jdbc:mysql://localhost:3306/quiz_platform";
            String user = "root";
            String password = "1234";

            // Establish a connection
            try {
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to the database!");
                return connection;
                // Perform database operations here
            } catch (SQLException e) {
                System.err.println("Error connecting to the database: " + e.getMessage());
                return null;
            }
        } else {
            return connection;
        }
    }

}