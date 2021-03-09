package com.kloia.classroom.controller;

import com.kloia.classroom.exception.ClassroomNotFoundException;
import com.kloia.classroom.model.Classroom;
import com.kloia.classroom.dto.ClassroomFindByIdsRequestDto;
import com.kloia.classroom.service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClassroomController {

    private final ClassroomService classroomService;

    @GetMapping(value = "/classroom")
    public List<Classroom> getAllClassroom() {
        return classroomService.getAllClassroom();
    }

    @GetMapping(value = "/classroom/{id}")
    public Classroom getClassroom(@PathVariable("id") int id) throws ClassroomNotFoundException {
        return classroomService.getClassroomById(id);
    }

    @DeleteMapping(value = "/classroom/{id}")
    public int deleteClassroom(@PathVariable("id") int id) {
        return classroomService.delete(id);
    }

    @PostMapping(value = "/classroom")
    public Classroom saveClassroom(@RequestBody Classroom classroom) {
        return classroomService.save(classroom);
    }

    @PostMapping(value = "/classroom/find-by-ids")
    public List<Classroom> getAllClassroomByIds(@RequestBody ClassroomFindByIdsRequestDto requestDto) {
        return classroomService.getClassroomByIds(requestDto);
    }

    @PutMapping(value = "/classroom/{id}")
    public Classroom updateClassroom(@RequestBody Classroom classroom, @PathVariable("id") Integer id) throws ClassroomNotFoundException {
        return classroomService.update(classroom, id);
    }

}
