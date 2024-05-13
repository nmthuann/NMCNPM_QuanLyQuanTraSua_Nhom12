package com.entity;

//import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Employee")
public class EmployeeEntity {

	// MaNhanVien
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmployeeID")
	private int employeeID;

	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
	private Collection<BillEntity> bills;

	// HoNhanVien
	@Column(name = "FirstName")
	private String firstName;

	// TenNhanVien
	@Column(name = "LastName")
	private String lastName;

	// GioiTinh
	private boolean gender;

	// NgaySinh
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "Birthday")
	private Date birthday;

	// DiaChi
	@Column(name = "Address")
	private String address;

	// SoDienThoai
	@Column(name = "Phone")
	private String phone;

//	// Email
//	@Column(name = "Email")
//	private String email;



	// MaChucVu
	@ManyToOne
	@JoinColumn(name = "PositionID")
	private PositionEntity position;

	// NgayVaolam
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "StartDay")
	private Date startDay;

	// TrangThaiLam
	@Column(name = "EmployeeStatus")
	private boolean status;


	
	@OneToOne//(cascade=CascadeType.ALL) // ,fetch = FetchType.LAZY)
	@JoinColumn(name="Email",referencedColumnName="UserName",unique=true)
	private EmployeeAccountEntity employeeaccountEntity;
	//private String email;
	
	
	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public Collection<BillEntity> getBills() {
		return bills;
	}

	public void setBills(Collection<BillEntity> bills) {
		this.bills = bills;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public PositionEntity getPosition() {
		return position;
	}

	public void setPosition(PositionEntity position) {
		this.position = position;
	}

//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}



	public Date getStartDay() {
		return startDay;
	}

	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}

	public EmployeeAccountEntity getEmployeeaccountEntity() {
		return employeeaccountEntity;
	}

	public void setEmployeeaccountEntity(EmployeeAccountEntity employeeaccountEntity) {
		this.employeeaccountEntity = employeeaccountEntity;
	}

	
	//		 String email,
	public EmployeeEntity(int employeeID, Collection<BillEntity> bills, String firstName, String lastName,
			boolean gender, Date birthday, String address, String phone, PositionEntity position,
			Date startDay, boolean status, EmployeeAccountEntity employeeaccountEntity) {
		super();
		this.employeeID = employeeID;
		this.bills = bills;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
		//this.email = email;
		this.position = position;
		this.startDay = startDay;
		this.status = status;
		this.employeeaccountEntity = employeeaccountEntity;
	}

	public EmployeeEntity(){
		super();
	}

	@Override
	public String toString() {
		return "EmployeeEntity [employeeID=" + employeeID + ", bills=" + bills + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", birthday=" + birthday + ", address=" + address
				+ ", phone=" + phone + ", position=" + position + ", startDay=" + startDay + ", status=" + status
				+ ", employeeaccountEntity=" + employeeaccountEntity + "]";
	}

	
}
