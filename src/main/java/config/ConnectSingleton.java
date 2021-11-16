package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectSingleton {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                // ae thay doi url o day
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/...", "root", "123456@Abc");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
