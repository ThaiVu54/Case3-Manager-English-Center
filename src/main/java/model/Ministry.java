package model;

import java.util.Date;

public class Ministry extends User{
    private int id;
    private String name;

    public Ministry(int id) {
        this.id = id;
    }

    public Ministry(String userName, String password, String dob, String address, String email, String phone, int id, String name) {
        super(userName, password, dob, address, email, phone, name);
        this.id = id;
    }

    public Ministry(String userName, String password, String dob, String address, String email, String phone, String name) {
        super(userName, password, dob, address, email, phone, name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
