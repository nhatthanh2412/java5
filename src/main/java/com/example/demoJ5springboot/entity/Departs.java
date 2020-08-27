package com.example.demoJ5springboot.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Departs")
public class Departs {
	@Id
	@Column(name="Id")
	private String id;
	
	
	@Column(name="Name",length = 100,nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "departs", fetch = FetchType.EAGER)
	private Collection<Staffs> staffs;
	
	
	
	public Departs(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

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

	public Collection<Staffs> getStaffs() {
		return staffs;
	}

	public void setStaffs(Collection<Staffs> staffs) {
		this.staffs = staffs;
	}

	public Departs(String id, String name, Collection<Staffs> staffs) {
		super();
		this.id = id;
		this.name = name;
		this.staffs = staffs;
	}

	public Departs() {
	
	}
	
	
}
