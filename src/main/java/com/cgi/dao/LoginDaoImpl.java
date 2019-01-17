package com.cgi.dao;

import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cgi.model.Login;

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public HashSet<Login> findAll() {
		List<Login> lgs =  em.createQuery("from Login l").getResultList();
		HashSet<Login> logins = new HashSet<Login>(lgs);
		return logins;
	}

	@Override
	public Login findByKey(Long id) {
		return em.find(Login.class, id);
	}

	@Override
	public Login add(Login login) {
		em.persist(login);	
		return login;
	}

	@Override
	public Login update(Login login) {
		em.merge(login);
		return login;
	}

	@Override
	public void delete(Login login) {
		Login eMerged = em.merge(login);
		em.remove(eMerged);
	}

	@Override
	public void deleteByKey(Long id) {
		Login login = em.find(Login.class, id);
		em.remove(login);
	}

}
