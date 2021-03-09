package com.kloia.student.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private Integer age;

    @Column
    private String email;

    @Column
    private Integer classroomId;
}
