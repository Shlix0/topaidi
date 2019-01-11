package com.cgi.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <T, ID extends Serializable>  {

    List<T> findAll();
    T findByKey(ID key);
    T add(T obj);
    T update(T obj);
    void delete(T obj);
    void deleteByKey(ID key);
}
