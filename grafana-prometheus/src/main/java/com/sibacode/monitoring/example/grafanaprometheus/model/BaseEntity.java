package com.sibacode.monitoring.example.grafanaprometheus.model;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;
//@Data
//@ToString
public class BaseEntity implements Serializable {


    @Id
    private String id;

    @CreatedDate
    private Date createDate;

    @LastModifiedDate
    private Date updatedDate;

    public BaseEntity(){

    }

    public BaseEntity(String id, Date createDate, Date updatedDate) {
        this.id = id;
        this.createDate = createDate;
        this.updatedDate = updatedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id='" + id + '\'' +
                ", createDate=" + createDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
