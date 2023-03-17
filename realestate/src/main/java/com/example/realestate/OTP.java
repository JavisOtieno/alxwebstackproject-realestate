package com.example.realestate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OTP {

    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;
    private Integer personlogginginid;
    private String mobileno;
    private String codegenerated;
    private String codesentback;
    private String status;

    public OTP() {
    }

    public OTP(Integer personlogginginid, String mobileno, String codegenerated, String codesentback, String status) {
        this.personlogginginid = personlogginginid;
        this.mobileno = mobileno;
        this.codegenerated = codegenerated;
        this.codesentback = codesentback;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonlogginginid() {
        return personlogginginid;
    }

    public void setPersonlogginginid(Integer personlogginginid) {
        this.personlogginginid = personlogginginid;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getCodegenerated() {
        return codegenerated;
    }

    public void setCodegenerated(String codegenerated) {
        this.codegenerated = codegenerated;
    }

    public String getCodesentback() {
        return codesentback;
    }

    public void setCodesentback(String codesentback) {
        this.codesentback = codesentback;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
