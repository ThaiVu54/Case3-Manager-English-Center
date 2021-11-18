package service.courseservice;

import config.ConnectSingleton;
import model.Course;
import model.Teacher;
import service.teacherservice.TeacherSevice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseService implements ICourseService{
    private List<Course> courses;
    private TeacherSevice teacherSevice = new TeacherSevice();

    @Override
    public List<Course> selectAllCoursebyTecherId(int id) {
        courses = new ArrayList<>();
        String query = "call selectallcoursebyteacherid(?);";
        try(Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1,id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                int courseid = rs.getInt(1);
                String name = rs.getString(2);
                List<Teacher> teachers = teacherSevice.selectAllTeacherbyCourseid(courseid);
                courses.add(new Course(courseid, name, teachers));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public List<Course> selectAllCourse() {
        courses = new ArrayList<>();
        String query = "call selectallcourse();";
        try(Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                List<Teacher> teachers = teacherSevice.selectAllTeacherbyCourseid(id);
                courses.add(new Course(id, name, teachers));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public Course selectCourseById(int id) {
        Course course = null;
        String query = "call selectcoursebyid(?);";
        try(Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            if (rs.next()){
                String name = rs.getString(2);
                List<Teacher> teachers = teacherSevice.selectAllTeacherbyCourseid(id);
                course = new Course(id, name, teachers);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    @Override
    public void addCourse(Course course, int[] teacherids) {
        String query1 = "call insertcourse(?, ?);";
        String query2 = "call insertcourse_teacher(?, ?);";
        try(Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement = connection.prepareCall(query1); CallableStatement callableStatement1 = connection.prepareCall(query2)) {
            callableStatement.setString(1, course.getName());
            callableStatement.registerOutParameter(2, Types.INTEGER);
            callableStatement.executeUpdate();
            int courseid = callableStatement.getInt(2);
            for (int teacherid: teacherids){
                callableStatement1.setInt(1, teacherid);
                callableStatement1.setInt(2, courseid);
                callableStatement1.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCourse(Course course) {
        String query = "call updatecourse(?, ?);";
        try(Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, course.getId());
            callableStatement.setString(2, course.getName());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCourse(Course course) {
        String query = "call deletecourse(?);";
        try(Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, course.getId());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Course selectCoursebyIdGrade(int id) {
        Course course = null;
        String query = "call selectcourbyId(?);";
        try(Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {
            ResultSet rs = callableStatement.executeQuery();
            if (rs.next()){
                int courseid = rs.getInt(1);
                String name = rs.getString(2);
                List<Teacher> teacher = teacherSevice.selectAllTeacherbyCourseid(courseid);
                course = new Course(courseid, name, teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }
}
