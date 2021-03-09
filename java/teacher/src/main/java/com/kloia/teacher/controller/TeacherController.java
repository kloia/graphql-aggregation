package com.kloia.teacher.controller;

import com.kloia.teacher.dto.FindTeacherByIdsDto;
import com.kloia.teacher.exception.TeacherNotFoundException;
import com.kloia.teacher.model.Teacher;
import com.kloia.teacher.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping(value = "/teacher")
    public List<Teacher> retrieveTeachers() {
        return teacherService.getAllTeacher();
    }

    @PostMapping(value = "/teacher")
    public Teacher createTeachers(@RequestBody Teacher teacher) {
        return teacherService.save(teacher);
    }

    @GetMapping(value = "/teacher/{id}")
    public Teacher retrieveTeacher(@PathVariable("id") Integer id) throws TeacherNotFoundException {
        return teacherService.getTeacherById(id);
    }

    @DeleteMapping(value = "/teacher/{id}")
    public Integer deleteTeacher(@PathVariable("id") Integer id){
        teacherService.delete(id);
        return id;
    }

    @PostMapping(value = "/teacher/find-by-ids")
    public List<Teacher> getTeachersByIds(@RequestBody FindTeacherByIdsDto ids) {
        return teacherService.getTeachersByIds(ids);
    }

    @PutMapping(value = "/teacher/{id}")
    public Teacher updateStudent(@RequestBody Teacher teacher, @PathVariable("id") Integer id) throws TeacherNotFoundException {
        return teacherService.update(teacher, id);
    }
}
