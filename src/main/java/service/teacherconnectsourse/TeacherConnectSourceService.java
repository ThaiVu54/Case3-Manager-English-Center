package service.teacherconnectsourse;

import config.ConnectSingleton;
import model.Course;
import model.Teacher;
import model.TeacherConnectCourse;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherConnectSourceService implements ITeacherConnectSourceService{
    private List<TeacherConnectCourse> teacherConnectCourse;
    private Connection connection = ConnectSingleton.getConnection();
    private static TeacherConnectSourceService teacherConnectSourceService;
    public static TeacherConnectSourceService getTeacherConnectSourceService(){
        if (teacherConnectSourceService == null){
            teacherConnectSourceService = new TeacherConnectSourceService();
        }
        return teacherConnectSourceService;
    }
    @Override
    public List<TeacherConnectCourse> selectAllTeacherConnectSource() {
        teacherConnectCourse = new ArrayList<>();
        String query = "call selectcourse_teacher();";
        try(CallableStatement callableStatement = connection.prepareCall(query)) {
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                int courseid = rs.getInt(2);
                int teacherid = rs.getInt(3);
                teacherConnectCourse.add(new TeacherConnectCourse(courseid, teacherid));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacherConnectCourse;
    }

    @Override
    public List<Teacher> selectAllTeacherByCourseId(int id) {
        List<Teacher> teachers = new ArrayList<>();
        String query = "call selectallteacherbycourseid(?);";
        try(CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1,id);
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
                teachers.add(new Teacher(username, password, dob, address, email, phone, name, id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    @Override
    public List<Course> selectAllCourseByTeacherId(int id) {
        List<Course> courses = new ArrayList<>();
        String query = "call selectallcoursebyteacherid(?);";
        try(CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                int courseid = rs.getInt(1);
                String name = rs.getString(2);
                courses.add(new Course(courseid, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
