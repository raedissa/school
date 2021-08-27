package com.swan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.swan.model.base.Versionable;

@Entity
@Table(name = "user_role")
public class UserRole extends Versionable {

	public static final String ROLE_ADMIN = "ROLE_ADMIN";

	public static final String ROLE_USER = "ROLE_USER";

	@Expose
	@Column(name = "user_id")
	private String userId;

	@Expose
	@Column(name = "user_role")
	private String userRole;

	public UserRole() {

	}

	public UserRole(String id, String userId, String userRole) {
		this.uuid = id;
		this.userId = userId;
		this.userRole = userRole;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
