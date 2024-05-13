package com.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Bill")
public class BillEntity {
		//MaHoaDon
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="BillID")
		private int billID;
		
		@OneToMany(mappedBy = "bill",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
		private Collection<DetailBillEntity>detailBills;
		
		//MaNhanVien
		@ManyToOne
		@JoinColumn(name="EmployeeID")
		private EmployeeEntity employee;

		//MaChoNgoi
		@ManyToOne
		@JoinColumn(name="SeatID")
		private SeatEntity seat;

		//MaKhanhHang
		@ManyToOne
		@JoinColumn(name="CustomerID")
		private CustomerEntity customer;

		//NgayLapHoaDon
		@Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern="yyyy-MM-dd")
		@Column(name="CreateBillDay")
		private Date createBillDay;

		


		public int getBillID() {
			return billID;
		}

		public void setBillID(int billID) {
			this.billID = billID;
		}

		public Collection<DetailBillEntity> getDetailBills() {
			return detailBills;
		}

		public void setDetailBills(Collection<DetailBillEntity> detailBills) {
			this.detailBills = detailBills;
		}

		public EmployeeEntity getEmployee() {
			return employee;
		}

		public void setEmployee(EmployeeEntity employee) {
			this.employee = employee;
		}

		public SeatEntity getSeat() {
			return seat;
		}

		public void setSeat(SeatEntity seat) {
			this.seat = seat;
		}

		public CustomerEntity getCustomer() {
			return customer;
		}

		public void setCustomer(CustomerEntity customer) {
			this.customer = customer;
		}

		public Date getCreateBillDay() {
			return createBillDay;
		}

		public void setCreateBillDay(Date createBillDay) {
			this.createBillDay = createBillDay;
		}
		
}
