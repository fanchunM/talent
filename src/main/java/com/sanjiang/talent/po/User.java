package com.sanjiang.talent.po;


public class User {

    private String Id;

    private String name;

    private String gender;

    private String password;

    /**
     * true:学生， false:教师
     */
    private boolean isStudent;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }
}
