package com.dotest.we.models;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false,unique=true)  
	private int userId;
	@Column(name="app_id",nullable=false)
	private int appId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int user_id) {
		this.userId = user_id;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int app_id) {
		this.appId = app_id;
	}
	
	
	
}
