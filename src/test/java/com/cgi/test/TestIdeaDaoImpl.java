package com.cgi.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cgi.config.ConfigContext;
import com.cgi.config.JpaConfig;
import com.cgi.dao.CategoryDao;
import com.cgi.dao.CategoryDaoImpl;
import com.cgi.dao.IdeaDao;
import com.cgi.dao.IdeaDaoImpl;
import com.cgi.dao.UserDao;
import com.cgi.model.Category;
import com.cgi.model.Idea;
import com.cgi.model.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigContext.class})
@WebAppConfiguration
@Transactional
public class TestIdeaDaoImpl {

	Idea idea;
	Idea idea1;
	
	@Autowired
	IdeaDao iDao;
	
	@Autowired
	CategoryDao cDao;
	
	@Autowired
	UserDao uDao;
	
	@Test
	public void testFindAll() {

		assertNotNull(iDao.findAll());
		
		}
	

	@Test
	public void testFindByKey() {
		idea = new Idea();
		iDao.add(idea);
		Long id = idea.getId();
		assertNotNull(iDao.findByKey(id));
	}

	@Test
	public void testAdd() {
		
		idea = new Idea();
		int sizeBefore = iDao.findAll().size();
		idea.setTitle("TitleTest");
		iDao.add(idea);
		int sizeAfter = iDao.findAll().size();
		assertNotNull(idea.getTitle());
		assertTrue(sizeAfter == sizeBefore+1);
		
	}

	@Test
	public void testUpdate() {
		idea = new Idea();
		idea.setTitle("TitleInit");
		iDao.add(idea);
		idea1 = iDao.findByKey(idea.getId());
		idea1.setTitle("TitleTest");
		iDao.update(idea1);
		assertTrue(iDao.findByKey(idea.getId()).getTitle().equals("TitleTest"));
		
		
	}

	@Test
	public void testDelete() {
		
		idea = new Idea();
		int sizeBefore = iDao.findAll().size();
		idea.setTitle("TitleTest");
		iDao.add(idea);
		iDao.delete(idea);
		int sizeAfter = iDao.findAll().size();
		assertTrue(sizeAfter == sizeBefore);
	}

	@Test
	public void testDeleteByKey() {
		
		idea = new Idea();
		int sizeBefore = iDao.findAll().size();
		idea.setTitle("TitleTest");
		iDao.add(idea);
		iDao.deleteByKey(idea.getId());;
		int sizeAfter = iDao.findAll().size();
		assertTrue(sizeAfter == sizeBefore);
		
		
	}
	
	@Test
	public void testFindAllIdeaByCategory() {
		
		Category c = new Category();
		idea = new Idea();
		idea.setCategory(c);
		cDao.add(c);
		iDao.add(idea);
		Long idCategory = c.getId();
		
		List<Idea> ideas = iDao.findAllIdeaByCategory(idCategory);
		assertTrue(ideas.size()== 1);	
		
	}
	
	@Test
	public void testGetTopIdeas() {
		
		idea = new Idea();
		idea1 = new Idea(); // 1
		Idea idea2 = new Idea(); // 1
		
		Collection<User> userVoteTopIdea0 = idea.getUsersVoteTop();
		Collection<User> userVoteTopIdea1 = idea1.getUsersVoteTop();
		Collection<User> userVoteTopIdea2 = idea2.getUsersVoteTop();
		
		User user = new User();
		uDao.add(user);
		userVoteTopIdea0.add(user);
		userVoteTopIdea2.add(user);
		
		User user1 = new User();
		uDao.add(user1);
		userVoteTopIdea2.add(user1);
		userVoteTopIdea1.add(user1);
		
		User user2 = new User();
		uDao.add(user2);
		userVoteTopIdea2.add(user2);
		userVoteTopIdea1.add(user1);
		
		idea.setUsersVoteTop(userVoteTopIdea0);
		idea1.setUsersVoteTop(userVoteTopIdea1);
		idea2.setUsersVoteTop(userVoteTopIdea2);
		
		iDao.add(idea);
		iDao.add(idea1);
		iDao.add(idea2);
		
		
		List<Idea> ideasTop = iDao.getTopIdeas();
		
		assertTrue(ideasTop.get(0).getUsersVoteTop().size() == 3);
		
	}
	@Test
	public void testGetBuzzIdeas() {
		idea = new Idea();
		idea1 = new Idea(); 
		Idea idea2 = new Idea(); 
		
		Collection<User> userVoteTopIdea0 = idea.getUsersVoteTop();
		Collection<User> userVoteTopIdea1 = idea1.getUsersVoteTop();
		Collection<User> userVoteTopIdea2 = idea2.getUsersVoteTop();
		
		Collection<User> userVoteFlopIdea0 = idea.getUsersVoteFlop();
		Collection<User> userVoteFlopIdea1 = idea1.getUsersVoteFlop();
		Collection<User> userVoteFlopIdea2 = idea2.getUsersVoteFlop();
		
		User user = new User();
		uDao.add(user);
		userVoteTopIdea0.add(user);
		userVoteTopIdea2.add(user);
		
		User user1 = new User();
		uDao.add(user1);
		userVoteTopIdea2.add(user1);
		userVoteTopIdea1.add(user1);
		
		User user2 = new User();
		uDao.add(user2);
		userVoteTopIdea2.add(user2);
		userVoteTopIdea1.add(user1);
		
		User user3 = new User();
		userVoteFlopIdea1.add(user3);
		
		User user4 = new User();
		userVoteFlopIdea1.add(user4);
		
		idea.setUsersVoteTop(userVoteTopIdea0);
		idea1.setUsersVoteTop(userVoteTopIdea1);
		idea2.setUsersVoteTop(userVoteTopIdea2);
		
		idea.setUsersVoteFlop(userVoteFlopIdea0);
		idea1.setUsersVoteFlop(userVoteFlopIdea1);
		idea2.setUsersVoteFlop(userVoteFlopIdea2);
		
		
		iDao.add(idea);
		iDao.add(idea1);
		iDao.add(idea2);
		Long idIdeaTopBuzz = idea1.getId();
		
		assertTrue(iDao.getBuzzIdeas().get(0).getId() == idIdeaTopBuzz);
	}
	@Test
	public void testGetReportedIdeas() {
		
	}

}

