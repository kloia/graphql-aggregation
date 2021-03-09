package com.kloia.teacher.service;

import com.kloia.teacher.converter.TeacherConverter;
import com.kloia.teacher.dto.FindTeacherByIdsDto;
import com.kloia.teacher.exception.TeacherNotFoundException;
import com.kloia.teacher.model.Teacher;
import com.kloia.teacher.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherConverter teacherConverter;

    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Integer id) throws TeacherNotFoundException {
        return teacherRepository.findById(id).orElseThrow(() -> new TeacherNotFoundException("Teacher not found"));
    }

    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getTeachersByIds(FindTeacherByIdsDto findTeacherByIdsDto) {
        return teacherRepository.findAllById(findTeacherByIdsDto.getIds());
    }

    public void delete(Integer id) {
        teacherRepository.deleteById(id);
    }


    public Teacher update(Teacher newTeacher, Integer id) throws TeacherNotFoundException {
        Optional<Teacher> opt = teacherRepository.findById(id);
        Teacher teacher = teacherConverter.convert(newTeacher, opt.orElseThrow(() -> new TeacherNotFoundException("Teacher not found")));
        return teacherRepository.save(teacher);
    }
}
