package com.cgi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cgi.dao.CategoryDao;
import com.cgi.dao.CommentDao;
import com.cgi.dao.IdeaDao;
import com.cgi.dao.LoginDao;
import com.cgi.dao.RoleDao;
import com.cgi.dao.UserDao;
import com.cgi.model.Category;
import com.cgi.model.Login;
import com.cgi.model.User;

@RequestMapping("/admin")
@Controller
public class AdminController {

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
	public String home(Model model, HttpSession session) {

		User user = (User) session.getAttribute("user");

//		if (user != null && user.getRole().getName().equals("administrateur")) {

			model.addAttribute("user", new User());
			model.addAttribute("login", new Login());
			model.addAttribute("category", new Category());
			model.addAttribute("inactivateUser", uDao.getAllUsersUnactivated());
			model.addAttribute("signaledIdea", iDao.getReportedIdeas());
			
			return "pageAdmin";

//		} else {
//			return "redirect:/ideas/home";
//		}
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("login", new Login());

		return "pageAdmin";
	}

	@PostMapping("/processAdd")
	public String addCategory(@ModelAttribute("category") Category category, Model model, HttpSession session) {

//		User user = (User) session.getAttribute("user");
//
//		if (user != null && user.getRole().getName().equals("administrateur")) {

		cDao.add(category);

			return "redirect:/admin/home";
//		} else {
//			return "redirect:/ideas/home";
//		}
	}
	
	@PostMapping("{idUser}/processActivated")
	public String activateUser (@PathVariable(value = "idUser") Long idUser, Model model, HttpSession session) {

		User user = uDao.findByKey(idUser);
//		if (user != null && user.getRole().getName().equals("administrateur")) {

		user.setActivated(true);
		uDao.update(user);
		
			return "redirect:/admin/home";
//		} else {
//			return "redirect:/ideas/home";
//		}
	}
}
