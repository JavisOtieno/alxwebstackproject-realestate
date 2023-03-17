package com.example.realestate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PropertyUse {

    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;

    private String propertyuse;
    private String description;


    public String getPropertyuse() {
        return propertyuse;
    }

    public PropertyUse() {
    }

    public PropertyUse(String propertyuse, String propertydescription) {
        this.propertyuse = propertyuse;
        this.description = propertydescription;
    }

    public void setPropertyuse(String propertyuse) {
        this.propertyuse = propertyuse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
