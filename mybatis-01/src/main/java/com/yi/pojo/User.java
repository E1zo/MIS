package com.yi.pojo;

public class User {
    private int id;
    private String username;
    private String password;
    private String worktype ;
    private  String state;

    public User() {
    }

    public User(int id, String name, String password, String worktype, String state) {
        this.id = id;
        this.username = name;
        this.password = password;
        this.worktype = worktype;
        this.state = state;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWorktype() {
        return worktype;
    }

    public void setWorktype(String worktype) {
        this.worktype = worktype;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", password='" + password + '\'' +
                ", worktype='" + worktype + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
