//package com.cgi.test;
//
//import static org.junit.Assert.*;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.cgi.dao.LoginDaoImpl;
//import com.cgi.model.Category;
//import com.cgi.model.Idea;
//import com.cgi.model.Login;
//import com.cgi.utils.ContextDB;
//
//public class TestLoginDaoImpl {
//	EntityManagerFactory emf = null;
//	LoginDaoImpl lDaoImpl = new LoginDaoImpl();
//	Login log;
//	Login log1;
//	Login log2;
//	Login log3;
//	
//	@Before
//	public void init() {
//		ContextDB.stop();
//		EntityManager em = ContextDB.getInstance().getEmf().createEntityManager();
//		
//		log1 = new Login();
//		log2 = new Login();
//		log3 = new Login();
//		
//		
//		em.getTransaction().begin();
//		
//		em.persist(log1);
//		em.persist(log2);
//		em.persist(log3);
//		
//		em.getTransaction().commit();
//	}
//	
//	@Test
//	public void testFindAll() {
//		
//		List<Login> logs = lDaoImpl.findAll();
//		
//		org.junit.Assert.assertTrue("fail to findAll", logs.size() == 3);
//	}
//
//	@Test
//	public void testFindByKey() {
//		log = lDaoImpl.findByKey(1L);
//		org.junit.Assert.assertTrue("fail to find by key", log != null);
//	}
//
//	@Test
//	public void testAdd() {
//		log = new Login();
//		int sizeBefore = lDaoImpl.findAll().size();
//		lDaoImpl.add(log);
//		int sizeAfter = lDaoImpl.findAll().size();
//		org.junit.Assert.assertTrue("fail to add a Login",sizeAfter == sizeBefore+1);
//	}
//
//	@Test
//	public void testUpdate() {
//		log  = lDaoImpl.findByKey(2L);
//		log.setMail("test");
//		lDaoImpl.update(log);
//		
//		Login logTest = lDaoImpl.findByKey(2L);
//		org.junit.Assert.assertTrue("fail to update a User", logTest.getMail().equals("test"));
//	}
//
//	@Test
//	public void testDelete() {
//		log = lDaoImpl.findByKey(2L);
//		lDaoImpl.delete(log);
//		org.junit.Assert.assertTrue("fail to delete", lDaoImpl.findAll().size() == 2);
//	}
//
//	@Test
//	public void testDeleteByKey() {
//		lDaoImpl.deleteByKey(2L);
//		org.junit.Assert.assertTrue("fail to delete", lDaoImpl.findAll().size() == 2);
//	}
//
//}
