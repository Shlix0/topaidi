package com.cgi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cgi.model.Comment;

@Repository
@Transactional
public class CommentDaoImpl implements CommentDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Comment> findAll() {
		return em.createQuery("from Comment c").getResultList();
	}

	@Override
	public Comment findByKey(Long id) {
		return em.find(Comment.class, id);
	}

	@Override
	public Comment add(Comment comment) {
		em.persist(comment);
		return comment;
	}

	@Override
	public Comment update(Comment comment) {
		em.merge(comment);
		return comment;
	}

	@Override
	public void delete(Comment comment) {
		Comment eMerged = em.merge(comment);
		em.remove(eMerged);
	}

	@Override
	public void deleteByKey(Long id) {
		Comment comment = em.find(Comment.class, id);
		em.remove(comment);
	}
}
