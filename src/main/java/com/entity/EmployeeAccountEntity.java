package com.entity;

import javax.persistence.Column;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

//import org.hibernate.annotations.Cascade;
//import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="EmployeeAccount")
public class EmployeeAccountEntity {
	//tenTK
	@Id
	@Column(name="UserName",nullable = false)
	private String userName;
	
	//MatKhau
	@Column(name="Password",nullable = false)
	private String password;
	
	//Qu_yen
	@Column(name="Role",nullable = false)
	private boolean role;
	
	
//	@OneToOne//(mappedBy = "e_mployeeaccount",fetch = FetchType.LAZY)//@Cascade(value = { CascadeType.ALL })
//	@JoinColumn(name="userName",referencedColumnName="Email")
	@OneToOne(mappedBy="employeeaccountEntity" ,fetch = FetchType.EAGER)
	private EmployeeEntity employeeEntity;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRole() {
		return role;
	}
	public void setRole(boolean role) {
		this.role = role;
	}
	
	public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}
	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
	}
	//, EmployeeEntity employeeEntity
	public EmployeeAccountEntity() {
		super();
	}
	public EmployeeAccountEntity(String userName, String password, boolean role, EmployeeEntity employeeEntity) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.employeeEntity = employeeEntity;
	}
	
	/*
	 * @Override public String toString() { return
	 * "EmployeeAccountEntity [userName=" + userName + ", password=" + password +
	 * ", role=" + role + ", employeeEntity=" + employeeEntity + "]"; }
	 */

	
	

	
	
}
