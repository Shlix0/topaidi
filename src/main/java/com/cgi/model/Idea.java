package com.cgi.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Idea {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String picture;
	private String content;
	private Date creationDate = new Date();
	private LocalDate finishVotableDate;
	private Boolean votable = true;
	private Boolean enable = true;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private User user;
	
	@ManyToMany(mappedBy="ideasReported", fetch=FetchType.EAGER)
	private Set<User> usersReport = new HashSet<User>();
	
	@ManyToMany(mappedBy="voteTop" , fetch=FetchType.EAGER )
	private Set<User> usersVoteTop = new HashSet<User>();
	
	@ManyToMany(mappedBy="voteFlop" , fetch=FetchType.EAGER  )
	private Set<User> usersVoteFlop = new HashSet<User>();
	
	@OneToMany(mappedBy="idea", fetch=FetchType.EAGER)
	private Set<Comment> comments = new HashSet<Comment>(); ;

	public Idea() {
	}

	public Idea(String title, String picture, String content, Category category, User user) {
		super();
		this.title = title;
		this.picture = picture;
		this.content = content;
		this.creationDate = new Date();
		this.finishVotableDate = LocalDate.now().plusDays(7);
		this.votable = true;
		this.enable = true;
		this.category = category;
		this.user = user;
		this.usersReport = new HashSet<User>();
		this.usersVoteTop = new HashSet<User>();
		this.usersVoteFlop = new HashSet<User>();
		this.comments = new HashSet<Comment>();;
	}
	
	public Idea(String title, String picture, String content, Date creationDate, LocalDate finishVotableDate,
			Boolean votable, Boolean enable, Category category, User user) {
		super();
		this.title = title;
		this.picture = picture;
		this.content = content;
		this.creationDate = creationDate;
		this.finishVotableDate = finishVotableDate;
		this.votable = votable;
		this.enable = enable;
		this.category = category;
		this.user = user;
		this.usersReport = new HashSet<User>();
		this.usersVoteTop = new HashSet<User>();
		this.usersVoteFlop = new HashSet<User>();
		this.comments = new HashSet<Comment>();;
	}

	public Idea(Long id, String title, String picture, String content, Date creationDate, LocalDate finishVotableDate,
			Boolean votable, Boolean enable, Category category, User user, Set<User> usersReport,
			Set<User> usersVoteTop, Set<User> usersVoteFlop, Set<Comment> comments) {
		super();
		this.id = id;
		this.title = title;
		this.picture = picture;
		this.content = content;
		this.creationDate = creationDate;
		this.finishVotableDate = finishVotableDate;
		this.votable = votable;
		this.enable = enable;
		this.category = category;
		this.user = user;
		this.usersReport = usersReport;
		this.usersVoteTop = usersVoteTop;
		this.usersVoteFlop = usersVoteFlop;
		this.comments = comments;
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getFinishVotableDate() {
		return finishVotableDate;
	}

	public void setFinishVotableDate(LocalDate finishVotableDate) {
		this.finishVotableDate = finishVotableDate;
	}

	public Boolean getVotable() {
		return votable;
	}

	public void setVotable(Boolean votable) {
		this.votable = votable;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<User> getUsersReport() {
		return usersReport;
	}

	public void setUsersReport(Set<User> usersReport) {
		this.usersReport = usersReport;
	}

	public Collection<User> getUsersVoteTop() {
		return usersVoteTop;
	}

	public void setUsersVoteTop(Set<User> usersVoteTop) {
		this.usersVoteTop = usersVoteTop;
	}

	public Collection<User> getUsersVoteFlop() {
		return usersVoteFlop;
	}

	public void setUsersVoteFlop(Set<User> usersVoteFlop) {
		this.usersVoteFlop = usersVoteFlop;
	}

	public Collection<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	@Override
	public boolean equals(Object obj) {
		Idea idea = (Idea) obj;
		
		if(idea.getId() == this.id) {
			return true;
		}
		return super.equals(obj);
		
	}

	@Override
	public String toString() {
		return "Idea [id=" + id + ", title=" + title + ", picture=" + picture + ", content=" + content
				+ ", creationDate=" + creationDate + ", finishVotableDate=" + finishVotableDate + ", votable=" + votable
				+ ", enable=" + enable + ", category=" + category + ", user=" + user + ", usersReport=" + usersReport
				+ ", usersVoteTop=" + usersVoteTop + ", usersVoteFlop=" + usersVoteFlop + ", comments=" + comments
				+ "]";
	}
	
}