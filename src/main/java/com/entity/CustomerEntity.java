package com.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class CustomerEntity {
	//maKH
		@Id
		@Column(name="CustomerID")
		private String customerID;
		
		@OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
		private Collection<BillEntity>bills;
		
		//TenKH
		@Column(name="CustomerName")
		private String customerName;
		
		
		public String getCustomerID() {
			return customerID;
		}
		public void setCustomerID(String customerID) {
			this.customerID = customerID;
		}
		public Collection<BillEntity> getBills() {
			return bills;
		}
		public void setBills(Collection<BillEntity> bills) {
			this.bills = bills;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
}
