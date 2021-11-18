package model;

import java.util.Date;
import java.util.List;

public class Teacher extends User{
    private int id;
    private List<Course> courses;

    public Teacher() {
    }

    public Teacher(String userName, String password, String dob, String address, String email, String phone, int id, List<Course> courses, String name) {
        super(userName, password, dob, address, email, phone, name);
        this.id = id;
        this.courses = courses;
    }

    public Teacher(String userName, String password, String dob, String address, String email, String phone, List<Course> courses, String name) {
        super(userName, password, dob, address, email, phone, name);
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
