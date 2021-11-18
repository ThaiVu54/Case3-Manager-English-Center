package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectSingleton {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/case3", "root", "123456@Abc");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("da ket noi");
        return connection;
    }

}



