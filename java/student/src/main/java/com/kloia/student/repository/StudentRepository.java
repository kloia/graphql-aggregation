package com.kloia.student.repository;

import com.kloia.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{
    @Query("select s from Student s where s.classroomId IN (:classroomIds)")
    List<Student> findStudentsByClassroomIds(@Param("classroomIds") List<Integer> classroomIds);
}
