package com.cgi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cgi.dao.CategoryDao;
import com.cgi.dao.CommentDao;
import com.cgi.dao.IdeaDao;
import com.cgi.dao.LoginDao;
import com.cgi.dao.RoleDao;
import com.cgi.dao.UserDao;
import com.cgi.model.Comment;
import com.cgi.model.Idea;

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
		
		return "accueil";
	}

	@GetMapping("/add")
	public String add(Model model) {

		model.addAttribute("idea", new Idea());
		model.addAttribute("comment", new Comment());

		return "addIdea";
	}

	@PostMapping("{idIdea}/addComment")
	public String addComment(@PathVariable(value = "idIdea") Long id,
			@ModelAttribute("comment") Comment comment, Model model) {
		
		Idea idea = iDao.findByKey(id);
		model.addAttribute("idea", idea);
		
		idea.getComments().add(comment);
		iDao.update(idea);
		
		return "accueil";
	}
}
