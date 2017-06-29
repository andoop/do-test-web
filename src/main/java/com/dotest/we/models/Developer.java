package com.dotest.we.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="developer")
public class Developer {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="developer_id" ,nullable=false,unique=true)
	private int developerId;
	@Column(name="developer_email",nullable=false)
	private String developerEmail;
	@Column(name="developer_password")
	private String developerPassword;
	public int getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(int developer_id) {
		this.developerId = developer_id;
	}
	public String getDeveloperEmail() {
		return developerEmail;
	}
	public void setDeveloperEmail(String developer_email) {
		this.developerEmail = developer_email;
	}
	public String getDeveloperPassword() {
		return developerPassword;
	}
	public void setDeveloperPassword(String developer_password) {
		this.developerPassword = developer_password;
	}
	
	

}
