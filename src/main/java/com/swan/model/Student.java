package com.swan.model;

import java.util.Calendar;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.swan.model.base.Versionable;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "student")
public class Student extends Versionable {

	@Expose
	@Column(name = "first_name")
	private String firstName;

	@Expose
	@Column(name = "last_name")
	private String lastName;

	@Expose
	@Column(name = "birth_date")
	protected String birthDate;

	@Expose
	@Column(name = "telephone_number")
	@Pattern(regexp ="^\\+?[0-9. ()-]{7,25}$", message = "Phone number")
	@Size(max = 25)
	private String telephoneNumber;

	@Expose
	@Column(name = "email")
	@Email(message = "Email Address")
	@Size(max = 100)
	private String email;

	@Expose
	@Column(name = "address")
	private String address;

	@Expose
	@Column(name = "nationality")
	private String nationality;

	@Expose
	@Column(name = "note")
	private String note;

	@Expose
	@Column(name = "active")
	private Boolean active;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Student() {
	}

	public Student(Student student) {
		setUuid(UUID.randomUUID().toString());
		setActive(true);
		setVersion(1);
		final Calendar date = Calendar.getInstance();
		setCreatedDate(date);
		setUpdatedDate(date);
		setFirstName(student.firstName);
		setLastName(student.lastName);
		setBirthDate(student.birthDate);
		setTelephoneNumber(student.telephoneNumber);
		setEmail(student.email);
		setAddress(student.address);
		setNationality(student.nationality);
		setNote(student.note);
	}

}
