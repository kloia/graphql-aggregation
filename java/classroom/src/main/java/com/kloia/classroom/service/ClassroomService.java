package com.kloia.classroom.service;

import com.kloia.classroom.converter.ClassroomConverter;
import com.kloia.classroom.exception.ClassroomNotFoundException;
import com.kloia.classroom.model.Classroom;
import com.kloia.classroom.dto.ClassroomFindByIdsRequestDto;
import com.kloia.classroom.repository.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassroomService {

    private final ClassroomRepository classroomRepository;
    private final ClassroomConverter classroomConverter;

    public List<Classroom> getAllClassroom() {

        return classroomRepository.findAll();
    }

    public List<Classroom> getClassroomByIds( ClassroomFindByIdsRequestDto requestDto) {
        return classroomRepository.findAllById(requestDto.getIds());
    }

    public Classroom getClassroomById(int id) throws ClassroomNotFoundException {

        return classroomRepository.findById(id).orElseThrow(() -> new ClassroomNotFoundException("Classroom not found"));
    }

    public int delete(int id) {
        classroomRepository.deleteById(id);
        return id;
    }

    public Classroom save(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public Classroom update(Classroom newClassroom, Integer id) throws ClassroomNotFoundException {
        Optional<Classroom> opt = classroomRepository.findById(id);
        Classroom classroom = classroomConverter.convert(newClassroom, opt.orElseThrow(() -> new ClassroomNotFoundException("")));
        return classroomRepository.save(classroom);
    }
}
