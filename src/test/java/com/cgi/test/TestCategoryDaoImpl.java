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

import com.cgi.config.ConfigContext;
import com.cgi.dao.CategoryDao;
import com.cgi.dao.CategoryDaoImpl;
import com.cgi.dao.UserDaoImpl;
import com.cgi.model.Category;
import com.cgi.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigContext.class})
@Transactional
public class TestCategoryDaoImpl {

	@Autowired
	CategoryDao cDao;
		
	@Test
	public void testFindAll() {
		
		List<Category> categories = cDao.findAll();
		assertNotNull(categories);
		 
		}
	

	@Test
	public void testFindByKey() {
		Category c = new Category();
		cDao.add(c);
		assertNotNull(cDao.findByKey(1L));
	}

	@Test
	public void testAdd() {
		int sizeBefore = cDao.findAll().size();
		Category cat = new Category();
		cat.setTitle("CategoryTest");
		cDao.add(cat);
		int sizeAfter = cDao.findAll().size();
		assertNotNull(cat.getTitle());
		assertTrue(sizeAfter == sizeBefore+1);
	}

	@Test
	public void testUpdate() {
		
		Category cat = new Category();
		cat.setTitle("CategoryTest");
		cDao.add(cat);
		Category cat2 = cDao.findByKey(1L);
		cat2.setTitle("CategoryModified");
		cDao.update(cat2);
		assertTrue(cDao.findByKey(1L).getTitle().equals("CategoryModified"));
		
	}

	@Test
	public void testDelete() {
		int sizeBefore = cDao.findAll().size();
		Category cat = new Category();
		cDao.add(cat);
		cat = cDao.findByKey(1L);
		cDao.delete(cat);
		int sizeAfter = cDao.findAll().size();
		assertTrue(sizeAfter == sizeBefore);
	}

	@Test
	public void testDeleteByKey() {
		int sizeBefore = cDao.findAll().size();
		Category cat = new Category();
		cDao.add(cat);
		cDao.deleteByKey(1L);
		int sizeAfter = cDao.findAll().size();
		assertTrue(sizeAfter == sizeBefore);
	}

}
