package com.dotest.we.models;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false,unique=true)  
	private int id ;
	
	@Column(name = "user_id", nullable = false,unique=true)  
	private String userId;
	@Column(name="app_id",nullable=false)
	private int appId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String user_id) {
		this.userId = user_id;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int app_id) {
		this.appId = app_id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
