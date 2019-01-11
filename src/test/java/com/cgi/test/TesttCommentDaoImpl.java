//package com.cgi.test;
//
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.cgi.dao.CommentDaoImpl;
//import com.cgi.dao.IdeaDaoImpl;
//import com.cgi.model.Category;
//import com.cgi.model.Comment;
//import com.cgi.model.Idea;
//import com.cgi.utils.ContextDB;
//
//public class TesttCommentDaoImpl {
//
//	EntityManagerFactory emf = null;
//	CommentDaoImpl cDaoI = new CommentDaoImpl();
//	Comment com;
//	Comment com1;
//	Comment com2;
//	Comment com3;
//
//	@Before
//	public void init() {
//		ContextDB.stop();
//		EntityManager em = ContextDB.getInstance().getEmf().createEntityManager();
//
//		com1 = new Comment();
//		com2 = new Comment();
//		com3 = new Comment();
//
//		em.getTransaction().begin();
//
//		em.persist(com1);
//		em.persist(com2);
//		em.persist(com3);
//
//		em.getTransaction().commit();
//	}
//
//	@Test
//	public void testFindAll() {
//
//		List<Comment> comments = cDaoI.findAll();;
//
//
//		org.junit.Assert.assertTrue("fail to findAll", comments.size() == 3);
//	}
//
//
//	@Test
//	public void testFindByKey() {
//	com = cDaoI.findByKey(1L);
//	org.junit.Assert.assertTrue("fail to find by key", com != null);
//	}
//
//	@Test
//	public void testAdd() {
//		com = new Comment();
//		int sizeBefore = cDaoI.findAll().size();
//		cDaoI.add(com);
//		int sizeAfter = cDaoI.findAll().size();
//		org.junit.Assert.assertTrue("fail to add a User",sizeAfter == sizeBefore+1);
//	}
//
//	@Test
//	public void testUpdate() {
//		
//		com = cDaoI.findByKey(2L);
//		com.setTitle("testing");
//		cDaoI.update(com);
//		Comment comTest = cDaoI.findByKey(2L);
//		org.junit.Assert.assertTrue("fail to uptade a comment", comTest.getTitle().equals("testing"));
//
//	}
//
//	@Test
//	public void testDelete() {
//		com = cDaoI.findByKey(2L);
//		cDaoI.delete(com);
//		org.junit.Assert.assertTrue("fail to delete", cDaoI.findAll().size() == 2);
//	}
//
//	@Test
//	public void testDeleteByKey() {
//		cDaoI.deleteByKey(2L);
//		org.junit.Assert.assertTrue("fail to delete", cDaoI.findAll().size() == 2);
//	}
//
//}
