package model;

public class MinistryAccout  {
    private String userName;
    private String password;
    private int ministryId;

    public MinistryAccout() {
    }

    public MinistryAccout(String userName, String password, int ministryId) {
        this.userName = userName;
        this.password = password;
        this.ministryId = ministryId;
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

    public int getMinistryId() {
        return ministryId;
    }

    public void setMinistryId(int ministryId) {
        this.ministryId = ministryId;
    }
}
