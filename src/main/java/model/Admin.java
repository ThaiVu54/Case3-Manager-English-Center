package model;

import java.util.Date;

public class Admin extends User {
    public Admin(){

    }
    public Admin(String userName, String password, String dob, String address, String email, String phone,String name) {
        super(userName, password, dob, address, email, phone, name);
    }
}
