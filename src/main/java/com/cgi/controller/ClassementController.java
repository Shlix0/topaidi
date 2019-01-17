package com.cgi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cgi.dao.CategoryDao;
import com.cgi.dao.CommentDao;
import com.cgi.dao.IdeaDao;
import com.cgi.dao.LoginDao;
import com.cgi.dao.RoleDao;
import com.cgi.dao.UserDao;
import com.cgi.model.Idea;
import com.cgi.model.Login;
import com.cgi.model.User;

@RequestMapping("/classements")
@Controller
public class ClassementController {

	@Autowired
	CategoryDao cDao;
	@Autowired
	CommentDao coDao;
	@Autowired
	IdeaDao iDao;
	@Autowired
	LoginDao lDao;
	@Autowired
	RoleDao rDao;
	@Autowired
	UserDao uDao;

	@GetMapping("home")
	public String home(Model model) {
		
		model.addAttribute("user", new User());
		model.addAttribute("login", new Login());
		return "accueilClassements";
	}

	@GetMapping("top")
	public String top(Model model) {

		model.addAttribute("user", new User());
		model.addAttribute("login", new Login());
		model.addAttribute("topIdea", iDao.getTopIdeas());
		
		return "classementTop";
	}
	@GetMapping("buzz")
	public String buzz(Model model) {

		model.addAttribute("user", new User());
		model.addAttribute("login", new Login());
		model.addAttribute("buzzIdea", iDao.getBuzzIdeas());
		
		return "classementBuzz";
	}
	@GetMapping("brain")
	public String brain(Model model) {

		model.addAttribute("user", new User());
		model.addAttribute("login", new Login());
		model.addAttribute("brainIdea", uDao.getBrainUsers());
		
		return "classementBrain";
	}


}