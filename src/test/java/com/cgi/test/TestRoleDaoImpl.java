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
import org.springframework.test.context.web.WebAppConfiguration;

import com.cgi.config.ConfigContext;
import com.cgi.config.JpaConfig;
import com.cgi.dao.RoleDao;
import com.cgi.dao.RoleDaoImpl;
import com.cgi.model.Category;
import com.cgi.model.Idea;
import com.cgi.model.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigContext.class})
@WebAppConfiguration
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
		Long id = role.getId();
		assertNotNull(rDao.findByKey(id));
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
		rDao.add(role);
		Role roleTest = rDao.findByKey(role.getId());
		roleTest.setName("roleModify");
		rDao.update(roleTest);
		assertTrue(rDao.findByKey(role.getId()).getName().equals("roleModify"));
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
		rDao.deleteByKey(role.getId());
		int sizeAfter = rDao.findAll().size();
		assertTrue(sizeAfter == sizeBefore);
	}

}
