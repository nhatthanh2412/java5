package com.example.demoJ5springboot.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Staffs")
public class Staffs {

	@Id
	@Column(name = "ID",length = 10)
	private String id;
	
	@Column(name = "Name",length = 50,nullable = false)
	private String name;
	
	@Column(name="Gender")
	private Boolean gender;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name="Birthday")
	private Date birthday;
	
	@Column(name="Photo",length = 255,nullable = false)
	private String photo;
	
	@Column(name="Email",length = 255,nullable = false)
	private String email;
	
	@Column(name="Phone",length = 20,nullable = false)
	private String phone;
	
	@Column(name = "Salary")
	private double salary;
	
	@Column(name="Notes",length = 255)
	private String notes;
	
	@ManyToOne
	@JoinColumn(name="DepartId")
	private Departs departs;
	
	@OneToMany(mappedBy = "staffid",fetch = FetchType.EAGER)
	private Collection<Records> records;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Departs getDeparts() {
		return departs;
	}

	public void setDeparts(Departs departs) {
		this.departs = departs;
	}

	public Collection<Records> getRecords() {
		return records;
	}

	public void setRecords(Collection<Records> records) {
		this.records = records;
	}

	public Staffs(String id, String name, Boolean gender, Date birthday, String photo, String email, String phone,
			double salary, String notes, Departs departs, Collection<Records> records) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.photo = photo;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
		this.notes = notes;
		this.departs = departs;
		this.records = records;
	}

	public Staffs(String id, String name, Boolean gender, Date birthday, String photo, String email, String phone,
			double salary, String notes, Departs departs) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.photo = photo;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
		this.notes = notes;
		this.departs = departs;
	}

	public Staffs() {
		
	}
	
	
	
}
