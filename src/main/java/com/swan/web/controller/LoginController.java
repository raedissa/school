package com.swan.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.swan.model.repo.DocumentVerifyRepository;
import com.swan.utils.GetUserNameUtilis;

@RequestMapping("/")
@Controller
public class LoginController {
	
	@Autowired
	private DocumentVerifyRepository documentVerifyRepository;

	@RequestMapping(value = "/")
	public String homePage(Model model) {
		final GetUserNameUtilis getUserName = new GetUserNameUtilis();
		final String userName = getUserName.GetUserName();
		model.addAttribute("userName", userName.toUpperCase());
		return "index";
	}

	@RequestMapping(value = "/addedsuccessfully")
	public String homePageAddedSuccessfully(Model model) {
		model.addAttribute("success", "Added Successfully :)");
		final GetUserNameUtilis getUserName = new GetUserNameUtilis();
		final String userName = getUserName.GetUserName();
		model.addAttribute("userName", userName.toUpperCase());
		
		String verifyCode = documentVerifyRepository.findFirst1ByOrderByUpdatedDateDesc().getVerifyId();
		
		java.util.logging.Logger.getLogger(DataController.class.getName()).log(java.util.logging.Level.SEVERE,
				"xxxxxx ****** " + new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date())
						+ " ****** verifyId: " + verifyCode);
		
		
		model.addAttribute("verification_code", verifyCode);
		return "index";
	}

}
