package com.xheghun.notekeeper;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class UserFormTest {
    static UserForm userForm;


    @BeforeClass
    public static void T() {
        userForm = UserForm.getInstance();
    }

    @Test
    public void testUser() {
        String firstname = "Shammah";
        String lastname = "Omoniyi";
        String username = "BoazFist";
        int age = 19;

        userForm.setFirstname(firstname);
        userForm.setLastname(lastname);
        userForm.setUsername(username);
        userForm.setAge(age);

        assertEquals(firstname, userForm.getFirstname());
        assertEquals(lastname, userForm.getLastname());
        assertEquals(username, userForm.getUsername());
        assertEquals(age, userForm.getAge());
    }

    @Test
    public void OneTime() {
        String firstname = "Xheghun";
        String lastname = "Rufai";
        String username = "xheghun";
        int age = 18;

        assertEquals(firstname, userForm.getFirstname());
        assertEquals(lastname, userForm.getLastname());
        assertEquals(username, userForm.getUsername());
        assertEquals(age, userForm.getAge());
    }
}