package com.cst.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cst.crud.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long>{

}
