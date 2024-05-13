package com.dao;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.BillEntity;

@Transactional
@Repository
public class BillDao {
	@Autowired
	SessionFactory factory;

	// DanhSach_HD
	public List<BillEntity> BillList() {
		Session session = factory.getCurrentSession();
		String hql = "from BillEntity ";
		Query query = session.createQuery(hql);
		List<BillEntity> list = query.list();
		return list;
	}

	// LayMaHD
	public BillEntity GetByBillID(int billID) {
		Session session = factory.getCurrentSession();
		String hql = "from BillEntity Where billID = :billID";
		Query query = session.createQuery(hql);
		query.setParameter("billID", billID);
		List<BillEntity> list = query.list();
		return list.get(0);
	}

	// InsertHD
	public Integer InsertBill(BillEntity bill) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(bill);
			t.commit();
			session.close();
			return 1;
		} catch (Exception e) {
			t.rollback();
			session.close();
			return 0;
		}

	}

	// EditHD
	public Integer EditBill(BillEntity bill) {
		// Boolean isSuccess = true;
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(bill);
			t.commit();
			session.close();
			return 1;
		} catch (Exception e) {
			t.rollback();
			session.close();
			return 0;
		}
	}

	// DeleteHD
	public Integer DeleteBill(int billID) {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			BillEntity bill = (BillEntity)session.get(BillEntity.class, billID);
			try {
				session.delete(bill);
				t.commit();
				session.close();
				return 1;
			} catch (Exception e) {
				t.rollback();
				session.close();
				return 0;
			}
	}
	
//	public Date getCreateBillDayNow(BillEntity bill) {
//		//LocalDateTime a = a.now();
//		bill.getCreateBillDay().getTime()= (Date)CreateBillDayNow.getTime();
//		return CreateBillDayNow;
//	}
	
	//tong tien 1 hóa đơn
//	public TotalBill()
//	{
//		
//	}
	
	//lấy mã hóa đơn cuối
	public Integer getByBillIdLast() {
		Session session = factory.getCurrentSession();
		String hql = "from BillEntity ";
		Query query = session.createQuery(hql);
		List<BillEntity> list = query.list();
		
		int billIdLast = 0;
			billIdLast= list.get(list.size()-1).getBillID();
		return billIdLast;
	}
}
