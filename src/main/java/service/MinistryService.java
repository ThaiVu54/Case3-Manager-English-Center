package service;

import config.ConnectSingleton;
import model.Ministry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.sql.Date;


public class MinistryService implements IMinistry {
    Ministry ministry = new Ministry();

    public static final String SELECT_FROM_MINISTRY = "select * from ministry";
    public static final String INSERT_INTO_MINISTRY_NAME_EMAIL_DOB_ADDRESS_PHONE_VALUES = "INSERT INTO ministry (name, email, dob, address, phone) VALUES (?,?,?,?,?)";

    @Override
    public List<Ministry> showMinistry() {
        List<Ministry> ministries = new ArrayList<>();
        try (Connection connection = ConnectSingleton.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_MINISTRY)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String dob = resultSet.getString("dob");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                ministries.add(new Ministry(id,name,email,dob,address,phone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ministries;
    }

    public static void main(String[] args) throws SQLException {
        MinistryService ministryService = new MinistryService();
        ministryService.showMinistry();
//        ministryService.addMinistry(new Ministry("Adma","adm@gmail.com","1998-3-1","Paris","0987123456"));
    }

    @Override
    public void addMinistry(Ministry ministry) throws SQLException {
        try(Connection connection = ConnectSingleton.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_MINISTRY_NAME_EMAIL_DOB_ADDRESS_PHONE_VALUES)){
                preparedStatement.setString(1,ministry.getName());
                preparedStatement.setString(2,ministry.getEmail());
                preparedStatement.setString(3,ministry.getDob());
                preparedStatement.setString(4,ministry.getAddress());
                preparedStatement.setString(5,ministry.getPhone());
                preparedStatement.executeUpdate();
        }
    }

    @Override
    public boolean updateMinistry(Ministry ministry) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteMinistry(int id) throws SQLException {
        return false;
    }
}
