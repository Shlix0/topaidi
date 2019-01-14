package com.cgi.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
	public Idea add(Idea idea) {
		em.persist(idea);
		return idea;
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
	public List<Idea> findAllIdeaByCategory(Long key) {

		List<Idea> ideas = new ArrayList<Idea>();
		ideas = em.createQuery("SELECT i FROM Idea i WHERE i.category.id = :key").setParameter("key", key)
				.getResultList();
		return ideas;
	}

	@Override
	public List<Idea> getTopIdeas() {
		List<Idea> ideas = em.createQuery("from Idea i").getResultList();

		
		Comparator<Idea> comparator = (o1, o2)-> Integer.compare(o2.getUsersVoteTop().size(),o1.getUsersVoteTop().size());
		
		comparator.thenComparing((o1, o2) -> Integer.compare((o2.getUsersVoteTop().size()/(o2.getUsersVoteTop().size()+o2.getUsersVoteFlop().size()))*100,
																o1.getUsersVoteTop().size()/(o1.getUsersVoteTop().size()+o1.getUsersVoteFlop().size()))*100);
		
		comparator.thenComparing((o1, o2) -> Integer.compare(o2.getUsersVoteTop().size()+o2.getUsersVoteFlop().size(),o1.getUsersVoteTop().size()+o1.getUsersVoteFlop().size()));
		
		comparator.thenComparing((o1, o2) -> o1.getCreationDate().compareTo(o2.getCreationDate()));
		
		ideas.sort(comparator);
		
		return ideas;
											
		
//		List result2 = ideas.stream().sorted( 
//				(o1, o2)-> Integer.compare(o2.getUsersVoteTop().size(),o1.getUsersVoteTop().size();
//				)
//                collect(Collectors.toList());
//		
//		return result2;
	}

	@Override
	public List<Idea> getBuzzIdeas() {

		List<Idea> ideas = em.createQuery("from Idea i").getResultList();

		List result2 = ideas.stream()
				.sorted((o1, o2) -> Integer.compare((o2.getUsersVoteTop().size() + o2.getUsersVoteFlop().size()),
						(o1.getUsersVoteTop().size() + o1.getUsersVoteFlop().size())))
				.collect(Collectors.toList());

		return result2;
	}

	@Override
	public List<Idea> getReportedIdeas() {

		List<Idea> ideas = em.createQuery("from Idea i WHERE i.usersReport NOT NULL").getResultList();
		return ideas;
	}
}
