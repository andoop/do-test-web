package com.dotest.we.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.dotest.we.models.User;  

@Transactional
public interface UserDao extends CrudRepository<User, Integer>{
	 public User findByUserId(String user_id);  
	 public User findById(int id);  
	 public List<User> findByAppId(int app_id);  
}
