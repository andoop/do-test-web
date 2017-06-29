package com.dotest.we.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import com.dotest.we.models.App;
@Transactional
public interface AppDao extends CrudRepository<App,Integer>{
	public List<App> findByDeveloperId(int developer_id);
}
