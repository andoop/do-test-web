package com.dotest.we;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dotest.we.dao.DeveloperDao;
import com.dotest.we.models.Developer;
import com.dotest.we.models.Response;
import com.dotest.we.models.Response.Err;
import com.dotest.we.models.Response.SimpleMsg;

@RestController
@RequestMapping("/dev")
public class DeveloperController {
	
	@Resource
	DeveloperDao developerDao;
	
	//http://localhost:8080/dev/login?developer_email=123&developer_password=eeee
	/**
	 * 登录
	 * @param developer_email
	 * @param developer_password
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public Response login(@RequestParam(value = "developer_email")String developer_email
			,@RequestParam(value = "developer_password")String developer_password){
		//从数据库中检查邮箱有没有注册
		Developer developer = developerDao.findByDeveloperEmail(developer_email);
		if(developer==null){
			return new Response(null,new Err(100001,"开发者不存在，或没有审核通过！"));
		}else{
			if(!developer.getDeveloperPassword().equals(developer_password)){
				return new Response(null,new Err(100002,"密码不正确！"));
			}
		}
		
	  return  new Response(developer.getDeveloperId(),null);
	}
	/**
	 * 注册
	 * @param developer_email
	 * @param developer_password
	 * @return
	 */
	@RequestMapping(value="/regist",method=RequestMethod.GET)
	public Response rigest(@RequestParam(value = "developer_email")String developer_email
			,@RequestParam(value = "developer_password")String developer_password){
		
		//从数据库中检查邮箱有没有注册
		Developer developer = developerDao.findByDeveloperEmail(developer_email);
		if(developer!=null){
			return new Response(null,new Err(100003,"邮箱已被注册，请登录！"));
		}
		
	    developer = new Developer();
		developer.setDeveloperEmail(developer_email);
		developer.setDeveloperPassword(developer_password);
		developerDao.save(developer);
	  return new Response(new SimpleMsg(200,"注册成功请登录！"),null);
	}
	/**
	 * 注销
	 * @return
	 */
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(){
		return "logout";
	}
	
	@RequestMapping(value="/reset",method=RequestMethod.GET)
	public Response reset(@RequestParam(value = "developer_email")String developer_email
			,@RequestParam(value = "developer_name")String developer_name){
		
		Developer developer = developerDao.findByDeveloperEmail(developer_email);
		if(developer==null){
			return new Response(null,new Err(100001,"开发者不存在，或没有审核通过！"));
		}
		
		return new Response(new SimpleMsg(200,"已经通知管理员，请等待管理员的邮件通知！"),null);
	}
}
