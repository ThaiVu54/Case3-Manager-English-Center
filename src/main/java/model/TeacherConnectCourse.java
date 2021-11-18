package model;

import service.courseservice.CourseService;
import service.courseservice.ICourseService;
import service.teacherservice.ITeacherService;
import service.teacherservice.TeacherSevice;

public class TeacherConnectCourse {
    private Course course;
    private Teacher teacher;
    private int idCourse;
    private int idTeacher;

    public TeacherConnectCourse() {
    }

    public TeacherConnectCourse(Course course, Teacher teacher) {
        this.course = course;
        this.teacher = teacher;
    }

    public TeacherConnectCourse(int idCourse, int idTeacher) {
        ICourseService courseService = new CourseService();
        ITeacherService teacherService = new TeacherSevice();
        this.idCourse = idCourse;
        this.idTeacher = idTeacher;
        this.teacher = teacherService.selectTecherById(idTeacher);
        this.course = courseService.selectCourseById(idCourse);
    }
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
