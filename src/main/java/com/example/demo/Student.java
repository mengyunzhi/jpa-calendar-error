package com.example.demo;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Calendar applyTime;

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
}
