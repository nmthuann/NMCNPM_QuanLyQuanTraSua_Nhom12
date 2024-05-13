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
import com.entity.PositionEntity;

@Transactional
@Repository
public class PositionDao {
	@Autowired
	SessionFactory factory;
//
//	public boolean CheckPositionId(String id) {
//		Session session = factory.getCurrentSession();
//		String hql = "FROM  where positionID = :id";
//		Query query = session.createQuery(hql);
//		query.setParameter("positionID", id);
//		List<PositionEntity> list = query.list();
//		if (list.size() == 0) {
//			return false;
//		}
//		return true;
//	}

	// DanhSach_ChucVu
	public List<PositionEntity> PositionList() {
		Session session = factory.getCurrentSession();
		String hql = "from PositionEntity ";
		Query query = session.createQuery(hql);
		List<PositionEntity> list = query.list();
		return list;
	}
	
	// layMaCHucVu
	public PositionEntity  GetByPositionID(int positionID) {
		Session session = factory.getCurrentSession();
		String hql = "from PositionEntity Where positionID = :positionID";
		Query query = session.createQuery(hql);
		query.setParameter("positionID", positionID);
		List<PositionEntity> list = query.list();
		return list.get(0);
	}

	// Insert_Customer
	public Integer InsertPosition(PositionEntity position) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(position);
			t.commit();
			session.close();
			return 1;
		} catch (Exception e) {
			t.rollback();
			session.close();
			return 0;
		}
		/*
		 * } finally {
		 * 
		 * } return 1;
		 */
	}

	// Edit_ChucVu
	public Integer EditPosition(PositionEntity position) {
		//Boolean isSuccess = true;
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.update(position);
			t.commit();
			session.close();
			return 1;
		} catch (Exception e) {
			t.rollback();
			session.close();
			return 0;
		}
	}

	// Delete_ChucVu
	public Integer DeletePosition(int positionID) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		PositionEntity position = (PositionEntity)session.get(PositionEntity.class, positionID);
		try {
			session.delete(position);
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
