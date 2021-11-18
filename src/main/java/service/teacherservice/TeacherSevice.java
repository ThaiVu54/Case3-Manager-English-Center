package service.teacherservice;

import config.ConnectSingleton;
import model.Course;
import model.Teacher;
import service.courseservice.CourseService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherSevice implements ITeacherService{
    private List<Teacher> teachers;
    private CourseService courseService = CourseService.getCourseService();
    private static TeacherSevice teacherSevice;
    public static TeacherSevice getTeacherSevice(){
        if (teacherSevice == null){
            teacherSevice = new TeacherSevice();
        }
        return teacherSevice;
    }

    private TeacherSevice() {
    }

    @Override
    public List<Teacher> selectAllTeacherbyCourseid(int id) {
        teachers = new ArrayList<>();
        String query = "call selectallteacherbycourseid(?);";
        try(Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                int teacherid = rs.getInt(1);
                String name = rs.getString(2);
                String phone = rs.getString(3);
                String dob = rs.getString(4);
                String address = rs.getString(5);
                String email = rs.getString(6);
                String username = rs.getString(7);
                String password = rs.getString(8);
                int courseid = rs.getInt(9);
                String coursename = rs.getString(10);
                Teacher teacher = new Teacher(username, password, dob, address, email, phone, name, teacherid);
                Course course = new Course(courseid, coursename);
                teacher.addCourse(course);
                course.addTeacher(teacher);
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }
    @Override
    public List<Teacher> selectAllTeacher() {
        teachers = new ArrayList<>();
        String query = "call selectallteacher();";
        try(Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String dob = rs.getString(4);
                String address = rs.getString(5);
                String phone = rs.getString(6);
                String username = rs.getString(7);
                String password = rs.getString(8);
                int courseid = rs.getInt(9);
                String coursename = rs.getString(10);
                Teacher teacher = new Teacher(username, password, dob, address, email, phone, name, id);
                Course course = new Course(courseid, coursename);
                course.addTeacher(teacher);
                teacher.addCourse(course);
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    @Override
    public Teacher selectTecherById(int id) {
        Teacher teacher = null;
        String query = "call selectteacherbyid(?);";
        try(Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement1 = connection.prepareCall(query)) {
            callableStatement1.setInt(1, id);
            ResultSet rs = callableStatement1.executeQuery();
            if (rs.next()){
                String name = rs.getString(2);
                String email = rs.getString(3);
                String dob = rs.getString(4);
                String address = rs.getString(5);
                String phone = rs.getString(6);
                String username = rs.getString(7);
                String password = rs.getString(8);
                List<Course> courses = courseService.selectAllCoursebyTecherId(id);
                teacher = new Teacher(username, password, dob, address, email, phone, id, courses, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }

    @Override
    public void addTeacher(Teacher teacher, int[] courseids) {
        String query1 = "call insertteacher(?, ?, ?, ?, ?, ?, ?, ?);";
        String query2 = "call insertcourse_teacher(?,?);";
        int teacherid;
        try(Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement = connection.prepareCall(query1); CallableStatement callableStatement1 = connection.prepareCall(query2)) {
            callableStatement.setString(1,teacher.getName());
            callableStatement.setString(2,teacher.getEmail());
            callableStatement.setString(3,teacher.getDob());
            callableStatement.setString(4,teacher.getAddress());
            callableStatement.setString(5,teacher.getPhone());
            callableStatement.setString(6,teacher.getUserName());
            callableStatement.setString(7,teacher.getPassword());
            callableStatement.registerOutParameter(8, Types.INTEGER);
            callableStatement.executeUpdate();
            teacherid = callableStatement.getInt(8);
            for (int courseid: courseids){
                callableStatement1.setInt(1, teacherid);
                callableStatement1.setInt(2, courseid);
                callableStatement1.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateTeacher(Teacher teacher) {
        String query = "call updateteacher(?, ?, ?, ?, ?, ?);";
        try(Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1,teacher.getId());
            callableStatement.setString(2,teacher.getName());
            callableStatement.setString(3,teacher.getEmail());
            callableStatement.setString(4,teacher.getDob());
            callableStatement.setString(5,teacher.getAddress());
            callableStatement.setString(6,teacher.getPhone());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTeacherById(int id) {
        String query = "call deleteteacher(?);";
        try(Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1,id);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Teacher selectTecherByGradeId(int id) {
        String query = "call selectteacherbygradeid(?);";
        Teacher teacher = null;
        try(Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            if (rs.next()){
                int teacherid = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String dob = rs.getString(4);
                String address = rs.getString(5);
                String phone = rs.getString(6);
                String username = rs.getString(7);
                String password = rs.getString(8);
                List<Course> courses = courseService.selectAllCoursebyTecherId(teacherid);
                teacher = new Teacher(username, password, dob, address, email, phone, id, courses, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }
}
