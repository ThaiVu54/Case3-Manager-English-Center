package model;

import java.util.List;

public class Grade {
    private int id;
    private String name;
    private Teacher teacher;
    private Course course;
    private List<Student> studentList;

    public Grade() {
    }

    public Grade(int id, String name, Teacher teacher, Course course, List<Student> studentList) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.course = course;
        this.studentList = studentList;
    }

    public Grade(String name, Teacher teacher, Course course, List<Student> studentList) {
        this.name = name;
        this.teacher = teacher;
        this.course = course;
        this.studentList = studentList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
