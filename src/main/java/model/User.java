package model;

import java.util.Date;

public abstract class User {
    private String userName;
    private String password;
    private Date dob;
    private String address;
    private String email;
    private String phone;

    public User() {
    }

    public User(String userName, String password, Date dob, String address, String email, String phone) {
        this.userName = userName;
        this.password = password;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}