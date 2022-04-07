package com.microservice.entity;

public class ManagementEntity {
	
	private int empId;
	private String name;
	private String address;
	private String mobile;
	private String manager;
	private String project;
	public ManagementEntity(int empId, String name, String address, String mobile, String manager, String project) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.manager = manager;
		this.project = project;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	
	

}
