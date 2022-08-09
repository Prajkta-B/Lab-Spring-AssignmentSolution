package com.greatLearning.Lab6.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatLearning.Lab6.entity.StudentDetails;
import com.greatLearning.Lab6.service.StudentService;

@Controller
@RequestMapping("studentData")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public String listStudents(Model theModel) {
		List<StudentDetails> studentDetails = studentService.findAll();
		theModel.addAttribute("Students", studentDetails);
		return "list-students";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		StudentDetails thestudent = new StudentDetails();
		theModel.addAttribute("StudentDetails", thestudent);
		return "registration-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {

		StudentDetails thestudent = studentService.findById(theId);
		theModel.addAttribute("StudentDetails", thestudent);
		return "registration-form";
	}

	@PostMapping("/save")
	public String saveDetails(@RequestParam("id") int id, @RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("course") String course,
			@RequestParam("country") String country) {

		System.out.println(id);
		StudentDetails thestudent;
		if (id != 0) {
			thestudent = studentService.findById(id);
			thestudent.setFirstname(firstname);
			thestudent.setLastname(lastname);
			thestudent.setCourse(course);
			thestudent.setCountry(country);
		} else
			thestudent = new StudentDetails(firstname, lastname, course, country);
		studentService.save(thestudent);
		return "redirect:/studentData/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {
		studentService.deleteById(theId);
		return "redirect:/studentData/list";
	}

	@RequestMapping("/search")
	public String search(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname, Model theModel) {

		// check names, if both are empty then just give list of all Books

		if (firstname.trim().isEmpty() && lastname.trim().isEmpty()) {
			return "redirect:/studentData/list";
		} else {
			// else, search by first name and last name
			List<StudentDetails> theStudents = studentService.searchBy(firstname, lastname);

			// add to the spring model
			theModel.addAttribute("StudentDetails", theStudents);

			// send to list-Books
			return "list-students";
		}

	}

	@RequestMapping("/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

}
