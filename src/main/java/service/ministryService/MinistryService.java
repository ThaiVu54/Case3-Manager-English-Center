package service.ministryService;

import config.ConnectSingleton;
import model.Ministry;
import service.ministryService.IMinistry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import java.sql.Date;


public class MinistryService implements IMinistry {
    public static final String UPDATE_MINISTRY_T_SET_T_NAME_T_EMAIL_T_DOB_T_ADDRESS_T_PHONE_WHERE_T_ID = "UPDATE ministry t SET t.name = ?, t.email = ?, t.dob = ?, t.address = ?, t.phone = ? WHERE t.id = ?;";
    public static final String DELETE_FROM_MINISTRY_WHERE_ID = "DELETE FROM ministry WHERE id = ?";
//    Ministry ministry = new Ministry();

    public static final String SELECT_FROM_MINISTRY = "select * from ministry";
    public static final String INSERT_INTO_MINISTRY_NAME_EMAIL_DOB_ADDRESS_PHONE_VALUES = "INSERT INTO ministry (name, email, dob, address, phone) VALUES (?,?,?,?,?)";
    Connection connection = ConnectSingleton.getConnection();

    @Override
    public List<Ministry> showMinistry() {
        List<Ministry> ministries = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_MINISTRY)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String dob = resultSet.getString("dob");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                ministries.add(new Ministry(id, name, email, dob, address, phone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ministries;
    }


    @Override
    public void addMinistry(Ministry ministry) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_MINISTRY_NAME_EMAIL_DOB_ADDRESS_PHONE_VALUES)) {
            preparedStatement.setString(1, ministry.getName());
            preparedStatement.setString(2, ministry.getEmail());
            preparedStatement.setString(3, ministry.getDob());
            preparedStatement.setString(4, ministry.getAddress());
            preparedStatement.setString(5, ministry.getPhone());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public boolean updateMinistry(Ministry ministry) throws SQLException {
        boolean rowUpdated = false;
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE ministry\n" +
                "SET name    = ?,\n" +
                "    email   = ?,\n" +
                "    dob     = ?,\n" +
                "    address = ?,\n" +
                "    phone   = ?\n" +
                "WHERE id = ?");
        preparedStatement.setString(1, ministry.getName());
        preparedStatement.setString(2, ministry.getEmail());
        preparedStatement.setString(3, ministry.getDob());
        preparedStatement.setString(4, ministry.getAddress());
        preparedStatement.setString(5, ministry.getPhone());
        preparedStatement.setInt(6, ministry.getId());
        rowUpdated = preparedStatement.executeUpdate() > 0;
        return rowUpdated;
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
        String query = "call find_id_ministry(?)";
        try ( CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String dob = resultSet.getString("dob");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                ministry = new Ministry(name, email, dob, address, phone);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ministry;
    }

//    public static void main(String[] args) {
//        MinistryService ministryService = new MinistryService();
//        ministryService.findById(1);
//    }

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
