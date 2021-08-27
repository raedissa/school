package com.swan.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.swan.model.base.Versionable;

@Entity
@Table(name = "search_verify")
public class SearchVerify extends Versionable {

	@Expose
	@Column(name = "verfy_id")
	private String verfyId;

	@Expose
	@Column(name = "ip")
	private BigInteger ip;

	@Expose
	@Column(name = "active")
	protected Boolean active;

	@Expose
	@Column(name = "country")
	private String country;

	public String getVerfyId() {
		return verfyId;
	}

	public void setVerfyId(String verfyId) {
		this.verfyId = verfyId;
	}

	public BigInteger getIp() {
		return ip;
	}

	public void setIp(BigInteger ip) {
		this.ip = ip;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public SearchVerify() {

	}
}
