package service.studentService;

import config.ConnectSingleton;
import model.Grade;
import model.Student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService {


    @Override
    public void addNewStudent(Student student) {
        String query = "call addNewStudent(?,?,?,?,?,?,?,?,?);";
        try (Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setString(1, student.getName());
            callableStatement.setString(2, student.getEmail());
            callableStatement.setDouble(3, student.getMark());
            callableStatement.setString(4, student.getDob());
            callableStatement.setString(5, student.getAddress());
            callableStatement.setString(6, student.getPhone());
            callableStatement.setInt(7, student.getGrade().getId());
            callableStatement.setString(8, student.getUserName());
            callableStatement.setString(9, student.getPassword());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean updateStudent(Student student) {
        boolean update = false;
        String query = "call updateStuddentByID(?,?,?,?,?,?,?,?);";
        try (Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, student.getId());
            callableStatement.setString(2, student.getName());
            callableStatement.setString(3, student.getEmail());
            callableStatement.setDouble(4, student.getMark());
            callableStatement.setString(5, student.getDob());
            callableStatement.setString(6, student.getAddress());
            callableStatement.setString(7, student.getPhone());
            callableStatement.setInt(8, student.getGrade().getId());
            update = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public void deleteStudent(int id) {
        String query = "call deleteStudentByID(?); ";
        try (Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student getStudentByID(int id) {
        return null;
    }

//    @Override
//    public Student getStudentByID(int id) {
//        Student student = null;
//        String query = "call getStudentInforByID(?); ";
//        try (Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {
//            callableStatement.setInt(1, id);
//            ResultSet rs = callableStatement.executeQuery();
//            if (rs.next()) {
//                String studentName = rs.getString(1);
//                String email = rs.getString(2);
//                double mark = rs.getDouble(3);
//                String dob = rs.getString(4);
//                String address = rs.getString(5);
//                String phone = rs.getString(6);
//                String userName = rs.getString(7);
//                String gradeName = rs.getString(8);
//                String courseName = rs.getString(9);
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @Override
    public List<Student> seeAllStudent() {
        String query = "call selectAllStudents();";
        List<Student> studentList = new ArrayList<>();
        try (Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                String studentName = rs.getString(2);
                String email = rs.getString(3);
                double mark = rs.getDouble(4);
                String dob = rs.getString(5);
                String address = rs.getString(6);
                String phone = rs.getString(7);
                String userName = rs.getString(7);
                String gradeName = rs.getString(8);
                Student student = new Student(userName, dob, address, email, phone, mark, studentName);
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
