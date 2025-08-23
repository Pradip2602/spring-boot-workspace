package com.code.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
