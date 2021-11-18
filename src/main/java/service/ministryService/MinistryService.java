package service.ministryService;

import config.ConnectSingleton;
import model.Ministry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import java.sql.Date;


public class MinistryService implements IMinistry {

    public static final String DELETE_FROM_MINISTRY_WHERE_ID = "delete from ministry where id=?";
    public static final String SELECT_ID_NAME_EMAIL_DOB_ADDRESS_PHONE_FROM_MINISTRY_WHERE_ID = "select id,name,email,dob,address,phone from ministry where id = ?";
    public static final String UPDATE_CASE_3_MINISTRY_SET_NAME_EMAIL_DOB_ADDRESS_PHONE_T_USERNAME_PASSWORD_WHERE_ID = "UPDATE ministry SET name = ?, email = ?, dob = ?, address = ?, phone = ?, username = ?,password = ? WHERE id = ?";
    public static final String INSERT_INTO_MINISTRY_NAME_EMAIL_DOB_ADDRESS_PHONE_USERNAME_PASSWORD_VALUES = "INSERT INTO ministry (name, email, dob, address, phone, username, password) VALUES (?, ?, ?, ?, ?,?, ?)";
    Connection connection = ConnectSingleton.getConnection();


    @Override
    public List<Ministry> showMinistry() {
        List<Ministry> ministryList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select id,name,email,dob,address,phone from ministry")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String dob = resultSet.getString("dob");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
//                String username = resultSet.getString("username");
//                String password = resultSet.getString("password");
                ministryList.add(new Ministry(id, name, email, dob, address, phone));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ministryList;
    }


    @Override
    public boolean deleteMinistry(int id) throws SQLException {
        boolean rowDeleted = false;
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_MINISTRY_WHERE_ID);
        preparedStatement.setInt(1, id);
        rowDeleted = preparedStatement.executeUpdate() > 1;
        return rowDeleted;
    }

    @Override
    public Ministry findById(int id) {
        Ministry ministry = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID_NAME_EMAIL_DOB_ADDRESS_PHONE_FROM_MINISTRY_WHERE_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String dob = resultSet.getString("dob");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                ministry = new Ministry(id, name, email, dob, address, phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ministry;
    }


    @Override
    public boolean updateMinistry(Ministry ministry) throws SQLException {
        boolean rowUpdated = false;
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CASE_3_MINISTRY_SET_NAME_EMAIL_DOB_ADDRESS_PHONE_T_USERNAME_PASSWORD_WHERE_ID);
        preparedStatement.setString(1, ministry.getName());
        preparedStatement.setString(2, ministry.getEmail());
        preparedStatement.setString(3, ministry.getDob());
        preparedStatement.setString(4, ministry.getAddress());
        preparedStatement.setString(5, ministry.getPhone());
        preparedStatement.setString(6, ministry.getUsername());
        preparedStatement.setString(7, ministry.getPassword());
        preparedStatement.setInt(8, ministry.getId());
        rowUpdated = preparedStatement.executeUpdate() > 0;
        return rowUpdated;
    }


    @Override
    public void addMinistry(Ministry ministry) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_MINISTRY_NAME_EMAIL_DOB_ADDRESS_PHONE_USERNAME_PASSWORD_VALUES);
//        preparedStatement.setInt(1,ministry.getId());
        preparedStatement.setString(1, ministry.getName());
        preparedStatement.setString(2, ministry.getEmail());
        preparedStatement.setString(3, ministry.getDob());
        preparedStatement.setString(4, ministry.getAddress());
        preparedStatement.setString(5, ministry.getPhone());
        preparedStatement.setString(6, ministry.getUsername());
        preparedStatement.setString(7, ministry.getPassword());

        preparedStatement.executeUpdate();
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