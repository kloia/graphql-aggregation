package com.kloia.student.controller;

import java.util.List;

import com.kloia.student.dto.StudentFindByClassroomIdDto;
import com.kloia.student.exception.StudentNotFoundException;
import com.kloia.student.model.Student;
import com.kloia.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/student")
    public List<Student> getAllStudent()
    {
        return studentService.getAllStudent();
    }

    @PostMapping("/student/find-by-classroom-ids")
    public List<Student> getStudentByClassroomIds(@RequestBody StudentFindByClassroomIdDto dto) {
        return studentService.getStudentByClassroomIds(dto);
    }
    
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable("id") int id) throws StudentNotFoundException {
        return studentService.getStudentById(id);
    }
   
    @DeleteMapping("/student/{id}")
    public int deleteStudent(@PathVariable("id") int id) {
        return studentService.delete(id);
    }
   
    @PostMapping("/student")
    private Student saveStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping(value = "/student/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") Integer id) throws StudentNotFoundException {
        return studentService.update(student, id);
    }
}
