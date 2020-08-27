package com.example.demoJ5springboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Records")
public class Records {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="Type")
	private Integer type;
	
	@Column(name="Reason",length = 255,nullable = false)
	private String reason;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name="Date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="StaffId")
	private Staffs staffid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Staffs getStaffid() {
		return staffid;
	}

	public void setStaffid(Staffs staffid) {
		this.staffid = staffid;
	}

	public Records(Integer id, Integer type, String reason, Date date, Staffs staffid) {
		super();
		this.id = id;
		this.type = type;
		this.reason = reason;
		this.date = date;
		this.staffid = staffid;
	}

	public Records() {
		
	}
	
//	@Override
//    public String toString() {
//
//        var builder = new StringBuilder();
//        builder.append("City{id=").append(id).append(", name=")
//                .append(name).append(", population=")
//                .append(population).append("}");
//
//        return builder.toString();
//    }
}
