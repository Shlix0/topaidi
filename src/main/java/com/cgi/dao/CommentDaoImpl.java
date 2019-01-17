package com.cgi.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cgi.model.Comment;
import com.cgi.model.Idea;

@Repository
@Transactional
public class CommentDaoImpl implements CommentDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public HashSet<Comment> findAll() {
		List<Comment> cmts =  em.createQuery("from Comment c").getResultList();
		HashSet<Comment> comments = new HashSet<Comment>(cmts);
		return comments;
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

	@Override
	public List<Comment> findByIdIdea(Long id) {

		List<Comment> comments = new ArrayList<Comment>();
		comments = em.createQuery("SELECT c FROM Comment c WHERE c.idea.id = :key").setParameter("key", id)
				.getResultList();
		return comments;
	}
}
