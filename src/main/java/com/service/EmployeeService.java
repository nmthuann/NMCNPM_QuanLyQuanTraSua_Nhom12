package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeDao;
import com.entity.EmployeeEntity;
import com.entity.PositionEntity;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	
	//check_ID_NhanVien
	public boolean CheckEmployeeID(int id) {
		return employeeDao.CheckEmployeeId(id);
	}
	
	public EmployeeEntity getByEmployee(int id) {
		return employeeDao.getByEmployeeID(id);
	}
	
	// check tồn tại
	public Boolean CheckExistEmployeeID(int id) {
		if(this.getByEmployee(id)!= null) {
			return true;
		}
		return false;
	}
	
	public List<EmployeeEntity>EmployeeList(){
		return employeeDao.EmployeeList();
	}
	
	public List<EmployeeEntity> SearchEmployeeName(String name){
		return employeeDao.SearchEmployeeName(name);
	}
	
	public List<PositionEntity> getByPositionNameList() {
		return employeeDao.getByPositionNameList();
	}
	
	
	public EmployeeEntity  GetByEmployeeID(int employeeID) {
		return employeeDao.GetByEmployeeID(employeeID);
	}
	
	public Integer UpdateEmployeeStatus(int employeeID) {
		return employeeDao.UpdateEmployeeStatus(employeeID);
	}
	
	public Integer EditEmployee(EmployeeEntity employee) {
		return employeeDao.EditEmployee(employee);
	}
	
}
