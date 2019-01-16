package com.cgi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import com.cgi.dao.CategoryDao;
import com.cgi.dao.CommentDao;
import com.cgi.dao.IdeaDao;
import com.cgi.dao.LoginDao;
import com.cgi.dao.RoleDao;
import com.cgi.dao.UserDao;
import com.cgi.model.Comment;
import com.cgi.model.Idea;
import com.cgi.model.Login;
import com.cgi.model.User;

@RequestMapping("/ideas")
@Controller
public class HomeController {

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

	@GetMapping("/home")
	public String home(Model model) {

		List<Idea> ideas = iDao.findAll();
		model.addAttribute("ideaList", ideas);
		List<Comment> comments = coDao.findAll();
		model.addAttribute("commentList", comments);
		model.addAttribute("comment", new Comment());
		model.addAttribute("user", new User());
		model.addAttribute("login", new Login());
		
		return "accueil";
	}

	@GetMapping("/add")
	public String add(Model model) {

		model.addAttribute("idea", new Idea());
		model.addAttribute("comment", new Comment());

		return "addIdea";
	}

	@PostMapping("{idIdea}/addComment")
	public String addComment(@PathVariable(value = "idIdea") Long id,Comment comment, Model model, HttpSession session) {
		
		User user = (User)session.getAttribute("user");
		
		if(user != null && user.getRole().getName().equals("utilisateur")) {
			
			Idea idea = iDao.findByKey(id);
			comment.setIdea(idea);
			coDao.update(comment);
			idea.getComments().add(comment);
			iDao.update(idea);
			model.addAttribute("idea", idea);
			return "redirect:/ideas/home";
		}
		else {
			return "redirect:/ideas/home";
		}
		
	}
	
	@PostMapping("/login")
	public String checkLogin(@ModelAttribute("login") Login login,Model model,HttpSession session) {
		
		User user = uDao.findByLogin(login.getMail(), login.getPassword());
		if (user != null) {
			
			session.setAttribute("user", user);
			return "redirect:/ideas/home";
		}
		else {
			return "accueil";
		}
	}
	
	@GetMapping("/loggout")
	public String loggout(Model model,HttpSession session) {
		session.invalidate();
		return "redirect:/ideas/home";
	}
	
}
