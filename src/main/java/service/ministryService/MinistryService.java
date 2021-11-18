package service.ministryService;

import config.ConnectSingleton;
import model.Ministry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import java.sql.Date;


public class MinistryService implements IMinistry {

    Connection connection = ConnectSingleton.getConnection();


    @Override
    public List<Ministry> showMinistry() {
        List<Ministry> ministryList = new ArrayList<>();
        try (PreparedStatement preparedStatement=connection.prepareStatement("select * from ministry")){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name=resultSet.getString("name") ;
                String email = resultSet.getString("email");
                String dob = resultSet.getString("dob");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                ministryList.add(new Ministry(id,name,email,dob,address,phone,username,password));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ministryList;
    }

    public static void main(String[] args) {
        MinistryService ministryService = new MinistryService();
        ministryService.showMinistry();
    }

    @Override
    public boolean deleteMinistry(int id) throws SQLException {
        return false;
    }

    @Override
    public Ministry findById(int id) {
        return null;
    }

    @Override
    public boolean updateMinistry(Ministry ministry) throws SQLException {
        return false;
    }

    @Override
    public void addMinistry(Ministry ministry) throws SQLException {

    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}