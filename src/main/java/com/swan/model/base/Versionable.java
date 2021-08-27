package com.swan.model.base;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Raed
 *
 */
@MappedSuperclass
public abstract class Versionable {

	public static <T extends Versionable> List<String> getUuids(final List<T> entityList) {
		final List<String> idList = new ArrayList<String>();

		for (final T v : entityList) {
			idList.add(v.getUuid());
		}

		return idList;
	}

	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "MM")
	protected Calendar createdDate;

	@Column(name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "MM")
	protected Calendar updatedDate;

	@Id
	@Column(name = "uuid", length = 36)
	public String uuid;

	@Version
	@Column(name = "version")
	private Integer version;

	public Versionable() {
		setUuid(UUID.randomUUID().toString());
		setVersion(1);
		final Calendar date = Calendar.getInstance();
		setCreatedDate(date);
		setUpdatedDate(date);
	}

	// public abstract void anonymize(); TODO?

	public Calendar getCreatedDate() {
		return this.createdDate;
	}

	public Calendar getUpdatedDate() {
		return this.updatedDate;
	}

	public String getUuid() {
		return this.uuid;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setCreatedDate(final Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public void setUpdatedDate(final Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}

	public void setUuid(final String uuid) {
		this.uuid = uuid;
	}

	public void setVersion(final Integer version) {
		this.version = version;
	}

	@PreUpdate
	public void update() {
		/*
		 * if (getActive()) { setUuid(UUID.randomUUID().toString()); }
		 */
		setUpdatedDate(Calendar.getInstance());
	}
}
