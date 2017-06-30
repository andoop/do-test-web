package com.dotest.we.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity 
@Table(name="log")
public class Log {
 
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="log_id",nullable=false,unique=true)
	private int logId;
	@Column(name="user_id")
	private String userId;
	@Column(name="log_time")
	private String logTime;
	@Column(name="log_type")
	private String logType;
	@Column(name="log_json")
	private String logJson;
	public int getLogId() {
		return logId;
	}
	public void setLogId(int log_id) {
		this.logId = log_id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String user_id) {
		this.userId = user_id;
	}
	public String getLogTime() {
		return logTime;
	}
	public void setLogTime(String log_time) {
		this.logTime = log_time;
	}
	public String getLogType() {
		return logType;
	}
	public void setLogType(String log_type) {
		this.logType = log_type;
	}
	public String getLogJson() {
		return logJson;
	}
	public void setLogJson(String log_json) {
		this.logJson = log_json;
	}
	
	
	
}
