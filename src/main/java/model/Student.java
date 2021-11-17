package model;

import java.util.Date;

public class Student extends User{
    private int id;
    private Grade grade;
    private double mark;

    public Student() {
    }

    public Student(String userName, String password, Date dob, String address, String email, String phone, int id, Grade grade, double mark) {
        super(userName, password, dob, address, email, phone);
        this.id = id;
        this.grade = grade;
        this.mark = mark;
    }

    public Student(String userName, String password, Date dob, String address, String email, String phone, Grade grade, double mark) {
        super(userName, password, dob, address, email, phone);
        this.grade = grade;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
