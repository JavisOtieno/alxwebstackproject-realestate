package com.example.realestate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LoginAttempts {
    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;
    private String timestamp;
    private String phone;
    private String pin;
    private String deviceagentdetails;

    public String getDeviceagentdetails() {
        return deviceagentdetails;
    }

    public void setDeviceagentdetails(String deviceagentdetails) {
        this.deviceagentdetails = deviceagentdetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public LoginAttempts() {
    }

    public LoginAttempts(String phone, String pin, String deviceagentdetails) {
        this.phone = phone;
        this.pin = pin;
        this.deviceagentdetails=deviceagentdetails;
    }
}
