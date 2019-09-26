package com.rloayza.classroom.restapi.repository;

import com.rloayza.classroom.restapi.model.Clazz;
import com.rloayza.classroom.restapi.model.Student;
import com.rloayza.classroom.restapi.model.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface StudentClassRepository extends JpaRepository<StudentClass, Integer> {

    List<StudentClass> findByStudentId(Integer studentId);

    @Query("SELECT clazz FROM Clazz clazz INNER JOIN StudentClass studentClass on " +
            "studentClass.classCode = clazz.code " +
            "WHERE studentClass.studentId = :studentId")
    List<Clazz> findStudentClasses(@Param("studentId") Integer studentId);

    @Query("SELECT student FROM Student student INNER JOIN StudentClass studentClass on " +
            "studentClass.studentId = student.studentId " +
            "WHERE studentClass.classCode = :classCode")
    List<Student> findClassStudents(@Param("classCode") UUID classCode);

    List<StudentClass> findByClassCode(UUID clazzCode);
}
