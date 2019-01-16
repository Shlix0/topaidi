package com.cgi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cgi.dao.LoginDao;
import com.cgi.dao.UserDao;
import com.cgi.model.Comment;
import com.cgi.model.Idea;
import com.cgi.model.Login;
import com.cgi.model.User;

@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	UserDao uDao;
	@Autowired
	LoginDao lDao;

	@GetMapping("")
	public String home(Model model) {

		List<User> users = uDao.findAll();
		model.addAttribute("userList", users);
		
		List<Login> logins = lDao.findAll();
		model.addAttribute("loginList", logins);

		return "accueil";
	}

	@GetMapping("/add")
	public String add(Model model) {

		model.addAttribute("user", new User());
		model.addAttribute("login", new Login());

		return "inscription";
	}

	@PostMapping("/processForm")
	public String addUser(@ModelAttribute("user") User user,
			              @ModelAttribute("login") Login login, 
			              Model model) {

		uDao.add(user);
		lDao.add(login);
		
		return "redirect:/ideas/home";
	}
}
