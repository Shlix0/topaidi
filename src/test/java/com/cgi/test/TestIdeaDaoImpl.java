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
//import com.cgi.dao.CategoryDaoImpl;
//import com.cgi.dao.IdeaDaoImpl;
//import com.cgi.model.Category;
//import com.cgi.model.Idea;
//import com.cgi.utils.ContextDB;
//
//public class TestIdeaDaoImpl {
//
//	EntityManagerFactory emf = null;
//	IdeaDaoImpl iDaoI = new IdeaDaoImpl();
//	CategoryDaoImpl cDaoI = new CategoryDaoImpl();
//	Idea idea;
//	Idea idea1;
//	Idea idea2;
//	Idea idea3;
//	
//	
//	@Before
//	public void init() {
//		ContextDB.stop();
//		EntityManager em = ContextDB.getInstance().getEmf().createEntityManager();
//		
//		idea1 = new Idea();
//		idea2 = new Idea();
//		idea3 = new Idea();
//		Category cat = new Category();
//		idea1.setCategory(cat);
//		idea2.setCategory(cat);
//		
//		em.getTransaction().begin();
//		
//		em.persist(cat);
//		em.persist(idea1);
//		em.persist(idea2);
//		em.persist(idea3);
//		
//		em.getTransaction().commit();
//	}
//	
//	@Test
//	public void testFindAll() {
//
//		 List<Idea> ideas = new ArrayList<Idea>();
//		 
//		 ideas = iDaoI.findAll();
//		 
//		 org.junit.Assert.assertTrue("fail to findAll", ideas.size() == 3);
//		}
//	
//
//	@Test
//	public void testFindByKey() {
//		idea = iDaoI.findByKey(1L);
//		 org.junit.Assert.assertTrue("fail to find by key", idea != null);
//	}
//
//	@Test
//	public void testAdd() {
//		
//		idea = new Idea();
//		int sizeBefore = iDaoI.findAll().size();
//		iDaoI.add(idea);
//		int sizeAfter = iDaoI.findAll().size();
//		
//		 org.junit.Assert.assertTrue("fail to add a User",sizeAfter == sizeBefore+1);
//	}
//
//	@Test
//	public void testUpdate() {
//		
//		idea = iDaoI.findByKey(2L);
//		idea.setTitle("joe");
//		iDaoI.update(idea);
//		Idea ideaT = iDaoI.findByKey(2L);
//		
//		org.junit.Assert.assertTrue("fail to update a User", ideaT.getTitle().equals("joe"));
//	}
//
//	@Test
//	public void testDelete() {
//		
//		idea = iDaoI.findByKey(2L);
//		iDaoI.delete(idea);
//		org.junit.Assert.assertTrue("fail to delete", iDaoI.findAll().size() == 2);
//	}
//
//	@Test
//	public void testDeleteByKey() {
//		
//		iDaoI.deleteByKey(2L);
//		org.junit.Assert.assertTrue("fail to delete by key a User", iDaoI.findAll().size() == 2);
//	}
//	
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
//
//}
