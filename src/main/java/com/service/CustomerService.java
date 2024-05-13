package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerDao;
import com.entity.CustomerEntity;
import com.entity.PositionEntity;


@Service
public class CustomerService {
	@Autowired
	CustomerDao customerDao;
	
	//Check_id Customer
		public boolean CheckCustomerId(String id) {
			return customerDao.CheckCustomerId(id);
		}
	
		//Customer_list
		public List<CustomerEntity> CustomerList(){
			return customerDao.CustomerList();
		}
		
		//TimKiem
		public List<CustomerEntity> searchCustomerID(String cusID){
			return customerDao.searchCustomerID(cusID);
		}
		
		
		
		public Integer InsertCustomer(CustomerEntity customer) {
			return customerDao.InsertCustomer(customer);
		}
		
		
		//Edit
		public Integer EditCustomer(CustomerEntity customer) {
			return customerDao.EditCustomer(customer);
		}
		
		
		public CustomerEntity getByCustomerID(String customerID) {
			return customerDao.GetByCustomerID(customerID);
		}
}






