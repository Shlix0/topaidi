package com.cgi.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String content;
	
	@ManyToOne
	private Idea idea;
	
	@ManyToOne
	private User user;
	
	@ManyToMany(mappedBy="commentsReported")
	private Collection<User> usersReports = new HashSet<User>();

	public Comment() {
	}

	public Comment(String title, String content, Idea idea, User user) {
		this.title = title;
		this.content = content;
		this.idea = idea;
		this.user = user;
		this.usersReports = new HashSet<User>();
	}

	public Comment(Long id, String title, String content, Idea idea, User user, Collection<User> usersReports) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.idea = idea;
		this.user = user;
		this.usersReports = usersReports;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<User> getUsersReports() {
		return usersReports;
	}

	public void setUsersReports(Collection<User> usersReports) {
		this.usersReports = usersReports;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", title=" + title + ", content=" + content + ", idea=" + idea + ", user=" + user
				+ ", usersReports=" + usersReports + "]";
	}
}
