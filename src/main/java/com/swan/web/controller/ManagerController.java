package com.swan.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swan.model.Document;
import com.swan.model.DocumentVerify;
import com.swan.model.Student;
import com.swan.model.repo.DocumentRepository;
import com.swan.model.repo.DocumentVerifyRepository;
import com.swan.model.repo.StudentRepository;
import com.swan.utils.GetUserNameUtilis;
import com.swan.utils.WebUtils;

@RequestMapping("/")
@Controller
public class ManagerController {

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private DocumentVerifyRepository documentVerifyRepository;

	@Autowired
	private StudentRepository studentRepository;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {

		final GetUserNameUtilis getUserName = new GetUserNameUtilis();

		final String userName = getUserName.GetUserName();
		if (userName.equals("")) {
			model.addAttribute("loggedIn", "");
		} else {
			model.addAttribute("loggedIn", "You Are Already Logged In!");
		}

		return "loginPage";
	}

	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		return "logoutSuccessfulPage";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			final User loginedUser = (User) ((Authentication) principal).getPrincipal();

			final String userInfo = WebUtils.toString(loginedUser);

			model.addAttribute("userInfo", userInfo);

			final String message = "Hi " + principal.getName() //
					+ "<br> You do not have permission to access this page!";
			model.addAttribute("message", message);

		}

		return "403Page";
	}

	@RequestMapping("/add_student")
	public String addStudent(Model model) {
		try {
			final GetUserNameUtilis getUserName = new GetUserNameUtilis();
			final String userName = getUserName.GetUserName();
			model.addAttribute("userName", userName.toUpperCase());
			final String link = "/add_student";
			model.addAttribute("addStudentLink", link);
			final Student student = new Student();
			model.addAttribute("student", student);

		} catch (final Exception e) {
			return "index";
		}
		return "index";
	}

	@RequestMapping("/add_student_wrong_data")
	public String addStudentWrongData(Model model) {
		try {
			model.addAttribute("errorData", "Please fill all fields");
			final GetUserNameUtilis getUserName = new GetUserNameUtilis();
			final String userName = getUserName.GetUserName();
			model.addAttribute("userName", userName.toUpperCase());
			final String link = "/add_student";
			model.addAttribute("addStudentLink", link);
			final Student student = new Student();
			model.addAttribute("student", student);

		} catch (final Exception e) {
			return "index";
		}
		return "index";
	}

	@RequestMapping("/add_document")
	public String addDocument(Model model) {
		try {
			final GetUserNameUtilis getUserName = new GetUserNameUtilis();
			final String userName = getUserName.GetUserName();
			java.util.logging.Logger.getLogger(AvailableController.class.getName()).log(java.util.logging.Level.SEVERE,
					"11:06:57 ****** " + new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date())
							+ " ****** " + getUserName.GetUserName());
			model.addAttribute("userName", userName.toUpperCase());
			final String link = "/add_document";
			model.addAttribute("addDocumentLink", link);
			final List<String> docNames = documentRepository.findAllNames();
			
			
			java.util.logging.Logger.getLogger(AvailableController.class.getName()).log(java.util.logging.Level.SEVERE,
					"11:06:57 ****** " + new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date())
							+ " ****** " + documentRepository.count());
			
			
			model.addAttribute("documents", docNames);
		} catch (final Exception e) {
			return "index";
		}
		return "index";
	}

	@RequestMapping("/add_document_wrong_name")
	public String addDocumentWrongName(Model model) {
		try {
			model.addAttribute("errorData", "Wrong Student Name");
			final GetUserNameUtilis getUserName = new GetUserNameUtilis();
			final String userName = getUserName.GetUserName();
			model.addAttribute("userName", userName.toUpperCase());
			final String link = "/add_document";
			model.addAttribute("addDocumentLink", link);
			final List<String> docNames = documentRepository.findAllNames();
			model.addAttribute("documents", docNames);
		} catch (final Exception e) {
			return "index";
		}
		return "index";
	}

	@RequestMapping("/add_document_wrong_data")
	public String addDocumentWrongData(Model model) {
		try {
			model.addAttribute("errorData", "Please fill all fields");
			final GetUserNameUtilis getUserName = new GetUserNameUtilis();
			final String userName = getUserName.GetUserName();
			model.addAttribute("userName", userName.toUpperCase());
			final String link = "/add_document";
			model.addAttribute("addDocumentLink", link);
			final List<String> docNames = documentRepository.findAllNames();
			model.addAttribute("documents", docNames);
		} catch (final Exception e) {
			return "index";
		}
		return "index";
	}

	@RequestMapping("/verification_of_document")
	public String proofOfDocument(Model model) {
		try {
			final GetUserNameUtilis getUserName = new GetUserNameUtilis();
			final String userName = getUserName.GetUserName();
			model.addAttribute("userName", userName.toUpperCase());
			final String link = "/verification_of_document_id";
			model.addAttribute("proofOfDocumentLink", link);
		} catch (final Exception e) {
			return "index";
		}
		return "index";
	}

	@RequestMapping("/verification_of_document_id={document}")
	public String proofOfDocumentId(Model model, @ModelAttribute("document") String documentId) {
		try {
			final GetUserNameUtilis getUserName = new GetUserNameUtilis();
			final String userName = getUserName.GetUserName();
			model.addAttribute("userName", userName.toUpperCase());
			final DocumentVerify documentVerify = documentVerifyRepository.findAllByVerifyId(documentId);
			if (documentVerify == null) {
				model.addAttribute("proofOfDocument", "");
			} else {
				final Student student = studentRepository.findByUuid(documentVerify.getStudentId());
				final Document document = documentRepository.findAllByUuid(documentVerify.getDocumentId());
				final String firstName = student.getFirstName();
				final String lastName = student.getLastName();
				final String birthDate = student.getBirthDate();
				final String nationality = student.getNationality();
				final String documentName = document.getName();
				final String paid = documentVerify.getPrice1().toString();
				final String level = documentVerify.getLevel();
				final String result = documentVerify.getTotalResult();
				model.addAttribute("proofOfDocument", "right");
				model.addAttribute("firstName", firstName);
				model.addAttribute("lastName", lastName);
				model.addAttribute("birthDate", birthDate);
				model.addAttribute("nationality", nationality);
				model.addAttribute("documentName", documentName);
				model.addAttribute("paid", paid + " €");
				model.addAttribute("level", level);
				model.addAttribute("result", result);
			}
			final String link = "/verification_of_document_id";
			model.addAttribute("proofOfDocumentIdLink", link);
		} catch (final Exception e) {
			return "index";
		}
		return "index";
	}

	@RequestMapping(value = "/verification_of_document_id", method = RequestMethod.POST)
	public String proofOfDocumentId2(Model model, @ModelAttribute("documentId") String documentId) {
		try {
			final GetUserNameUtilis getUserName = new GetUserNameUtilis();
			final String userName = getUserName.GetUserName();
			model.addAttribute("userName", userName.toUpperCase());

			final DocumentVerify documentVerify = documentVerifyRepository
					.findByVerifyIdAndDeletedNull(documentId.trim());

			if (documentVerify == null) {
				model.addAttribute("proofOfDocument", "");
			} else {
				final Student student = studentRepository.findByUuid(documentVerify.getStudentId());

				final Document document = documentRepository.findAllByUuid(documentVerify.getDocumentId());

				final String firstName = student.getFirstName();
				final String lastName = student.getLastName();
				final String birthDate = student.getBirthDate();
				final String nationality = student.getNationality();
				final String documentName = document.getName();
				final String paid = documentVerify.getPrice1().toString();
				final String level = documentVerify.getLevel();
				final String result = documentVerify.getTotalResult();

				model.addAttribute("proofOfDocument", "right");
				model.addAttribute("firstName", firstName);
				model.addAttribute("lastName", lastName);
				model.addAttribute("birthDate", birthDate);
				model.addAttribute("nationality", nationality);
				model.addAttribute("documentName", documentName);
				model.addAttribute("paid", paid + " €");
				model.addAttribute("level", level);
				model.addAttribute("result", result);
			}
			final String link = "/verification_of_document_id";
			model.addAttribute("proofOfDocumentIdLink", link);
		} catch (final Exception e) {
			return "index";
		}
		return "index";
	}
}
