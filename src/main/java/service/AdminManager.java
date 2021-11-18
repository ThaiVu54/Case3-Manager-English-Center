package service;

import config.ConnectSingleton;
import model.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminManager implements IAdmin {
    Connection connection = ConnectSingleton.getConnection();
    private List<Admin> adminList;

    public List<Admin> selectAdmin() {
        List<Admin> admin = new ArrayList<>();
        String query = "call selectAdmin()";
        try (CallableStatement callableStatement = connection.prepareCall(query);) {
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String dob = rs.getString("dob");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String username = rs.getString("username");
                String password = rs.getString("password");
                admin.add(new Admin(name, email, dob, address, phone, username, password));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return admin;
    }

    @Override
    public boolean editAdmin(Admin admin) throws SQLException {
        boolean rowEdit = false;
        String query = "call editAdmin(?,?,?,?,?,?,?)";
        CallableStatement callableStatement = connection.prepareCall(query);
        callableStatement.setString(1, admin.getName());
        callableStatement.setString(2, admin.getEmail());
        callableStatement.setString(3, admin.getDob());
        callableStatement.setString(4, admin.getAddress());
        callableStatement.setString(5, admin.getPhone());
        callableStatement.setString(6, admin.getUsername());
        callableStatement.setString(7, admin.getPassword());
        rowEdit = callableStatement.executeUpdate() > 0;
        return rowEdit;
    }

    public boolean checkAccount(String username, String password) {
        Admin admin = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select*from admin where username=? and password=?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                String username1=rs.getString("username");
                String password1=rs.getString("password");
                admin=new Admin(username1,password1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin!=null;
    }
}
