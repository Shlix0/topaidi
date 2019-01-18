package com.cgi.test;

import static org.junit.Assert.*;

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
import com.cgi.dao.CategoryDao;
import com.cgi.model.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigContext.class})
@WebAppConfiguration
@Transactional
public class TestCategoryDaoImpl {

	@Autowired
	CategoryDao cDao;
	
	
	@Test
	public void testFindAll() {
		Collection<Category> categories = cDao.findAll();
		assertNotNull(categories);
		}
	

	@Test
	public void testFindByKey() {
		Category c = new Category("Content", "title");
		cDao.add(c);
		Long id = c.getId();
		c = cDao.findByKey(id);
		assertNotNull(c.getId());
		assertTrue(c.getId() == id);
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
		
		cat.setTitle("CategoryModified");
		cDao.update(cat);
		assertTrue(cDao.findByKey(cat.getId()).getTitle().equals("CategoryModified"));
		
	}

	@Test
	public void testDelete() {
		Category cat = new Category();
		int sizeBefore = cDao.findAll().size();
		cDao.add(cat);
		cDao.delete(cat);
		
		int sizeAfter = cDao.findAll().size();
		assertTrue(sizeAfter == sizeBefore);
	}

	@Test
	public void testDeleteByKey() {
		int sizeBefore = cDao.findAll().size();
		Category cat = new Category();
		cat.setContent("content");
		cDao.add(cat);
		cDao.deleteByKey(cat.getId());
		int sizeAfter = cDao.findAll().size();
		assertTrue(sizeAfter == sizeBefore);
	}

}
