package com.rloayza.classroom.restapi.repository;

import com.rloayza.classroom.restapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
