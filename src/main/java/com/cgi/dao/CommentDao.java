package com.cgi.dao;

import java.util.List;

import com.cgi.model.Comment;

public interface CommentDao extends GenericDao<Comment, Long> {

	public List<Comment> findByIdIdea(Long id);
}
