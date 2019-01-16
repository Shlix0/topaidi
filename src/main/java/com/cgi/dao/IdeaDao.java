package com.cgi.dao;

import java.util.List;

import com.cgi.model.Idea;

public interface IdeaDao extends GenericDao<Idea, Long> {

	public List<Idea> findAllIdeaByCategory(Long Key);
	
	public void addVoteTop(Long idIdea, Long idUser);
	public List<Idea> getTopIdeas();
	public List<Idea> getBuzzIdeas();
	public List<Idea> getReportedIdeas();
	
	}
