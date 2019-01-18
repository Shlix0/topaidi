package com.cgi.controller;

import java.util.Collection;
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
import com.cgi.dao.RoleDao;
import com.cgi.dao.UserDao;
import com.cgi.model.Comment;
import com.cgi.model.Idea;
import com.cgi.model.Login;
import com.cgi.model.Role;
import com.cgi.model.User;
import com.cgi.user.login.UserLogin;

@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	RoleDao rDao;
	@Autowired
	UserDao uDao;
	@Autowired
	LoginDao lDao;

	@GetMapping("")
	public String home(Model model) {

		Collection<User> users = uDao.findAll();
		model.addAttribute("userList", users);
		model.addAttribute("user", new User());
		Collection<Login> logins = lDao.findAll();
		model.addAttribute("loginList", logins);
		model.addAttribute("login", new Login());

		model.addAttribute("userLogin", new UserLogin());
		
		return "inscription";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("userLogin", new UserLogin());

		return "inscription";
	}

	@PostMapping("/processForm")
	public String addUser(@ModelAttribute("userLogin") UserLogin userLogin,
			              Model model) {
		
		User u  = userLogin.getUser();
		Login l = userLogin.getLogin();
		Role role = rDao.findByKey(1L);
		u.setRole(role);
		
		lDao.add(l);
		u.setLogin(l);
		uDao.add(u);
		
		uDao.update(u);
		lDao.update(l);
		
		
		return "redirect:/ideas/home";
	}
}
