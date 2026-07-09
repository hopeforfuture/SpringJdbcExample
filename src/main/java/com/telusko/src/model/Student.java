package com.telusko.src.model;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class Student {
    private int id;
    private int rollno;
    private String name;
    private int marks;
}
