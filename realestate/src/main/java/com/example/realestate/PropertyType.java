package com.example.realestate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PropertyType {

    public PropertyType() {
    }

    public PropertyType(String propertytype, String description) {
        this.propertytype = propertytype;
        this.description = description;
    }

    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;
    private String propertytype;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPropertytype() {
        return propertytype;
    }

    public void setPropertytype(String propertytype) {
        this.propertytype = propertytype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String propertydescription) {
        this.description = propertydescription;
    }




}
