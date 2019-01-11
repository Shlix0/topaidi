//package com.cgi.test;
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
//import com.cgi.dao.UserDaoImpl;
//import com.cgi.model.User;
//import com.cgi.utils.ContextDB;
//
//public class TestUserDaoImpl {
//	EntityManagerFactory emf = null;
//	UserDaoImpl uDaoI = new UserDaoImpl();
//	User user;
//	User user1;
//	User user2;
//	User user3;
//	
//	
//	@Before
//	public void init() {
//		ContextDB.stop();
//		EntityManager em = ContextDB.getInstance().getEmf().createEntityManager();
//		
//		User user1 = new User();
//		User user2 = new User();
//		User user3 = new User();
//		
//		em.getTransaction().begin();
//		
//		em.persist(user1);
//		em.persist(user2);
//		em.persist(user3);
//		
//		em.getTransaction().commit();
//	}
//	
////	@After
////	public void finish() {
////		ContextDB.stop();
////		
////	}
//	
//	
//	@Test
//	public void testFindAll() {
//
//	 List<User> users = new ArrayList<User>();
//	 
//	 users = uDaoI.findAll();
//	 
//	 org.junit.Assert.assertTrue("fail to findAll", users.size() == 3);
//	}
//
//	@Test
//	public void testFindByKey() {
//		
//		user = uDaoI.findByKey(1L);
//		 org.junit.Assert.assertTrue("fail to find by key", user != null);
//	}
//
//	@Test
//	public void testAdd() {
//		
//		user = new User();
//		int sizeBefore = uDaoI.findAll().size();
//		uDaoI.add(user);
//		int sizeAfter = uDaoI.findAll().size();
//		
//		 org.junit.Assert.assertTrue("fail to add a User",sizeAfter == sizeBefore+1);
//	}
//
//	@Test
//	public void testUpdate() {
//		
//		user = uDaoI.findByKey(2L);
//		user.setFirstName("joe");
//		uDaoI.update(user);
//		User userT = uDaoI.findByKey(2L);
//		
//		org.junit.Assert.assertTrue("fail to add a User", userT.getFirstName().equals("joe"));
//		
//	}
//
//	@Test
//	public void testDelete() {
//		
//		user = uDaoI.findByKey(2L);
//		uDaoI.delete(user);
//		org.junit.Assert.assertTrue("fail to delete", uDaoI.findAll().size() == 2);
//	}
//
//	@Test
//	public void testDeleteByKey() {
//		
//		uDaoI.deleteByKey(2L);
//		org.junit.Assert.assertTrue("fail to delete by key a User", uDaoI.findAll().size() == 2);
//	}
//
//}
