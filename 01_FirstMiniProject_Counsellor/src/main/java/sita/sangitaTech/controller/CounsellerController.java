package sita.sangitaTech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import sita.sangitaTech.DTO.CounsellerLogin;
import sita.sangitaTech.service.CounsellorServiceImpl;

@Controller
public class CounsellerController {

	@Autowired
	private CounsellorServiceImpl counsellorServiceImpl;

	@GetMapping("/")
	public String login(Model model) {
		CounsellerLogin counsellerLogin = new CounsellerLogin();
		model.addAttribute("counsellerLogin", counsellerLogin);
		return "login";
	}

	/*
	 * @PostMapping("/reg") public String registerCounsellerPage(@Valid
	 * CounsellerLogin cslrLogin, BindingResult result, Model model) {
	 * if(result.hasErrors()) { return "register"; }
	 * counsellorServiceImpl.registerCounsellor( CounsellerRegister cslrLogin);
	 * return "register"; }
	 */
}
