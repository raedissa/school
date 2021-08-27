package com.swan.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swan.model.DocumentVerify;
import com.swan.model.Student;
import com.swan.model.repo.DocumentRepository;
import com.swan.model.repo.DocumentVerifyRepository;
import com.swan.model.repo.StudentRepository;
import com.swan.utils.VerfyIdGenerator;

@RequestMapping("/data")
@Controller
public class DataController {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private DocumentVerifyRepository documentVerifyRepository;

	@Autowired
	private DocumentRepository documentRepository;

	@RequestMapping(value = "/add_student", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") @Validated Student student) {
		try {
			student.setActive(true);

			if (student.getFirstName() == "" || student.getLastName() == "" || student.getEmail() == ""
					|| student.getBirthDate() == "" || student.getAddress() == "" || student.getNationality() == ""
					|| student.getTelephoneNumber() == "") {
				return "redirect:/add_student_wrong_data";
			}
			if (studentRepository.findByFirstNameAndLastName(student.getFirstName(), student.getLastName()) == null) {
				studentRepository.save(new Student(student));
			} else
				return "redirect:/add_student_wrong_data";

		} catch (final Exception e) {
			return "redirect:/add_student_wrong_data";
		}

		return "redirect:/addedsuccessfully";
	}

	@RequestMapping(value = "/add_document", method = RequestMethod.POST)
	public String adddocument(@ModelAttribute("selectedOption") String document,
			@ModelAttribute("firstName") String firstName, @ModelAttribute("lastName") String lastName,
			@ModelAttribute("price") String price, @ModelAttribute("result") String result,
			@ModelAttribute("level") String level) {
		try {
			String studentId;
			String verifyId;
			if (level == "" || price == "" || firstName == "" || lastName == "") {
				return "redirect:/add_document_wrong_data";
			}
			final Student student = studentRepository.findByFirstNameAndLastName(firstName, lastName);
			if (student == null) {
				return "redirect:/add_document_wrong_name";
			}

			studentId = student.getUuid();

			final VerfyIdGenerator verfyIdGenerator = new VerfyIdGenerator();
			verifyId = verfyIdGenerator.randomAlphaNumeric(5);
			while (documentVerifyRepository.findByVerifyId(verifyId) != null) {
				verifyId = verfyIdGenerator.randomAlphaNumeric(5);
			}

			final String documentId = documentRepository.findAllByName(document).getUuid();
			documentVerifyRepository.save(new DocumentVerify(documentId, studentId, price, result, level, verifyId));
		} catch (final Exception e) {
			return "redirect:/add_document_wrong_data";
		}

		return "redirect:/addedsuccessfully";
	}
}
