package com.swan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.swan.model.base.Versionable;

@Entity
@Table(name = "app_user")
public class AppUser extends Versionable {

	@Expose
	@Column(name = "user_name")
	private String userName;

	@Expose
	@Column(name = "password")
	private String password;

	public AppUser() {

	}

	public AppUser(String uuid, String userName, String password) {
		this.uuid = uuid;
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
