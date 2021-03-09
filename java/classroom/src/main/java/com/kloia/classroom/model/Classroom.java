package com.kloia.classroom.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "CLASSROOM")
public class Classroom {

    @Id
    private int id;

    @Column
    private String name;

    @Column
    private String code;

    @Column
    private Integer teacherId;
}
