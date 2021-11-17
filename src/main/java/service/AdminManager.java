package service;

import config.ConnectSingleton;
import model.Admin;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class AdminManager implements IAdmin {
    private List<Admin> adminList;

    public List<Admin> selectAdmin() {
        List<Admin> admin=new ArrayList<>();
        String query = "call selectAdmin()";
        try (Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement = connection.prepareCall(query);) {
            ResultSet rs=callableStatement.executeQuery();
            while(rs.next()){
                String name=rs.getString("name");
                String email=rs.getString("email");
                String dob=rs.getString("dob");
                String address=rs.getString("address");
                String phone=rs.getString("phone");
                String username=rs.getString("username");
                String password=rs.getString("password");
                 admin.add(new Admin(name,email,dob,address,phone,username,password));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return admin;
    }

    @Override
    public boolean editAdmin(Admin admin) throws SQLException {
        boolean rowEdit=false;
        String query="call editAdmin(?,?,?,?,?,?,?)";
        Connection connection=ConnectSingleton.getConnection();
        CallableStatement callableStatement=connection.prepareCall(query);
        callableStatement.setString(1, admin.getName());
        callableStatement.setString(2, admin.getEmail());
        callableStatement.setString(3,admin.getDob());
        callableStatement.setString(4, admin.getAddress());
        callableStatement.setString(5, admin.getPhone());
        callableStatement.setString(6, admin.getUsername());
        callableStatement.setString(7, admin.getPassword());
        rowEdit=callableStatement.executeUpdate()>0;
        return rowEdit;
    }

    public static void main(String[] args) throws SQLException {
        AdminManager adminManager=new AdminManager();
        adminManager.editAdmin(new Admin("PabloEscobar","PabloEscobar@gmail.com","1111/11/11","Mexico","0123456789","admin","okeokeoke"));
    }
}
