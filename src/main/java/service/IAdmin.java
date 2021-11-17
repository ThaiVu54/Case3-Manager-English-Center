package service;

import model.Admin;

import java.sql.SQLException;
import java.util.List;

public interface IAdmin {
    List<Admin> selectAdmin();

    boolean editAdmin(Admin admin) throws SQLException;

}
