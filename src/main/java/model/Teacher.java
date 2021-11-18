package model;


public class Teacher extends User{
    private int id;

    public Teacher() {
    }

    public Teacher(String userName, String password, String dob, String address, String email, String phone, String name) {
        super(userName, password, dob, address, email, phone, name);
    }

    public Teacher(String userName, String password, String dob, String address, String email, String phone, String name, int id) {
        super(userName, password, dob, address, email, phone, name);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
