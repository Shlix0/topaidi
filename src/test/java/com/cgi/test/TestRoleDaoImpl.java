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
//import com.cgi.dao.RoleDaoImpl;
//import com.cgi.model.Category;
//import com.cgi.model.Idea;
//import com.cgi.model.Role;
//import com.cgi.utils.ContextDB;
//
//public class TestRoleDaoImpl {
//
//	EntityManagerFactory emf = null;
//	RoleDaoImpl rDaoImpl = new RoleDaoImpl();
//	Role role;
//	Role role1;
//	Role role2;
//	Role role3;
//	
//	@Before
//	public void init() {
//		ContextDB.stop();
//		EntityManager em = ContextDB.getInstance().getEmf().createEntityManager();
//		
//		role1 = new Role();
//		role2 = new Role();
//		role3 = new Role();
//		
//		em.getTransaction().begin();
//		
//		em.persist(role1);
//		em.persist(role2);
//		em.persist(role3);
//		
//		em.getTransaction().commit();
//	}
//	
//	@Test
//	public void testFindAll() {
//		
//		List<Role> roles = rDaoImpl.findAll();
//		org.junit.Assert.assertTrue("fail to findAll", roles.size() == 3);
//	}
//
//	@Test
//	public void testFindByKey() {
//		role = rDaoImpl.findByKey(2L);
//		org.junit.Assert.assertTrue("fail to find by key", role != null);
//	}
//
//	@Test
//	public void testAdd() {
//		role = new Role();
//		int sizeBefore = rDaoImpl.findAll().size();
//		rDaoImpl.add(role);
//		int sizeAfter = rDaoImpl.findAll().size();
//		org.junit.Assert.assertTrue("fail to add a role",sizeAfter == sizeBefore+1);
//	}
//
//	@Test
//	public void testUpdate() {
//		role = rDaoImpl.findByKey(2L);
//		role.setName("roleTest");
//		rDaoImpl.update(role);
//		Role roleTest = rDaoImpl.findByKey(2L);
//		
//		org.junit.Assert.assertTrue("fail to update a User", roleTest.getName().equals("roleTest"));
//	}
//
//	@Test
//	public void testDelete() {
//		role = rDaoImpl.findByKey(2L);
//		rDaoImpl.delete(role);
//		org.junit.Assert.assertTrue("fail to delete", rDaoImpl.findAll().size() == 2);
//	}
//
//	@Test
//	public void testDeleteByKey() {
//		rDaoImpl.deleteByKey(2L);
//		org.junit.Assert.assertTrue("fail to delete", rDaoImpl.findAll().size() == 2);
//	}
//
//}
