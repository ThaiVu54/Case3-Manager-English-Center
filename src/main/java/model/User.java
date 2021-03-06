package model;

import java.util.Date;

public abstract class User {
    private String userName;
    private String password;
    private String dob;
    private String address;
    private String email;
    private String phone;
    private String name;

    public User() {
    }

    public User(String userName, String password, String dob, String address, String email, String phone, String name) {
        this.userName = userName;
        this.password = password;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.name = name;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
