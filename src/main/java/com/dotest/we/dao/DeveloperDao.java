package com.dotest.we.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.dotest.we.models.Developer;  

@Transactional
public interface DeveloperDao extends CrudRepository<Developer, Integer>{
	 public Developer findByDeveloperEmail(String developer_email);  
}
