import java.sql.*;

public class UserDAO {

    public User checkLogin(String username, String password) throws SQLException,
            ClassNotFoundException {
        String jdbcURL = "jdbc:mysql://localhost:3306/";
        String dbUser = "root";
        String dbPassword = "marko";


        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        String sql = "SELECT * FROM user.users WHERE username = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);

        ResultSet result = statement.executeQuery();

        User user = null;

        if (result.next()) {
            user = new User();
            user.setFullname(result.getString("fullname"));
            user.setPassword(password);
        }

        connection.close();

        return user;
    }

    public static void main(String[] args) {

    }
}