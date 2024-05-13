package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.BillEntity;
import com.entity.DetailBillEntity;
import com.entity.EmployeeEntity;
import com.entity.PositionEntity;

import net.coobird.thumbnailator.resizers.ResizerFactory;

@Transactional
@Repository
public class DetailBillDao {
	@Autowired
	SessionFactory factory;

	// Lay_id
//	public DetailBillEntity getByBillID(int id) {
//		Session session = factory.getCurrentSession();
//		String hql = "FROM DetailBillEntity where billID = :id";
//		Query query = session.createQuery(hql);
//		query.setParameter("billID", id);
//		List<DetailBillEntity> list = query.list();
//		if (list.size() == 0) {
//			return null;
//		}
//		return list.get(0);
//	}

	// String hql = "SELECT dr.drinkName,dr.price, dt.size, dt.quantity,
	// CASE WHEN (dt.size = 1) THEN dr.price * dt.quantity + '10000' WHEN (dt.size =
	// 0) THEN dr.price * dt.quantity + '0'
	// END AS total FROM DetailBillEnity dt, DrinkEntity dr WHERE dr.drinkID =
	// dt.drinkID AND dt.billID = :id";

	// DanhSach_Bill
	public List<DetailBillEntity> SearchBillID(int billID) {
		Session session = factory.getCurrentSession();
		String hql = "FROM DetailBillEntity where BillID = :billID";
		Query query = session.createQuery(hql);
		query.setParameter("billID", billID);

		List<DetailBillEntity> res = query.list();

		if (res.size() == 0) {
			return null;
		}
		return res;
	}

	public List<DetailBillEntity> DetaiBillList() {
		Session session = factory.getCurrentSession();
		String hql = "FROM DetailBillEntity ";
		Query query = session.createQuery(hql);
		List<DetailBillEntity> list = query.list();
		return list;
	}

	// TổngBill
	public Integer TotalBill(DetailBillEntity detailbill, int billID) {
		Session session = factory.getCurrentSession();
		String hql = "FROM DetailBillEntity where BillID = :billID";
		Query query = session.createQuery(hql);
		query.setParameter("billID", billID);

		Integer total = 0;
		List<DetailBillEntity> res = query.list();
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i).isSize() == true) {
				total = total + (res.get(i).getDrink().getPrice() * res.get(i).getQuantity() + 10000);
			} else {
				total = total + (res.get(i).getDrink().getPrice() * res.get(i).getQuantity());
			}
		}
		System.out.println("hD:" + billID + "price:" + total);
		return total;
	}

	public Integer getDetailBillListTemp() {
		return 0;
	}

	// InsertHD
	public Integer InsertDetailBill(DetailBillEntity detailbill) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(detailbill);
			t.commit();
			session.close();
			return 1;
		} catch (Exception e) {
			t.rollback();
			session.close();
			return 0;
		}

	}

	// Delete_MaThucUong
	public Integer DeleteDrinkIDDetailBill(String drinkID) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		DetailBillEntity detailbill = (DetailBillEntity) session.get(DetailBillEntity.class, drinkID);
		try {
			session.delete(detailbill);
			t.commit();
			session.close();
			return 1;
		} catch (Exception e) {
			t.rollback();
			session.close();
			return 0;
		}

	}

	// TổngBill
	public Integer CheckDetail(DetailBillEntity detailbill, int billID) {
		Session session = factory.getCurrentSession();
		String hql = "FROM DetailBillEntity where BillID = :billID";
		Query query = session.createQuery(hql);
		query.setParameter("billID", billID);

		List<DetailBillEntity> res = query.list();
		if (res.size() == 0) {
			return 0;
			// xóa hóa đơn với mã hóa đơn kiểm tra
		}
		return 1;
		//return đến trang chi tiết hóa đơn
	}

}
