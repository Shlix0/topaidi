package com.cgi.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cgi.config.ConfigContext;
import com.cgi.dao.CommentDao;
import com.cgi.dao.IdeaDao;
import com.cgi.model.Comment;
import com.cgi.model.Idea;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigContext.class})
@WebAppConfiguration
@Transactional
public class TesttCommentDaoImpl {

	@Autowired
	CommentDao cDao;
	
	@Autowired
	IdeaDao iDao;
	
	Comment com;
	Comment com1;


	@Test
	public void testFindAll() {
	
		assertNotNull(cDao.findAll());
	}


	@Test
	public void testFindByKey() {
		com = new Comment();
		cDao.add(com);
		Long id = com.getId();
		assertNotNull(cDao.findByKey(id));
		
	}

	@Test
	public void testAdd() {
		com = new Comment();
		int sizeBefore = cDao.findAll().size();
		cDao.add(com);
		int sizeAfter = cDao.findAll().size();
		org.junit.Assert.assertTrue("fail to add a User",sizeAfter == sizeBefore+1);
	}

	@Test
	public void testUpdate() {
		com = new Comment();
		com.setTitle("testing");
		cDao.add(com);
		com1 = cDao.findByKey(com.getId());
		com1.setTitle("TitleModify");
		cDao.update(com1);
		assertTrue(cDao.findByKey(com.getId()).getTitle().equals("TitleModify"));

	}

	@Test
	public void testDelete() {
		com = new Comment();
		int sizeBefore = cDao.findAll().size();
		cDao.add(com);
		com = cDao.findByKey(com.getId());
		cDao.delete(com);
		int sizeAfter = cDao.findAll().size();
		assertTrue(sizeAfter == sizeBefore);
	}

	@Test
	public void testDeleteByKey() {
		com = new Comment();
		int sizeBefore = cDao.findAll().size();
		cDao.add(com);
		cDao.deleteByKey(com.getId());
		int sizeAfter = cDao.findAll().size();
		assertTrue(sizeAfter == sizeBefore);
	}

	@Test
	public void testFindByIdIdea() {
		com = new Comment();
		com1 = new Comment();
		Idea idea = new Idea();
		com.setIdea(idea);
		com1.setIdea(idea);
		iDao.add(idea);
		cDao.add(com);
		cDao.add(com1);
		
		List<Comment> comments = cDao.findByIdIdea(idea.getId());
		assertTrue(comments.size() == 2);
		
		
		
		
		
	}
}
