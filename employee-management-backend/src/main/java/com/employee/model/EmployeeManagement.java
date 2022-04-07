package com.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeManagement {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	private String fullName;
	private String emailId;
	private String address;
	private String manager;
	private String mobile;
	private String project;
	
	public EmployeeManagement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeManagement(int empId, String fullName, String emailId, String address, String manager, String mobile,
			String project) {
		super();
		this.empId = empId;
		this.fullName = fullName;
		this.emailId = emailId;
		this.address = address;
		this.manager = manager;
		this.mobile = mobile;
		this.project = project;
	}

	



	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	@Override
	public String toString() {
		return "EmployeeManagement [empId=" + empId + ", fullName=" + fullName + ", emailId=" + emailId + ", address="
				+ address + ", manager=" + manager + ", mobile=" + mobile + ", project=" + project + "]";
	}

	
}
