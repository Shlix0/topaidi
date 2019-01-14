package com.cgi.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	public List<User> findAll() {
		return em.createQuery("from User u").getResultList();
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
		em.merge(user);
		return user;
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
		List<User> users =  em.createQuery("SELECT u FROM User u ORDER BY size(u.ideas) DESC").getResultList();
		return users;
		
		}

	@Override
	public void addVoteTopToIdea(Long idUser, Long idIdea) {
		User user = em.find(User.class, idUser);
		Idea idea = em.find(Idea.class, idIdea);
		
		Collection<Idea> ideas = user.getVoteTop();
		ideas.add(idea);
		em.merge(user);
		
	}

	@Override
	public void addVoteFlopToIdea(Long idUser,Long idIdea) {
		User user = em.find(User.class, idUser);
		Idea idea = em.find(Idea.class, idIdea);
		Collection<Idea> ideas = user.getVoteFlop();
		ideas.add(idea);
		em.merge(user);
	}
	
}
