package com.cgi.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
import org.springframework.test.context.web.WebAppConfiguration;

import com.cgi.config.ConfigContext;
import com.cgi.config.JpaConfig;
import com.cgi.dao.CategoryDaoImpl;
import com.cgi.dao.IdeaDao;
import com.cgi.dao.IdeaDaoImpl;
import com.cgi.model.Category;
import com.cgi.model.Idea;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigContext.class})
@WebAppConfiguration
@Transactional
public class TestIdeaDaoImpl {

	Idea idea;
	Idea idea1;
	
	@Autowired
	IdeaDao iDao;
	
	
	@Test
	public void testFindAll() {

		assertNotNull(iDao.findAll());
		
		}
	

	@Test
	public void testFindByKey() {
		idea = new Idea();
		iDao.add(idea);
		assertNotNull(iDao.findByKey(1L));
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
		idea1 = iDao.findByKey(1L);
		idea1.setTitle("TitleTest");
		iDao.update(idea1);
		assertTrue(iDao.findByKey(1L).getTitle().equals("TitleTest"));
		
		
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
		iDao.deleteByKey(1L);;
		int sizeAfter = iDao.findAll().size();
		assertTrue(sizeAfter == sizeBefore);
		
		
	}
	
//	@Test
//	public void testFindAllIdeaByCategory() {
//		
// 
//		
//		List<Idea> ideas = iDaoI.findAllIdeaByCategory(1L);
//		
//		org.junit.Assert.assertTrue("fail to get ideas by category key", ideas.size() == 2);
//		
//	}
//	

}
