package model;

import java.util.Date;

public class Admin extends User {
    public Admin(){

    }
    public Admin(String userName, String password, Date dob, String address, String email, String phone) {
        super(userName, password, dob, address, email, phone);
    }
}
