package com.cgi.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cgi.config.ConfigContext;
import com.cgi.dao.LoginDao;
import com.cgi.dao.LoginDaoImpl;
import com.cgi.model.Category;
import com.cgi.model.Idea;
import com.cgi.model.Login;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigContext.class})
@Transactional
public class TestLoginDaoImpl {
	Login log;
	Login log1;
	
	@Autowired
	LoginDao lDao;
	
	@Test
	public void testFindAll() {
		
		assertNotNull(lDao.findAll());
	}

	@Test
	public void testFindByKey() {
		log = new Login();
		lDao.add(log);
		assertNotNull(lDao.findByKey(1L));
	}

	@Test
	public void testAdd() {
		log = new Login();
		int sizeBefore = lDao.findAll().size();
		log.setMail("LogMail");
		lDao.add(log);
		int sizeAfter = lDao.findAll().size();
		assertNotNull(log.getMail());
		assertTrue(sizeAfter == sizeBefore+1);
	}

	@Test
	public void testUpdate() {
		log = new Login();
		log.setMail("LogMail");
		lDao.add(log);
		log1 = lDao.findByKey(1L);
		log1.setMail("MailModify");
		lDao.update(log1);
		assertTrue(lDao.findByKey(1L).getMail().equals("MailModify"));
		
	}

	@Test
	public void testDelete() {
		log = new Login();
		int sizeBefore = lDao.findAll().size();
		lDao.add(log);
		lDao.delete(log);
		int sizeAfter = lDao.findAll().size();
		assertTrue(sizeAfter == sizeBefore);
	}

	@Test
	public void testDeleteByKey() {
		log = new Login();
		int sizeBefore = lDao.findAll().size();
		lDao.add(log);
		lDao.deleteByKey(1L);
		int sizeAfter = lDao.findAll().size();
		assertTrue(sizeAfter == sizeBefore);
	}

}
