package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectSingleton {
<<<<<<< HEAD
    private static Connection connection;
    private static String URL = "jdbc:mysql://localhost:3306/english_center";
    private static String username = "root";
    private static String password = "123456789";//anh em tự thay đổi password nhé
=======
    private static Connection connection = null;
>>>>>>> thai

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
<<<<<<< HEAD
                connection = DriverManager.getConnection(URL, username, password);
=======
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_m3", "root", "123456@Abc");
>>>>>>> thai
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("da ket noi");
        return connection;
    }
}





