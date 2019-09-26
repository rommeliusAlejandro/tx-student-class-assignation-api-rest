package com.rloayza.classroom.restapi.repository;

import com.rloayza.classroom.restapi.model.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentClassRepository extends JpaRepository<StudentClass, Integer> {
}
