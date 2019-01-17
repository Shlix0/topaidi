	package com.cgi.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

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
import com.cgi.user.login.UserLogin;

@RequestMapping("/ideas")
@Controller
@Transactional
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
		Collection<Idea> ideas = new HashSet<Idea>();
		ideas = iDao.findAll();
		model.addAttribute("ideaList", ideas);
		List<Comment> comments = coDao.findAll();
		Collections.reverse(comments);
		model.addAttribute("commentList", comments);
		model.addAttribute("comment", new Comment());
		model.addAttribute("user", new User());
		model.addAttribute("login", new Login());
		model.addAttribute("idea", new Idea());
		model.addAttribute("categoryList", cDao.findAll());
		return "accueil";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("idea", new Idea());
		
		model.addAttribute("categoryList", cDao.findAll());

		return "addIdea";
	}
	
	@PostMapping("/processAdd")
	public String addIdea(@ModelAttribute("idea") Idea idea,
            Model model, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		
		if (user != null && user.getRole().getName().equals("utilisateur") && user.isActivated()) {

			idea.setUser(user);
			iDao.add(idea);
			
			return "redirect:/ideas/home";
		} else {
			return "redirect:/ideas/home";
		}
	}
	
	@PostMapping("{idIdea}/addComment")
	public String addComment(@PathVariable(value = "idIdea") Long id, Comment comment, Model model,
			HttpSession session) {

		User user = (User) session.getAttribute("user");

		if (user != null && user.getRole().getName().equals("utilisateur") && user.isActivated()) {

			Idea idea = iDao.findByKey(id);
			comment.setUser(user);
			comment.setIdea(idea);
			coDao.update(comment);
			idea.getComments().add(comment);
			iDao.update(idea);
			model.addAttribute("idea", idea);
			return "redirect:/ideas/home";
		} else {
			return "redirect:/ideas/home";
		}

	}

	@PostMapping("/login")
	public String checkLogin(@ModelAttribute("login") Login login, Model model, HttpSession session) {

		User user = uDao.findByLogin(login.getMail(), login.getPassword());
		if (user != null) {

			session.setAttribute("user", user);
			return "redirect:/ideas/home";
		} else {
			return "redirect:/ideas/home";
		}
	}

	@GetMapping("/loggout")
	public String loggout(Model model, HttpSession session) {
		session.invalidate();
		return "redirect:/ideas/home";
	}

	@GetMapping("{idIdea}/addVoteTop")
	public String addVoteTopToIdea(@PathVariable(value = "idIdea") Long id, Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		if (user != null && user.getRole().getName().equals("utilisateur")) {

			Idea idea = iDao.findByKey(id);
			User u2 = uDao.update(user);
			Collection<Idea> ideasTop = u2.getVoteTop();
			Collection<Idea> ideasFlop = u2.getVoteFlop();
			Collection<Idea> ideasUser = u2.getIdeas();

			for (Idea iU : ideasUser) {
				if (iU.getId() == idea.getId())
					return "redirect:/ideas/home";
			}
			for (Idea i : ideasTop) {
				if (i.getId() == idea.getId())
					return "redirect:/ideas/home";
			}
			for (Idea i2 : ideasFlop) {
				if (i2.getId() == idea.getId())
					return "redirect:/ideas/home";
			}
			u2.getVoteTop().add(idea);
			uDao.update(u2);

			return "redirect:/ideas/home";
		} else {
			return "redirect:/ideas/home";
		}

	}

	@GetMapping("{idIdea}/addVoteFlop")
	public String addVoteflopToIdea(@PathVariable(value = "idIdea") Long id, Model model, HttpSession session) {

		User user = (User) session.getAttribute("user");
		
		if (user != null && user.getRole().getName().equals("utilisateur")) {

			Idea idea = iDao.findByKey(id);
			User u2 = uDao.update(user);
			Collection<Idea> ideasTop = u2.getVoteTop();
			Collection<Idea> ideasFlop = u2.getVoteFlop();
			Collection<Idea> ideasUser = u2.getIdeas();


			
			for (Idea iU : ideasUser) {
				if (iU.getId() == idea.getId())
					return "redirect:/ideas/home";
			}
			for (Idea i : ideasTop) {

				if (i.getId() == idea.getId())
					return "redirect:/ideas/home";
			}
			for (Idea i2 : ideasFlop) {
				if (i2.getId() == idea.getId())
					return "redirect:/ideas/home";
			}
			u2.getVoteFlop().add(idea);
			uDao.update(u2);

			return "redirect:/ideas/home";

		} else {
			return "redirect:/ideas/home";
		}
	}
	
	@GetMapping("{idIdea}/addReport")
		public String addReportToIdea(@PathVariable(value = "idIdea") Long id, Model model, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		
		if (user != null && user.getRole().getName().equals("utilisateur")) {
			
			User u2 = uDao.update(user);
			Idea idea = iDao.findByKey(id);	
			Collection<Idea> ideasReported = u2.getIdeasReported();
			
//			
//			if(ideasReported.stream()
//					.filter(i -> i.getId() == idea.getId())
//					.findFirst().isPresent()) {
//				System.out.println("YEAH INSIDE ");
//			}
			
			for (Idea i : ideasReported) {
				if (i.getId() == idea.getId())
					return "redirect:/ideas/home";
			}
			
			u2.getIdeasReported().add(idea);
			uDao.update(u2);
				return "redirect:/ideas/home";
			}
		else {
			
			return "redirect:/ideas/home";
		}
	}
}
