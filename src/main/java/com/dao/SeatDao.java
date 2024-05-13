package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.PositionEntity;
import com.entity.SeatEntity;

@Transactional
@Repository
public class SeatDao {
	@Autowired
	SessionFactory factory;

	// Check_ID
	public boolean CheckSeatId(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM SeatEntity where SeatID = :id";
		Query query = session.createQuery(hql);
		query.setParameter("SeatID", id);
		List<SeatEntity> list = query.list();
		if (list.size() == 0) {
			return false;
		}
		return true;
	}
	
	public SeatEntity getSeatID(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM SeatEntity where seatID = :id";
		Query query = session.createQuery(hql);
		query.setParameter("seatID", id);
		SeatEntity list = (SeatEntity) query.list().get(0);
		return list;
	}

	// DanhSach_ban
	public List<SeatEntity> SeatList() {
		Session session = factory.getCurrentSession();
		String hql = "from SeatEntity ";
		Query query = session.createQuery(hql);
		List<SeatEntity> list = query.list();
		return list;
	}

	// Lay_DanhSach ban_Trong
	public List<SeatEntity> getByEmptySeatList() {

		Session session = factory.getCurrentSession();
		String hql = "from SeatEntity where SeatStatus  = true";
		Query query = session.createQuery(hql);
		List<SeatEntity> list = query.list();
		return list;
	}

	// Insert_Seat
	public Boolean InsertSeat(SeatEntity seat) {
		Boolean isSuccess = true;
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(seat);
			t.commit();
		} catch (Exception e) {
			System.out.println(e);
			t.rollback();
			isSuccess = false;
		} finally {
			session.close();
		}
		return isSuccess;
	}

	// Edit_Seat
	public Integer UpdateSeat(SeatEntity seat) {
		//Boolean isSuccess = true;
				Session session = factory.openSession();
				Transaction t = session.beginTransaction();
				
				try {
					session.update(seat);
					t.commit();
					session.close();
					return 1;
				} catch (Exception e) {
					t.rollback();
					session.close();
					return 0;
				}
	}

	// Delete_Seat
	public Boolean DeleteSeat(SeatEntity seat) {
		Boolean isSuccess = true;
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(seat);
			t.commit();

		} catch (Exception e) {
			System.out.println(e);
			t.rollback();
			isSuccess = false;
		} finally {
			session.close();
		}
		return isSuccess;
	}

	
	public Integer UpdateStatus(int seatID) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		SeatEntity seat = (SeatEntity)session.get(SeatEntity.class, seatID);
		if(seat.isSeatStatus()==true)
		{
			seat.setSeatStatus(false);
		}
		else {
			seat.setSeatStatus(true);
		}
			
		try {
		session.update(seat);
			t.commit();
			session.close();
			return 1;
		} catch (Exception e) {
			t.rollback();
			session.close();
			return 0;
		}
		
	}
	
	
	
	
	// Update_Status
//	// chuyển_sang_false
//		public Boolean updateSattus(int id,boolean check) {
//			Session session = factory.openSession();
//			Transaction t = session.beginTransaction();
//			if (check == true) {
//				Query query = session.createQuery(
//						"update SeatEntity set seatStatus = false where SeatID = :id");
//				try {
//					query.executeUpdate();
//					t.commit();
//				} catch (Exception e) {
//					t.rollback();
//
//				} finally {
//					session.close();
//				}
//				return true;
//			}
//			else {
//				Query query = session.createQuery("update SeatEntity set seatStatus = true where SeatID = :id");
//				try {
//					query.executeUpdate();
//					t.commit();
//				} catch (Exception e) {
//					t.rollback();
//
//				} finally {
//					session.close();
//				}
//				return false;
//			}
//			
//		}
}
