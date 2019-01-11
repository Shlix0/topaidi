package com.cgi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cgi.model.Role;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Role> findAll() {
		return em.createQuery("from Role r").getResultList();
	}

	@Override
	public Role findByKey(Long id) {
		return em.find(Role.class, id);
	}

	@Override
	public Role add(Role role) {
		em.persist(role);
		return role;
	}

	@Override
	public Role update(Role role) {
		em.merge(role);
		return role;
	}

	@Override
	public void delete(Role role) {
		Role eMerged = em.merge(role);
		em.remove(eMerged);
	}

	@Override
	public void deleteByKey(Long id) {
		Role role = em.find(Role.class, id);
		em.remove(role);
	}

}
