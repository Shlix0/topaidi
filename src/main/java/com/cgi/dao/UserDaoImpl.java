package com.cgi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

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
}
