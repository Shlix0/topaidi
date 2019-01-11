package com.cgi.test;

import static org.junit.Assert.*;

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
import com.cgi.dao.RoleDao;
import com.cgi.dao.RoleDaoImpl;
import com.cgi.model.Category;
import com.cgi.model.Idea;
import com.cgi.model.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigContext.class})
@Transactional
public class TestRoleDaoImpl {

	@Autowired
	RoleDao rDao;
	Role role;
	Role role1;
	
	
	@Test
	public void testFindAll() {
		
		assertNotNull(rDao.findAll());
	}

	@Test
	public void testFindByKey() {
		role = new Role();
		rDao.add(role);
		assertNotNull(rDao.findByKey(1L));
	}

	@Test
	public void testAdd() {
		role = new Role();
		int sizeBefore = rDao.findAll().size();
		role.setName("RoleTest");
		rDao.add(role);
		int sizeAfter = rDao.findAll().size();
		assertNotNull(role.getName());
		assertTrue(sizeAfter == sizeBefore+1);	
		}

	@Test
	public void testUpdate() {
		role = new Role();
		role.setName("roleTest");
		rDao.update(role);
		Role roleTest = rDao.findByKey(1L);
		roleTest.setName("roleModify");
		rDao.update(roleTest);
		assertTrue(rDao.findByKey(1L).getName().equals("roleModify"));
	}

	@Test
	public void testDelete() {
		role = new Role();
		int sizeBefore = rDao.findAll().size();
		rDao.add(role);
		rDao.delete(role);
		int sizeAfter = rDao.findAll().size();
		assertTrue(sizeAfter == sizeBefore);
	}

	@Test
	public void testDeleteByKey() {
		role = new Role();
		int sizeBefore = rDao.findAll().size();
		rDao.add(role);
		rDao.deleteByKey(1L);
		int sizeAfter = rDao.findAll().size();
		assertTrue(sizeAfter == sizeBefore);
	}

}
