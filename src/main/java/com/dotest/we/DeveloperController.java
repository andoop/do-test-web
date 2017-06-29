package com.dotest.we;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dev")
public class DeveloperController {
	
	//http://localhost:8080/dev/login?developer_email=123&developer_password=eeee
	/**
	 * 登录
	 * @param developer_email
	 * @param developer_password
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(@RequestParam(value = "developer_email")String developer_email
			,@RequestParam(value = "developer_password")String developer_password){
		
	  return "login";
	}
	/**
	 * 注册
	 * @param developer_email
	 * @param developer_password
	 * @return
	 */
	@RequestMapping(value="/rigest",method=RequestMethod.GET)
	public String rigest(@RequestParam(value = "developer_email")String developer_email
			,@RequestParam(value = "developer_password")String developer_password){
		
	  return "rigest";
	}
	/**
	 * 注销
	 * @return
	 */
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(){
		return "logout";
	}
	
	
	
	

}
