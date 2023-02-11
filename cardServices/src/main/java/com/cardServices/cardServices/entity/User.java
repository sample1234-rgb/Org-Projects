package com.cardServices.cardServices.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name="middle_name",nullable = true)
    private String middleName;
    @Column(name="userName",nullable = false)
    private String userName;
    @Column(name = "Age",nullable = false)
    private Integer age;
    @Column(name="Email",nullable = false)
    private String Email;
    @Column(name="phn",nullable = false)
    private String mobile;
    @Column(name="password",nullable = false)
    private String pass;

    public User() {
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        Email = "";
    }
    public User(String firstName, String lastName, Integer age, String email,String pass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        Email = email;
        this.pass = pass;
    }

    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\"uid\": \"" + uid + "\"" +
                ", \"username\": \"" + userName +"\"" +
                ", \"firstName\": \"" + firstName +"\"" +
                ", \"lastName\": \"" + lastName + "\"" +
                ", \"middleName\": \"" + middleName + "\"" +
                ", \"age\": \"" + age + "\"" +
                ", \"Email\": \"" + Email + "\"" +
                ", \"mobile\": \"" + mobile + "\"" +
                "}\n";
    }
}
