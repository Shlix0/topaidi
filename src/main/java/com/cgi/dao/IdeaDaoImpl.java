package com.cgi.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cgi.model.Idea;
import com.cgi.model.User;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@Repository
@Transactional
public class IdeaDaoImpl implements IdeaDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public HashSet<Idea> findAll() {
		
		List<Idea> ids =  em.createQuery("from Idea i").getResultList();
		HashSet<Idea> ideas = new HashSet<Idea>(ids);
		return ideas;
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

	
        List<Idea> sorted = ideas.stream().sorted(Comparator
        		.<Idea, Integer>comparing((l1) -> (l1.getUsersVoteTop().size() / (l1.getUsersVoteTop().size() + l1.getUsersVoteFlop().size()))*100)
                .thenComparing((l1) -> l1.getUsersVoteTop().size())
                .thenComparing((l1) -> l1.getCreationDate()))
                .collect(Collectors.toList());
		
		
		Collections.reverse(sorted);
		List<Idea> Top = new ArrayList<Idea>();
		for(int i=0; i<10 ; i++) {
			Top.add(sorted.get(i));
		}
		return Top;

	}

	@Override
	public List<Idea> getBuzzIdeas() {

		List<Idea> ideas = em.createQuery("from Idea i").getResultList();


        List<Idea> sorted = ideas.stream().sorted(Comparator
        		.<Idea, Integer>comparing((l1) -> (l1.getUsersVoteTop().size() + l1.getUsersVoteFlop().size()))
                .thenComparing((l1) -> l1.getCreationDate()))
                .collect(Collectors.toList());
		
		
        
        Collections.reverse(sorted);
		List<Idea> buzz = new ArrayList<Idea>();
		for(int i=0; i<10 ; i++) {
			buzz.add(sorted.get(i));
		}
		
		return buzz;


	}

	@Override
	public List<Idea> getReportedIdeas() {

		List<Idea> ideas = em.createQuery("Select i from Idea i WHERE i.usersReport NOT NULL").getResultList();
		return ideas;
	}

	@Override
	public void addVoteTop(Long idIdea, Long idUser) {
		Idea idea = em.find(Idea.class, idIdea);
		User user = em.find(User.class, idUser);
		
		System.out.println(user.getVoteTop().contains(idea));
		
		Collection<User> usersVoteTop = idea.getUsersVoteTop();
		usersVoteTop.add(user);
		idea.setUsersVoteTop(usersVoteTop);
		em.merge(idea);
		
	}
}
