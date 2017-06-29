package com.dotest.we.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import com.dotest.we.models.Log;
import com.dotest.we.models.User;  

@Transactional
public interface UserDao extends CrudRepository<User, Integer>{
	 public List<User> findByUserId(int user_id);  
}
