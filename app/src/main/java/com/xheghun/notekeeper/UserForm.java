package com.xheghun.notekeeper;

public class UserForm {
    private String firstname;
    private String lastname;
    private String username;
    private int age;

    private static UserForm userFormInstance = null;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    private void setSampleUser() {
        setFirstname("Xheghun");
        setLastname("Rufai");
        setUsername("xheghun");
        setAge(18);
    }

    public static UserForm getInstance() {
        if (userFormInstance == null) {
            userFormInstance = new UserForm();
            userFormInstance.setSampleUser();
        }
        return userFormInstance;
    }
}
