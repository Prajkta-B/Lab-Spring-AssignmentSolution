package com.greatLearning.Lab6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatLearning.Lab6.entity.StudentDetails;

public interface StudentRepository extends JpaRepository<StudentDetails, Integer> {

	List<StudentDetails> findByFirstnameContainsAndLastnameContainsAllIgnoreCase(String firstname, String lastname);
}
