package service.studentService;

import config.ConnectSingleton;
import model.Grade;
import model.Student;
import model.Teacher;
import service.gradeservice.GradeService;
import service.teacherservice.TeacherSevice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService {
    private List<Student> students;
    private GradeService gradeService = new GradeService();

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
        Student student = null;
        String query = "call getStudentInforByID(?);";
        try(Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            if (rs.next()){
                String name = callableStatement.getString(2);
                String email = callableStatement.getString(3);
                double mark = callableStatement.getDouble(4);
                String dob = callableStatement.getString(5);
                String address = callableStatement.getString(6);
                String phone = callableStatement.getString(7);
                int gradeid = callableStatement.getInt(8);
                String username = callableStatement.getString(9);
                String password = callableStatement.getString(10);
                Grade grade = gradeService.selectGradebyId(gradeid);
                student = new Student(username, password, dob, address, email, phone, id, grade, mark, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> seeAllStudent() {
        String query = "call selectAllStudents();";
        students = new ArrayList<>();
        try (Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                int studentid = callableStatement.getInt(1);
                String name = callableStatement.getString(2);
                String email = callableStatement.getString(3);
                double mark = callableStatement.getDouble(4);
                String dob = callableStatement.getString(5);
                String address = callableStatement.getString(6);
                String phone = callableStatement.getString(7);
                String username = callableStatement.getString(8);
                String password = callableStatement.getString(9);
                int gradeid = callableStatement.getInt(10);
                Grade grade = gradeService.selectGradebyId(gradeid);
                students.add(new Student(username, password, dob, address, email, phone, studentid, grade, mark, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<Student> selectListStudentByGradeId(int id) {
        students = new ArrayList<>();
        String query = "call selectstudentbygradeid(?);";
        try(Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1,id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                int studentid = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                double mark = rs.getDouble(4);
                String dob = rs.getString(5);
                String address = rs.getString(6);
                String phone = rs.getString(7);
                int gradeid = rs.getInt(8);
                String username = rs.getString(9);
                String password = rs.getString(10);
                Grade grade = gradeService.selectGradebyId(gradeid);
                students.add(new Student(username, password, dob, address, email, phone, studentid, grade, mark, name));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
