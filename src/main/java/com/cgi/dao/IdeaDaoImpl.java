package com.cgi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cgi.model.Idea;

@Repository
@Transactional
public class IdeaDaoImpl implements IdeaDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Idea> findAll() {
		return em.createQuery("from Idea i").getResultList();
	}

	@Override
	public Idea findByKey(Long id) {
		return em.find(Idea.class, id);
	}

	@Override
	public void add(Idea idea) {
		em.persist(idea);
	}

	@Override
	public Idea update(Idea idea) {
		em.merge(idea);
		return idea;
	}

	@Override
	public void delete(Idea idea) {
		Idea eMerged = em.merge(idea);
		em.remove(eMerged);
	}

	@Override
	public void deleteByKey(Long id) {
		Idea idea = em.find(Idea.class, id);
		em.remove(idea);
	}

	@Override
	public List<Idea> findAllIdeaByCategory(Long id) {
//		return em.createQuery("SELECT * FROM Idea i WHERE Category").
		return null;
	}
}
