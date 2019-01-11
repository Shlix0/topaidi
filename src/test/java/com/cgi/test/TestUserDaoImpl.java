package com.cgi.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cgi.config.ConfigContext;
import com.cgi.config.JpaConfig;
import com.cgi.dao.UserDao;
import com.cgi.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigContext.class})
@WebAppConfiguration
@Transactional
public class TestUserDaoImpl {
	
	@Autowired
	UserDao uDao;
	
	
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
		assertNotNull(uDao.findByKey(1L));
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
		user1 = uDao.findByKey(1L);
		user1.setFirstName("NameModify");
		uDao.update(user1);
		
		assertTrue(uDao.findByKey(1L).getFirstName().equals("NameModify"));
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
		uDao.deleteByKey(1L);
		int sizeAfter = uDao.findAll().size();
		assertTrue(sizeAfter == sizeBefore);
	}

}
