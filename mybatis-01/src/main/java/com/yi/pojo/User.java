package com.yi.pojo;

public class User {
    private int id;
    private String name;
    private String password;
    private String worktype ;
    private  String state;

    public User() {
    }

    public User(int id, String name, String password, String worktype, String state) {
        this.id = id;
        this.name = name;
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", worktype='" + worktype + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
