package com.dotest.we;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dotest.we.dao.AppDao;
import com.dotest.we.models.App;
import com.dotest.we.models.Response;

@RestController
@RequestMapping("/app")
public class AppsController {
	
	@Resource
	AppDao appDao;
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Response getAppList(@RequestParam(value="value")int developer_id){
		List<App> list=appDao.findByDeveloperId(developer_id);
		return new Response(list, null);
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public Response addApp(@RequestParam(value="value")int value
			,@RequestParam(value="name")String appName
			,@RequestParam(value="pkg")String appPkg){
	
		App app = new App();
		app.setAppName(appName);
		app.setAppPkg(appPkg);
		app.setDeveloperId(value);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		app.setAppTime(df.format(new Date()));
		App savedapp = appDao.save(app);
		return new Response(savedapp, null);
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public Response deleteApp(@RequestParam(value="value")int value
			,@RequestParam(value="appid")int appId){
		appDao.delete(appId);
		List<App> list=appDao.findByDeveloperId(value);
		return new Response(list, null);
	}
	
	@RequestMapping(value="/find",method=RequestMethod.GET)
	public Response findApp(@RequestParam(value="appid")int appId){
	
		
		System.out.println("ddddddddddddddddddddddddd");
		App app=appDao.findByAppId(appId);
		return new Response(app, null);
	}

}
