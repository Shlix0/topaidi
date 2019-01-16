package com.cgi.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cgi.config.ConfigContext;
import com.cgi.config.JpaConfig;
import com.cgi.dao.IdeaDao;
import com.cgi.dao.LoginDao;
import com.cgi.dao.UserDao;
import com.cgi.model.Idea;
import com.cgi.model.Login;
import com.cgi.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigContext.class})
@WebAppConfiguration
@Transactional
public class TestUserDaoImpl {
	
	@Autowired
	UserDao uDao;
	@Autowired
	IdeaDao iDao;
	@Autowired
	LoginDao lDao;
	
	User user;
	User user1;
	
	
	
	@Test
	public void testFindAll() {
		user = new User();
		uDao.add(user);
		
		assertNotNull(uDao.findAll());
	}

	@Test
	public void testFindByKey() {
		
		user = new User();
		uDao.add(user);
		Long id = user.getId();
		assertNotNull(uDao.findByKey(id));
	}

	@Test
	public void testAdd() {
		
		user = new User();
		int sizeBefore = uDao.findAll().size();
		uDao.add(user);
		int sizeAfter = uDao.findAll().size();
		assertTrue(sizeAfter == sizeBefore+1);
	}

	@Test
	public void testUpdate() {
		
		user = new User();
		user.setFirstName("joe");
		uDao.add(user);
		user1 = uDao.findByKey(user.getId());
		user1.setFirstName("NameModify");
		uDao.update(user1);
		
		assertTrue(uDao.findByKey(user.getId()).getFirstName().equals("NameModify"));
	}

	@Test
	public void testDelete() {
		
		user = new User();
		int sizeBefore = uDao.findAll().size();
		uDao.add(user);
		uDao.delete(user);
		int sizeAfter = uDao.findAll().size();
		assertTrue(sizeAfter == sizeBefore);
	}

	@Test
	public void testDeleteByKey() {
		
		user = new User();
		int sizeBefore = uDao.findAll().size();
		uDao.add(user);
		uDao.deleteByKey(user.getId());
		int sizeAfter = uDao.findAll().size();
		assertTrue(sizeAfter == sizeBefore);
	}
	
	
	@Test
	public void getAllUsersUnactivated() {
		user = new User();
		user1 = new User();
		user.setActivated(false);
		user1.setActivated(false);
		uDao.add(user);
		uDao.add(user1);
		List<User> users = uDao.getAllUsersUnactivated();
		assertTrue(users.size() == 2);
		
	}
	@Test
	public void getBrainUsers() {
		user = new User();
		user.setFirstName("User0");
		user1 = new User();
		user1.setFirstName("User1");
		User user2 = new User();
		user2.setFirstName("User2");
		List<User> users = new ArrayList<User>();
				
		Idea idea = new Idea();
		Idea idea2 = new Idea();
		Idea idea3 = new Idea();
		Idea idea4 = new Idea();
		Idea idea5 = new Idea();
		Idea idea6 = new Idea();
		
		iDao.add(idea);
		iDao.add(idea2);
		iDao.add(idea3);
		iDao.add(idea4);
		iDao.add(idea5);
		iDao.add(idea6);
		
		uDao.add(user);
		uDao.add(user1);
		uDao.add(user2);
		
		Collection<Idea> ideasUser = user.getIdeas();
		Collection<Idea> ideasUser1 = user1.getIdeas();
		Collection<Idea> ideasUser2 = user2.getIdeas();
		
		ideasUser.add(idea);
		ideasUser1.add(idea2);
		ideasUser1.add(idea3);
		ideasUser2.add(idea4);
		ideasUser2.add(idea5);
		ideasUser2.add(idea6);
		
		uDao.update(user);
		uDao.update(user1);
		uDao.update(user2);
		
		users = uDao.getBrainUsers();
		String name = users.get(0).getFirstName();
		
		
		assertTrue(uDao.getBrainUsers().get(0).getIdeas().size() == 3);
		
		
		
	}
	@Test
	public void addVoteTopToIdea() {
		user = new User();
		uDao.add(user);
		Idea idea = new Idea();
		iDao.add(idea);
		int sizeBefore = user.getVoteTop().size();
		uDao.addVoteTopToIdea(user.getId(), idea.getId());
		int sizeAfter = user.getVoteTop().size();
		assertTrue(sizeAfter == sizeBefore+1 );
		
	}
	
	@Test
	public void addVoteFlopToIdea() {
		user = new User();
		uDao.add(user);
		Idea idea = new Idea();
		iDao.add(idea);
		int sizeBefore = user.getVoteFlop().size();
		uDao.addVoteFlopToIdea(user.getId(), idea.getId());
		int sizeAfter = user.getVoteFlop().size();
		assertTrue(sizeAfter == sizeBefore+1 );
	}
	
	@Test
	public void testFindByLogin(){
		
		user = new User();
		Login login = new Login();
		login.setMail("test@test.com");
		login.setPassword("hArdPassword12");
		lDao.add(login);
		user.setLogin(login);
		uDao.add(user);
		Long idUserT = user.getId();
		user1 = uDao.findByLogin("test@test.com", "hArdPassword12") ;
		assertTrue(user1.getId() == idUserT);
		
		
	}
	
	

}
