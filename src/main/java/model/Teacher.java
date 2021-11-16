package model;

import java.util.Date;

public class Teacher extends User{
    private int id;

    public Teacher() {
    }

    public Teacher(String userName, String password, Date dob, String address, String email, String phone) {
        super(userName, password, dob, address, email, phone);
    }

    public Teacher(int id, String userName, String password, Date dob, String address, String email, String phone) {
        super(userName, password, dob, address, email, phone);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
