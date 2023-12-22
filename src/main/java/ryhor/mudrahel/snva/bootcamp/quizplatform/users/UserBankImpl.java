package ryhor.mudrahel.snva.bootcamp.quizplatform.users;

import ryhor.mudrahel.snva.bootcamp.quizplatform.utility.DbConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UserBankImpl implements UserBank {
    private Set<User> users;

    public UserBankImpl() {
        this.users = new HashSet<User>();
    }

    @Override
    public void store(User user) {

        insertUser(user);

        if(!users.contains(user)){
            users.add(user);
            System.out.println("User '"+user.getUsername()+"' added to user list");
        }
    }

    @Override
    public Set<User> getUsers() {
        return users;
    }

    // Method to insert data with a given Connection
    private static boolean insertUser(User user) {
        Connection connection = DbConnector.connect();
        // SQL query to insert data
        String insertQuery = "INSERT INTO users (username, password, email, address, mobile_no, tech_interest) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            // Set values for parameters in the prepared statement
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getMobileNo());
            preparedStatement.setString(6, user.getTechInterest());

            // Execute the insert operation
            int affectedRows = preparedStatement.executeUpdate();

            return affectedRows > 0;

        } catch (SQLException e) {
            System.err.println("Failed to insert a user into users: " + e.getMessage());
            return false;
        }
    }
}
