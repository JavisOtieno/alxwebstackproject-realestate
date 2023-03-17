package com.example.realestate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Communications {

    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;
    private String timestamp;
    private String updatetimestamp;
    private Integer senderuserid;
    private String username;
    private String subject;
    private String message;
    private String mode;
    private String mobileno;
    private String email;
    private String status;

    public Communications() {
    }

    public Communications(Integer senderuserid, String username, String subject, String message, String mode, String mobileno, String email, String status) {
        this.senderuserid = senderuserid;
        this.username = username;
        this.subject = subject;
        this.message = message;
        this.mode = mode;
        this.mobileno = mobileno;
        this.email = email;
        this.status = status;
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

    public String getUpdatetimestamp() {
        return updatetimestamp;
    }

    public void setUpdatetimestamp(String updatetimestamp) {
        this.updatetimestamp = updatetimestamp;
    }

    public Integer getSenderuserid() {
        return senderuserid;
    }

    public void setSenderuserid(Integer senderuserid) {
        this.senderuserid = senderuserid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
