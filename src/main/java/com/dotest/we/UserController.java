package com.dotest.we;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dotest.we.dao.UserDao;
import com.dotest.we.models.Response;
import com.dotest.we.models.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Resource
	UserDao userDao;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Response getUserList(@RequestParam(value="value")int appId){
		List<User> list=userDao.findByAppId(appId);
		return new Response(list, null);
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public Response addUser(@RequestParam(value="value")int appId,
			@RequestParam(value="userid")String userid,
			@RequestParam(value="userdesc")String userdesc){
		

			User user = new User();
			user.setAppId(appId);
			user.setUserDesc(userdesc);
			user.setUserId(appId+":"+userid);
			
			userDao.save(user);
			
		return new Response(new Response.SimpleMsg(200, "添加用户成功！"), null);
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public Response deleteUser(@RequestParam(value="value")int id,
			@RequestParam(value="appid")int appId){
		
	    User user = userDao.findById(id);
	    System.out.println("--------------------"+user.getId());
	    
	    if(user==null){
	    	return new Response(new Response.SimpleMsg(404, "要删除的用户不存在！"), null);
	    }
		
	    userDao.delete(id);
		return new Response(new Response.SimpleMsg(200, "删除成功！"), null);
	}
	
	
}
