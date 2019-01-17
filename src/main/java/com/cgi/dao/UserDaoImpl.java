package com.cgi.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.jsp.tagext.TryCatchFinally;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cgi.model.Idea;
import com.cgi.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public HashSet<User> findAll() {
		List<User> us =  em.createQuery("from User u").getResultList();
		HashSet<User> users = new HashSet<User>(us);
		return users;
	}

	@Override
	public User findByKey(Long id) {
		return em.find(User.class, id);
	}

	@Override
	public User add(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User update(User user) {
		return em.merge(user);
	}

	@Override
	public void delete(User user) {
		User eMerged = em.merge(user);
		em.remove(eMerged);
	}

	@Override
	public void deleteByKey(Long id) {
		User user = em.find(User.class, id);
		em.remove(user);
	}


	@Override
	public List<User> getAllUsersUnactivated() {
		List<User> users = new ArrayList<User>();
		users = em.createQuery("SELECT u FROM User u WHERE u.activated = :boolean").setParameter("boolean", false).getResultList();
		return users;
	}

	@Override
	public List<User> getBrainUsers() {
		List<User> users =  em.createQuery("from User u").getResultList();
		
		 List<User> sorted = users.stream().sorted(Comparator
	        		.<User, Integer>comparing((l1) -> (l1.getIdeas().size())))
	                .collect(Collectors.toList());
		 Collections.reverse(sorted);	
		 
			List<User> brain = new ArrayList<User>();
			for(int i=0; i<10 ; i++) {
				brain.add(sorted.get(i));
			}
		return brain;
		
		}

	@Override
	public void addVoteTopToIdea(Long idUser, Long idIdea) {

		
		Idea idea = em.find(Idea.class, idIdea);
		User user = em.find(User.class, idUser);
		Collection<Idea> ideasVotedTop = user.getVoteTop();
		ideasVotedTop.add(idea);
		
		em.merge(idea);
		
	}

	@Override
	public void addVoteFlopToIdea(Long idUser,Long idIdea) {
		User user = em.find(User.class, idUser);
		Idea idea = em.find(Idea.class, idIdea);
		Collection<Idea> ideasFlop = user.getVoteFlop();
		ideasFlop.add(idea);
		em.merge(user);
	}

	@Override
	public User findByLogin(String mail, String password) {
		User user = new User();
		try {
			  user =  (User) em.createQuery("SELECT u FROM User u WHERE u.login.mail = :mail AND u.login.password = :password")
						.setParameter("mail", mail)
						.setParameter("password", password)
						.getSingleResult();
			
		} catch (Exception e) {
			user = null;
		}
		return user;
	}

	@Override
	public User findByIdLogin(Long id) {
		
		User user = (User) em.createQuery("SELECT u FROM User u WHERE u.login.id = :idLogin").setParameter("idLogin", id);
		return user;
	}
	
}
