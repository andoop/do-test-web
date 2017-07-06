package com.dotest.we.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="app")
public class App {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="app_id",nullable=false,unique=true)
	private int appId;
    @Column(name="developer_id")
    private int developerId;
    @Column(name="app_name")
    private String appName;
    @Column(name="app_pkg")
    private String appPkg;
    @Column(name="app_time")
    private String appTime;
    
    
    public int getAppId() {
		return appId;
	}
	public void setAppId(int app_id) {
		this.appId = app_id;
	}
	public int getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(int developer_id) {
		this.developerId = developer_id;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String app_name) {
		this.appName = app_name;
	}
	public String getAppPkg() {
		return appPkg;
	}
	public void setAppPkg(String app_pkg) {
		this.appPkg = app_pkg;
	}
	
	public String getAppTime() {
		return appTime;
	}
    public void setAppTime(String appTime) {
		this.appTime = appTime;
	}
}
