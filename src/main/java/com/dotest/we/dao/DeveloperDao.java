package com.dotest.we.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import com.dotest.we.models.Developer;
import com.dotest.we.models.Log;  

@Transactional
public interface DeveloperDao extends CrudRepository<Developer, Integer>{
	 public List<Developer> findByDeveloperId(int developer_id);  
}
