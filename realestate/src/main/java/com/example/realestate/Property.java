package com.example.realestate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Property {
    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;
    private String updatetimestamp;
    private String propertyname;
    private String propertytype;
    private String propertyuse;
    private String businesstype;
    private Double cost;
    private String location;
    private String status;
    private String timestamp;

    public Property() {
    }

    public Property( String propertyname, String propertytype, String propertyuse, String businesstype, Double cost, String location, String status) {

        this.propertyname = propertyname;
        this.propertytype = propertytype;
        this.propertyuse = propertyuse;
        this.businesstype = businesstype;
        this.cost = cost;
        this.location = location;
        this.status = status;

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

    public String getPropertyname() {
        return propertyname;
    }

    public void setPropertyname(String propertyname) {
        this.propertyname = propertyname;
    }

    public String getPropertytype() {
        return propertytype;
    }

    public void setPropertytype(String propertytype) {
        this.propertytype = propertytype;
    }

    public String getPropertyuse() {
        return propertyuse;
    }

    public void setPropertyuse(String propertyuse) {
        this.propertyuse = propertyuse;
    }

    public String getBusinesstype() {
        return businesstype;
    }

    public void setBusinesstype(String businesstype) {
        this.businesstype = businesstype;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
