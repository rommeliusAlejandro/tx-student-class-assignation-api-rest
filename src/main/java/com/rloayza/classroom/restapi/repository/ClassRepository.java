package com.rloayza.classroom.restapi.repository;

import com.rloayza.classroom.restapi.model.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface ClassRepository extends JpaRepository<Clazz, UUID>, JpaSpecificationExecutor<Clazz> {

}
