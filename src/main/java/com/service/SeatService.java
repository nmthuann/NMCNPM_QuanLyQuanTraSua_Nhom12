package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.SeatDao;

import com.entity.SeatEntity;

@Service
public class SeatService {
	@Autowired
	SeatDao seatDao;
	
	
	//Check_id Seat
		public boolean CheckSeatId(int id) {
			return seatDao.CheckSeatId(id);
		}
		
		//Seat_list
		public List<SeatEntity> SeatList(){
			return seatDao.SeatList();
		}
		
		//danh sach rỗng
		public List<SeatEntity> getByEmptySeatList(){
			return seatDao.getByEmptySeatList();
		}
		
		public SeatEntity getSeatID(int id) {
			return seatDao.getSeatID(id);
		}
		
//		public boolean updateSatus( int id, boolean check) {
//			//if (check==true) {
//			//	return seatDao.updateSattus(id,false);
//			//}
//			return seatDao.updateSattus(id,check);
//		}
		
		public Integer UpdateSeat(SeatEntity seat) {
			return seatDao.UpdateSeat(seat);
		}
		
		public Integer UpdateStatus(int seatID) {
			return seatDao.UpdateStatus(seatID);
		}
}
