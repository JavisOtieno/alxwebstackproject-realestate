package com.example.realestate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;
    private String mobileno;
    private String email;
    private Integer pin;
    private String firstname;
    private String lastname;
    private String usertype;
    private String smsenabled;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

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

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getSmsenabled() {
        return smsenabled;
    }

    public void setSmsenabled(String smsenabled) {
        this.smsenabled = smsenabled;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




    public User(String mobileno, String email, Integer pin, String firstname, String lastname, String usertype, String smsenabled, String status) {
        this.mobileno = mobileno;
        this.email = email;
        this.pin = pin;
        this.firstname = firstname;
        this.lastname = lastname;
        this.usertype = usertype;
        this.smsenabled = smsenabled;
        this.status = status;
    }

    public User() {
    }
}
