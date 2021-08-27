package com.swan.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ip_country")
public class IpCountry {

	@NotNull
	@Id
	@Column(name = "ip_from")
	private BigInteger ipFrom;

	@NotNull
	@Column(name = "ip_to")
	private BigInteger ipTo;

	@NotNull
	@Column(name = "registry")
	private String registry;

	@NotNull
	@Column(name = "iso")
	private String iso;

	@NotNull
	@Column(name = "un")
	private String un;

	@Column(name = "country")
	private String country;

	@Column(name = "german_name")
	private String germanName;

	@Column(name = "continent")
	private String continent;

	public BigInteger getIpFrom() {
		return ipFrom;
	}

	public void setIpFrom(BigInteger ipFrom) {
		this.ipFrom = ipFrom;
	}

	public BigInteger getIpTo() {
		return ipTo;
	}

	public void setIpTo(BigInteger ipTo) {
		this.ipTo = ipTo;
	}

	public String getRegistry() {
		return registry;
	}

	public void setRegistry(String registry) {
		this.registry = registry;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getUn() {
		return un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGermanName() {
		return germanName;
	}

	public void setGermanName(String germanName) {
		this.germanName = germanName;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public IpCountry() {

	}

}
