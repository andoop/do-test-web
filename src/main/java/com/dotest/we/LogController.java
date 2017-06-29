package com.dotest.we;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dotest.we.dao.LogDao;
import com.dotest.we.models.Log;

@RestController
@RequestMapping("/log")
public class LogController {
	
	@Resource
	LogDao logDao;

	/**
	 * 添加Log日志记录
	 * @param user_id
	 * @param log_time
	 * @param log_json
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addLog(@RequestParam(value="user_id")int user_id
			,@RequestParam(value="log_time")String log_time
			,@RequestParam(value="log_json")String log_json){
		
		Log log = new Log();
		log.setLogId(123);
		log.setLogTime(log_time);
		log.setLogType("test");
		log.setUserId(user_id);
		log.setLogJson(log_json);
		
		logDao.save(log);
		
		return "add log ok";
	}
	
	@RequestMapping(value="/getlogs",method=RequestMethod.GET)
	public List<Log> getLogs(int user_id){
		
	    List<Log> logs = logDao.findByUserId(user_id);
	    
		return logs;
	}
}
