package com.cgi.dao;

import java.util.List;

import com.cgi.model.User;

public interface UserDao extends GenericDao<User, Long> {

	
	public List<User> getAllUsersUnactivated();
	public List<User> getBrainUsers();
	public void addVoteTopToIdea(Long idUser, Long idIdea);
	public void addVoteFlopToIdea(Long idUser, Long idIdea);
	public User findByLogin(String email, String password);
}
