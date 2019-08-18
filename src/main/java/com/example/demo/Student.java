package com.example.demo;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @CreationTimestamp
    private Calendar applyTime;

    @CreationTimestamp
    private Timestamp applyTimestamp;

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Calendar applyTime) {
        this.applyTime = applyTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getApplyTimestamp() {
        return applyTimestamp;
    }

    public void setApplyTimestamp(Timestamp applyTimestamp) {
        this.applyTimestamp = applyTimestamp;
    }
}
