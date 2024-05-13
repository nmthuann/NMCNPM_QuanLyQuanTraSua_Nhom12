package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.CustomerEntity;
import com.entity.EmployeeEntity;
import com.entity.PositionEntity;

@Transactional
@Repository
public class CustomerDao {
	@Autowired
	SessionFactory factory;

	// Check_ID_Tim_kiem
	public boolean CheckCustomerId(String customerID) {
		Session session = factory.getCurrentSession();
		String hql = "FROM CustomerEntity where customerID = :customerID";
		Query query = session.createQuery(hql);
		query.setParameter("customerID", customerID);
		List<CustomerEntity> list = query.list();
		if (list.size() == 0) {
			return false;
		}
		return true;
	}

	// DanhSach_ban
	public List<CustomerEntity> CustomerList() {
		Session session = factory.getCurrentSession();
		String hql = "from CustomerEntity";
		Query query = session.createQuery(hql);
		List<CustomerEntity> list = query.list();
		return list;
	}

	// SearchMAKH
	public List<CustomerEntity> searchCustomerID(String ID) {
		Session session = factory.getCurrentSession();
		String hql = "FROM CustomerEntity where customerID LIKE '%" + ID + "%'";
		Query query = session.createQuery(hql);
		List<CustomerEntity> list = query.list();
		return list;
	}

	// DanhSach_KhachHang_theoID
	public CustomerEntity GetByCustomerID(String customerID) {
		Session session = factory.getCurrentSession();
		String hql = "from CustomerEntity Where customerID = :customerID";
		Query query = session.createQuery(hql);
		query.setParameter("customerID", customerID);
		List<CustomerEntity> list = query.list();
		return list.get(0);
	}

	// Insert_Customer
	public Integer InsertCustomer(CustomerEntity customer) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(customer);
			t.commit();
			session.close();
			return 1;
		} catch (Exception e) {
			t.rollback();
			session.close();
			return 0;
		}
	}

	// Edit_Customer
	public Integer EditCustomer(CustomerEntity customer) {
		// Boolean isSuccess = true;
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(customer);
			t.commit();
			session.close();
			return 1;
		} catch (Exception e) {
			t.rollback();
			session.close();
			return 0;
		}
	}

}
