package com.cgi.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Utilisateur")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	private String lastName;
	private Date birthDate;
	private boolean activated;
	
	@OneToOne
	private Login login;
	
	@OneToOne
	private Role role;
	

	@OneToMany(mappedBy="user")
	private Collection<Comment> comments = new HashSet<Comment>();
	
	@ManyToMany
	@JoinTable(name="Users_ReportedComment",
	joinColumns=@JoinColumn(name="User_ID"),
	inverseJoinColumns = @JoinColumn(name="Comment_ID"))
	private Collection<Comment> commentsReported = new HashSet<Comment>();
	
	@OneToMany(mappedBy="user")
	private Collection<Idea> ideas = new HashSet<Idea>();
	
	@ManyToMany
	@JoinTable(name="Users_ReportedIdea",
	joinColumns=@JoinColumn(name="User_ID"),
	inverseJoinColumns = @JoinColumn(name="Idea_ID"))
	private Collection<Idea> ideasReported = new HashSet<Idea>();
	
	@ManyToMany
	@JoinTable(name="Users_VoteTopToIdea",
	joinColumns=@JoinColumn(name="User_ID"),
	inverseJoinColumns = @JoinColumn(name="Idea_ID"))
	private Collection<Idea> voteTop = new HashSet<Idea>();
	
	@ManyToMany
	@JoinTable(name="Users_VoteFlopToIdea",
	joinColumns=@JoinColumn(name="User_ID"),
	inverseJoinColumns = @JoinColumn(name="Idea_ID"))
	private Collection<Idea> voteFlop = new HashSet<Idea>();

	public User() {
	}

	public User(String firstName, String lastName, Date birthDate, boolean activated, Login login, Role role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.activated = activated;
		this.login = login;
		this.role = role;
		this.comments = new HashSet<Comment>();
		this.commentsReported = new HashSet<Comment>();
		this.ideas = new HashSet<Idea>();
		this.ideasReported = new HashSet<Idea>();
		this.voteTop = new HashSet<Idea>();
		this.voteFlop = new HashSet<Idea>();
	}

	public User(Long id, String firstName, String lastName, Date birthDate, boolean activated, Login login, Role role,
			Collection<Comment> comments, Collection<Comment> commentsReported, Collection<Idea> ideas,
			Collection<Idea> ideasReported, Collection<Idea> voteTop, Collection<Idea> voteFlop) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.activated = activated;
		this.login = login;
		this.role = role;
		this.comments = comments;
		this.commentsReported = commentsReported;
		this.ideas = ideas;
		this.ideasReported = ideasReported;
		this.voteTop = voteTop;
		this.voteFlop = voteFlop;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Collection<Comment> getComments() {
		return comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}

	public Collection<Comment> getCommentsReported() {
		return commentsReported;
	}

	public void setCommentsReported(Collection<Comment> commentsReported) {
		this.commentsReported = commentsReported;
	}

	public Collection<Idea> getIdeas() {
		return ideas;
	}

	public void setIdeas(Collection<Idea> ideas) {
		this.ideas = ideas;
	}

	public Collection<Idea> getIdeasReported() {
		return ideasReported;
	}

	public void setIdeasReported(Collection<Idea> ideasReported) {
		this.ideasReported = ideasReported;
	}

	public Collection<Idea> getVoteTop() {
		return voteTop;
	}

	public void setVoteTop(Collection<Idea> voteTop) {
		this.voteTop = voteTop;
	}

	public Collection<Idea> getVoteFlop() {
		return voteFlop;
	}

	public void setVoteFlop(Collection<Idea> voteFlop) {
		this.voteFlop = voteFlop;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", activated=" + activated + ", login=" + login + ", role=" + role + ", comments=" + comments
				+ ", commentsReported=" + commentsReported + ", ideas=" + ideas + ", ideasReported=" + ideasReported
				+ ", voteTop=" + voteTop + ", voteFlop=" + voteFlop + "]";
	}
}
