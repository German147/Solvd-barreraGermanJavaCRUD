package org.example.entity;

public class UserApp {
    private int id_userApp;
    private String userName;
    private String password;

    public UserApp() {
    }

    public UserApp(int id_userApp) {
        this.id_userApp = id_userApp;
    }

    public UserApp(int id_userApp, String userName, String password) {
        this.id_userApp = id_userApp;
        this.userName = userName;
        this.password = password;
    }

    public UserApp(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public int getId_userApp() {
        return id_userApp;
    }

    public void setId_userApp(int id_userApp) {
        this.id_userApp = id_userApp;
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

    @Override
    public String toString() {
        return "UserApp{" +
                "id_userApp=" + id_userApp +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
