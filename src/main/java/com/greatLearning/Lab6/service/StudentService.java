package com.greatLearning.Lab6.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatLearning.Lab6.entity.StudentDetails;

@Service
public interface StudentService {

	public List<StudentDetails> findAll();
	public StudentDetails findById(int theId);
	public void save(StudentDetails theStudent);
	public void deleteById(int theId);
	public List<StudentDetails> searchBy(String firstname,String lastname,String course, String country);
	
}
