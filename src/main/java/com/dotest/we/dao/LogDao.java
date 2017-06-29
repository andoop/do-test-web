package com.dotest.we.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import com.dotest.we.models.Log;  

@Transactional
public interface LogDao extends CrudRepository<Log, Integer>{
	 public List<Log> findByUserId(int user_id);  
}
