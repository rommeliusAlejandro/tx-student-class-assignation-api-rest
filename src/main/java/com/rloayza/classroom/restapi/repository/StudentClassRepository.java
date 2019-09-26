package com.rloayza.classroom.restapi.repository;

import com.rloayza.classroom.restapi.model.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentClassRepository extends JpaRepository<StudentClass, Integer> {

    List<StudentClass> findByStudentStudentId(Integer studentId);

    List<StudentClass> findByClazzCode(UUID clazzCode);
}
