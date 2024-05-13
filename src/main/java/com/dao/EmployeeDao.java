package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.EmployeeEntity;
import com.entity.PositionEntity;
import com.entity.SeatEntity;

@Transactional
@Repository
public class EmployeeDao {
	@Autowired
	SessionFactory factory;

	// Check_ID_Tim_kiem
	public boolean CheckEmployeeId(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM EmployeeEntity where employeeID = :id";
		Query query = session.createQuery(hql);
		query.setParameter("employeeID", id);
		List<EmployeeEntity> list = query.list();
		if (list.size() == 0) {
			return false;
		}
		return true;
	}

	// DanhSach_NhanVien
	public List<EmployeeEntity> EmployeeList() {
		Session session = factory.getCurrentSession();
		String hql = "from EmployeeEntity ";
		Query query = session.createQuery(hql);
		List<EmployeeEntity> list = query.list();
		return list;
	}

	// Lay_id
	public EmployeeEntity getByEmployeeID(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM EmployeeEntity where employeeID = :id";
		Query query = session.createQuery(hql);
		query.setParameter("employeeID", id);
		List<EmployeeEntity> list = query.list();
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	// DanhSach_NhanVien
	public List<EmployeeEntity> SearchEmployeeName(String name) {
		Session session = factory.getCurrentSession();
		String hql = "FROM EmployeeEntity where lastName LIKE '%" + name + "%'";
		Query query = session.createQuery(hql);
		List<EmployeeEntity> list = query.list();
		return list;
	}

	// Lấy Danh sách tên Chức vụ

	public List<PositionEntity> getByPositionNameList() {
		Session session = factory.getCurrentSession();
		String hql = "from PositionEntity  ";
		Query query = session.createQuery(hql);
		List<PositionEntity> list = query.list();
		return list;
	}

	// DanhSach_lấy ID Nhân viên
	public EmployeeEntity GetByEmployeeID(int employeeID) {
		Session session = factory.getCurrentSession();
		String hql = "from EmployeeEntity Where employeeID = :employeeID";
		Query query = session.createQuery(hql);
		query.setParameter("employeeID", employeeID);
		List<EmployeeEntity> list = query.list();
		return list.get(0);
	}

	// update trạng thái nhân viên
	public Integer UpdateEmployeeStatus(int employeeID) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		EmployeeEntity employee = (EmployeeEntity) session.get(EmployeeEntity.class, employeeID);
		if (employee.isStatus() == true) {
			employee.setStatus(false);
		}
		else {
			employee.setStatus(true);
		}
		try {
			session.update(employee);
			t.commit();
			session.close();
			return 1;
		} catch (Exception e) {
			t.rollback();
			session.close();
			return 0;
		}
	}

	// Edit_Seat
	public Integer EditEmployee(EmployeeEntity employee) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(employee);
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
