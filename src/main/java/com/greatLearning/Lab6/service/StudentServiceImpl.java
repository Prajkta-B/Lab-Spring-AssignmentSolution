/**
 * 
 */
package com.greatLearning.Lab6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatLearning.Lab6.entity.StudentDetails;
import com.greatLearning.Lab6.repository.StudentRepository;

/**
 * @author User
 *
 */

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	//@Override
	public List<StudentDetails> findAll() {
		// TODO Auto-generated method stub
		List<StudentDetails> students = studentRepository.findAll();
		return students;
	}

	@Override
	public StudentDetails findById(int theId) {
		// TODO Auto-generated method stub
		return studentRepository.findById(theId).get();
	}

	@Override
	public void save(StudentDetails theStudent) {
		// TODO Auto-generated method stub
		studentRepository.save(theStudent);

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(theId);
	}

	@Override
	public List<StudentDetails> searchBy(String firstname, String lastname,String course, String country) {
		// TODO Auto-generated method stub
		List<StudentDetails> students = studentRepository.findByFirstnameContainsAndLastnameContainsAndCourseContainsAndCountryContains(firstname, lastname,course, country);
		return students;
	}

}
