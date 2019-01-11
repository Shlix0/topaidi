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
//import com.cgi.dao.UserDaoImpl;
//import com.cgi.model.Category;
//import com.cgi.model.User;
//import com.cgi.utils.ContextDB;
//
//public class TestCategoryDaoImpl {
//
//	EntityManagerFactory emf = null;
//	CategoryDaoImpl cDaoI = new CategoryDaoImpl();
//	Category cat;
//	Category cat1;
//	Category cat2;
//	Category cat3;
//	
//	
//	@Before
//	public void init() {
//		ContextDB.stop();
//		EntityManager em = ContextDB.getInstance().getEmf().createEntityManager();
//		
//		 cat1 = new Category();
//		 cat2 = new Category();
//		 cat3 = new Category();
//		
//		em.getTransaction().begin();
//		
//		em.persist(cat1);
//		em.persist(cat2);
//		em.persist(cat3);
//		
//		em.getTransaction().commit();
//	}
//	
//	@Test
//	public void testFindAll() {
//		
//		 List<Category> categories = new ArrayList<Category>();
//		 
//		 categories = cDaoI.findAll();
//		 
//		 org.junit.Assert.assertTrue("fail to findAll", categories.size() == 3);
//		}
//	
//
//	@Test
//	public void testFindByKey() {
//		cat = cDaoI.findByKey(1L);
//		 org.junit.Assert.assertTrue("fail to find by key", cat != null);
//	}
//
//	@Test
//	public void testAdd() {
//		
//		cat = new Category();
//		int sizeBefore = cDaoI.findAll().size();
//		cDaoI.add(cat);
//		int sizeAfter = cDaoI.findAll().size();
//		
//		 org.junit.Assert.assertTrue("fail to add a User",sizeAfter == sizeBefore+1);
//	}
//
//	@Test
//	public void testUpdate() {
//		
//		cat = cDaoI.findByKey(2L);
//		cat.setTitle("joe");
//		cDaoI.update(cat);
//		Category catTemp = cDaoI.findByKey(2L);
//		
//		org.junit.Assert.assertTrue("fail to add a User", catTemp.getTitle().equals("joe"));
//		
//	}
//
//	@Test
//	public void testDelete() {
//		
//		cat = cDaoI.findByKey(2L);
//		cDaoI.delete(cat);
//		org.junit.Assert.assertTrue("fail to delete", cDaoI.findAll().size() == 2);
//	}
//
//	@Test
//	public void testDeleteByKey() {
//		
//		cDaoI.deleteByKey(2L);
//		org.junit.Assert.assertTrue("fail to delete by key a User", cDaoI.findAll().size() == 2);
//	}
//
//}
