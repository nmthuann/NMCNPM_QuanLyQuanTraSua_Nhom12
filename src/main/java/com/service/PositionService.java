package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.PositionDao;

import com.entity.PositionEntity;

@Service
public class PositionService {
	@Autowired
	PositionDao positionDao;
	
//	//Check_id ChucVu
//		public boolean CheckPositionId(String id) {
//			return positionDao.CheckPositionId(id);
//		}
		
		
		//ChucVu_list
		public List<PositionEntity> PositionList(){
			return positionDao.PositionList() ;
		}
		
		//ChucVu_list
		public Integer InsertPosition(PositionEntity position){
			return positionDao.InsertPosition(position);
		}
		
		//
		public Integer EditPosition(PositionEntity position) {
			return positionDao.EditPosition(position);
		}
		
		
		public Integer DeletePosition(int positionID) {
			return positionDao.DeletePosition(positionID); 
		}
		
		public PositionEntity GetByPositionId(int Id) {
			return positionDao.GetByPositionID(Id);
		}
}
