package model;

//import java.util.Date;
import java.sql.Date;


public class Ministry{
    private int id;
    private String name;

    private String email;
    private String dob;
    private String address;
    private String phone;


    public Ministry() {
    }

    public Ministry(int id, String name, String email, String dob, String address, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
    }
    public Ministry(String name, String email, String dob, String address, String phone) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
