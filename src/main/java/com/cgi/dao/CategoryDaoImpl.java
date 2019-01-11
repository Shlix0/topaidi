package com.cgi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cgi.model.Category;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Category> findAll() {
		return em.createQuery("from Category c").getResultList();
	}

	@Override
	public Category findByKey(Long id) {
		return em.find(Category.class, id);
	}

	@Override
	public Category add(Category category) {
		em.persist(category);
		return category;
	}

	@Override
	public Category update(Category category) {
		em.merge(category);
		return category;
	}

	@Override
	public void delete(Category category) {
		Category eMerged = em.merge(category);
		em.remove(eMerged);
	}

	@Override
	public void deleteByKey(Long id) {
		Category category = em.find(Category.class, id);
		em.remove(category);
	}
}
