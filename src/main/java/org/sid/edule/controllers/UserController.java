package org.sid.edule.controllers;

import org.sid.edule.entities.User;
import org.sid.edule.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute("user") User newUser) {
		userService.addUser(newUser);

		return "signin";
	}

	@GetMapping("/sign")
	public String sign(Model model) {
		System.out.println("I'm inside getmapping");
		model.addAttribute("user", new User());
		return "signin";
	}

	@PostMapping("/sign")
	public String sign(@ModelAttribute("user") User user) {
		if (userService.login(user)) {
			//System.out.println("Login with succes");
			return "index";
		} else {
			//System.out.println("Incorrect email or password");
			return "signin";
		}
	}
}
