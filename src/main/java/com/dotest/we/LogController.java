package com.dotest.we;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dotest.we.dao.AppDao;
import com.dotest.we.dao.LogDao;
import com.dotest.we.dao.UserDao;
import com.dotest.we.models.App;
import com.dotest.we.models.Log;
import com.dotest.we.models.User;

@RestController
@RequestMapping("/log")
public class LogController {
	
	@Resource
	LogDao logDao;
	@Resource
	AppDao appDao;
	@Resource
	UserDao userDao;
	
	

	/**
	 * 添加Log日志记录
	 * @param user_id
	 * @param log_time
	 * @param log_json
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addLog(
			 @RequestParam(value="app_id")String app_id
			,@RequestParam(value="user_id")String user_id
			,@RequestParam(value="log_time")String log_time
			,@RequestParam(value="log_json")String log_json){
		
		//查询应用是否存在
		App app = appDao.findByAppId(Integer.parseInt(app_id));
		if(app==null){
			return "app is not exists";
		}
		//查询用户表，如果这个用户不存在，则将这个用户加入到用户表
		User user = userDao.findByUserId(app_id+"*"+user_id);
		if(user==null){
			user=new User();
			user.setAppId(Integer.parseInt(app_id));
			user.setUserId(app_id+"*"+user_id);
			//存入数据库
			userDao.save(user);
		}
		
		//List<String> logs = new Gson().fromJson(log_json,new TypeToken<List<String>>() {}.getType());
		//将log存入数据库
		Log log = new Log();
		log.setLogType("");
		log.setUserId(app_id+"*"+user_id);
		log.setLogJson(log_json);
		log.setLogTime(log_time);
		logDao.save(log);
		
		return "add log ok";
	}
	
	@RequestMapping(value="/getlogs",method=RequestMethod.GET)
	public List<Log> getLogs( @RequestParam(value="user_id")String user_id){
	    List<Log> logs = logDao.findByUserId(user_id);
		return logs;
	}
}
