package com.kloia.student.service;

import java.util.List;
import java.util.Optional;

import com.kloia.student.converter.StudentConverter;
import com.kloia.student.dto.StudentFindByClassroomIdDto;
import com.kloia.student.exception.StudentNotFoundException;
import com.kloia.student.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.kloia.student.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentConverter studentConverter;

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) throws StudentNotFoundException {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

    public List<Student> getStudentByClassroomIds(StudentFindByClassroomIdDto dto) {
        return studentRepository.findStudentsByClassroomIds(dto.getClassroomIds());
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public int delete(int id) {
        studentRepository.deleteById(id);
        return id;
    }

    public Student update(Student newStudent, Integer id) throws StudentNotFoundException {
        Optional<Student> opt = studentRepository.findById(id);
        Student student = studentConverter.convert(newStudent,
                opt.orElseThrow(() -> new StudentNotFoundException("Stundet not found")));
        return studentRepository.save(student);
    }
}
