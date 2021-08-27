package com.swan.model;

import java.util.Calendar;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.google.gson.annotations.Expose;
import com.swan.model.base.Versionable;
import com.swan.utils.VerfyIdGenerator;

@Entity
@Table(name = "document_verify")
public class DocumentVerify extends Versionable {

	@Expose
	@Column(name = "student_id")
	private String studentId;

	@Expose
	@Column(name = "active")
	protected Boolean active;

	@Expose
	@Column(name = "price1")
	private Integer price1;

	@Expose
	@Column(name = "price2")
	private Integer price2;

	@Expose
	@Column(name = "document_id")
	private String documentId;

	@Expose
	@Column(name = "total_result")
	private String totalResult;

	@Expose
	@Column(name = "level")
	private String level;

	@Expose
	@Column(name = "deleted")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "MM")
	protected Calendar deleted;

	@Expose
	@Column(name = "verify_id")
	private String verifyId;

	@Expose
	@Column(name = "note")
	private String note;
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Integer getPrice1() {
		return price1;
	}

	public void setPrice1(Integer price1) {
		this.price1 = price1;
	}

	public Integer getPrice2() {
		return price2;
	}

	public void setPrice2(Integer price2) {
		this.price2 = price2;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(String totalResult) {
		this.totalResult = totalResult;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Calendar getDeleted() {
		return deleted;
	}

	public void setDeleted(Calendar deleted) {
		this.deleted = deleted;
	}

	public String getVerifyId() {
		return verifyId;
	}

	public void setVerifyId(String verifyId) {
		this.verifyId = verifyId;
	}

	public String getNote() {
		return verifyId;
	}

	public void setNote(String note) {
		this.note = note;
	}
	public DocumentVerify() {
	}

	public DocumentVerify(String documentId, String studentId, String price, String result, String level) {
		setUuid(UUID.randomUUID().toString());
		setActive(true);
		setVersion(1);
		final Calendar date = Calendar.getInstance();
		setCreatedDate(date);
		setUpdatedDate(date);
		final VerfyIdGenerator verfyIdGenerator = new VerfyIdGenerator();
		setVerifyId(verfyIdGenerator.randomAlphaNumeric(5));
		setStudentId(studentId);
		setPrice1(Integer.parseInt(price));
		setPrice2(Integer.parseInt(price));
		setTotalResult(result);
		setLevel(level);
		setDocumentId(documentId);
	}

	public DocumentVerify(String documentId, String studentId, String price, String result, String level,
			String verfyId) {
		setUuid(UUID.randomUUID().toString());
		setActive(true);
		setVersion(1);
		final Calendar date = Calendar.getInstance();
		setCreatedDate(date);
		setUpdatedDate(date);
		setVerifyId(verfyId);
		setStudentId(studentId);
		setPrice1(Integer.parseInt(price));
		setPrice2(Integer.parseInt(price));
		setTotalResult(result);
		setLevel(level);
		setDocumentId(documentId);
	}

}
