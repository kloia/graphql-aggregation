package com.kloia.student.converter;

import com.kloia.student.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {

    public Student convert(Student newStudent, Student student) {
        if (newStudent.getName() != null) {
            student.setName(newStudent.getName());
        }
        if (newStudent.getEmail() != null) {
            student.setEmail(newStudent.getEmail());
        }
        if (newStudent.getClassroomId() != null) {
            student.setClassroomId(newStudent.getClassroomId());
        }
        if (newStudent.getAge() != null) {
            student.setAge(newStudent.getAge());
        }
        return student;
    }

}
