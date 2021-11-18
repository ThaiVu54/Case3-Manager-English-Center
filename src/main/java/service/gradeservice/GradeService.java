package service.gradeservice;

import config.ConnectSingleton;
import model.Course;
import model.Grade;
import model.Student;
import model.Teacher;
import service.courseservice.CourseService;
import service.studentService.StudentService;
import service.teacherservice.TeacherSevice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeService implements IGradeService{
    private GradeService(){}
    TeacherSevice teacherSevice = TeacherSevice.getInstance();
    CourseService courseService = CourseService.getInstance();
    StudentService studentService = StudentService.getInstance();

    private static GradeService gradeService = new GradeService();
    public static GradeService getInstance(){
        if (gradeService == null) {
            gradeService = new GradeService();
        }
        return gradeService;
    }
    @Override
    public List<Grade> selectAllGrade() {
        String query = "call selectAllGrade();";
        List<Grade> gradeList = new ArrayList<>();
try(Connection connection = ConnectSingleton.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {
    ResultSet rs = callableStatement.executeQuery(); {
    while (rs.next()) {
        int gradeID = callableStatement.getInt(1);
        String gradeName = callableStatement.getString(2);
        int course_teacherID = callableStatement.getInt(4);
        int courseID = callableStatement.getInt(7);
        String courseName = callableStatement.getString(8);
        int teacherID = callableStatement.getInt(9);
        String teacherName = callableStatement.getString(10);
        String teacherEmail = callableStatement.getString(11);
        String teacerDob = callableStatement.getString(12);
        String teacherAddress = callableStatement.getString(13);
        String teacherPhone  = callableStatement.getString(14);
        String teacherUserName = callableStatement.getString(15);
        String teacherPasswword = callableStatement.getString(16);
        List<Teacher> teacherList = teacherSevice.selectAllTeacherbyCourseid(courseID);
        Course course = new Course(courseID,courseName,teacherList);
        List<Course> courseList = courseService.selectAllCourse();
        Teacher teacher = new Teacher(teacherUserName,teacherPasswword,teacerDob,teacherAddress,teacherEmail,teacherPhone,teacherID,courseList,teacherName);
        List<Student> studentList = studentService.seeAllStudent();
        Grade grade = new Grade(gradeID,gradeName,teacher,course,studentList,);






    }
}
    } catch (SQLException e) {
    e.printStackTrace();
}

        @Override
    public Grade selectGradebyId(int id) {
        return null;
    }

    @Override
    public void addGrade(Grade grade) {

    }

    @Override
    public void updateGrade(Grade grade) {

    }

    @Override
    public void deleteGrade(Grade grade) {

    }
}
