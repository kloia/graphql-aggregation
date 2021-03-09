package com.kloia.classroom.converter;

import com.kloia.classroom.model.Classroom;
import org.springframework.stereotype.Component;

@Component
public class ClassroomConverter {

    public Classroom convert(Classroom newClassroom, Classroom classroom) {
        if (newClassroom.getCode() != null) {
            classroom.setName(newClassroom.getCode());
        }
        if (newClassroom.getName() != null) {
            classroom.setName(newClassroom.getName());
        }
        if (newClassroom.getTeacherId() != null) {
            classroom.setTeacherId(newClassroom.getTeacherId());
        }
        return classroom;
    }

}
