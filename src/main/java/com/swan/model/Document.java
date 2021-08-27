package com.swan.model;

import java.util.Calendar;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.google.gson.annotations.Expose;
import com.swan.model.base.Versionable;

@Entity
@Table(name = "document")
public class Document extends Versionable {

	@NotNull
	@Expose
	@Column(name = "name")
	private String name;

	@NotNull
	@Expose
	@Column(name = "active")
	private Boolean active;

	@Override
	public String getUuid() {
		return uuid;
	}

	@Override
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public Calendar getCreatedDate() {
		return createdDate;
	}

	@Override
	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public Calendar getUpdatedDate() {
		return updatedDate;
	}

	@Override
	public void setUpdatedDate(Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Document() {
		setUuid(UUID.randomUUID().toString());
		setActive(true);
		setVersion(1);
		final Calendar date = Calendar.getInstance();
		setCreatedDate(date);
		setUpdatedDate(date);
	}

}
