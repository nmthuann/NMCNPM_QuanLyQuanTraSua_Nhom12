package com.entity;


import java.util.Collection;

import javax.persistence.Column;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.FetchType;

@Entity
@Table(name = "Position")
public class PositionEntity {
	
	//maCV
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PositionID")
	private int positionID;
	
	//tenCV
	@Column(name="PositionName")
	private String positionName;
	
	
	@OneToMany(mappedBy = "position", fetch = FetchType.LAZY)
	private Collection<EmployeeEntity> employees;

	public int getPositionID() {
		return positionID;
	}

	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public Collection<EmployeeEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(Collection<EmployeeEntity> employees) {
		this.employees = employees;
	}


	
	
}
