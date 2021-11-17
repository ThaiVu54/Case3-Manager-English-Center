package model;

import java.util.Date;

public class Ministry extends User{
    private int id;

    public Ministry(int id) {
        this.id = id;
    }

    public Ministry(String userName, String password, Date dob, String address, String email, String phone, int id) {
        super(userName, password, dob, address, email, phone);
        this.id = id;
    }

    public Ministry(String userName, String password, Date dob, String address, String email, String phone) {
        super(userName, password, dob, address, email, phone);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
