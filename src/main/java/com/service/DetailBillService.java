package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DetailBillDao;
import com.entity.DetailBillEntity;
//import com.entity.DrinkEntity;

@Service
public class DetailBillService {
	@Autowired
	DetailBillDao detailBillDao;
	
//	public DetailBillEntity getByBillID(int id) {
//		return detailBillDao.getByBillID(id);
//	}
	
	public List<DetailBillEntity> SearchBillID(int id) {
		return detailBillDao.SearchBillID(id);
	}
	
	//Drink_list
		public List<DetailBillEntity> DetailBillList(){
			return detailBillDao.DetaiBillList();
		}
		
		public Integer TotalBill(DetailBillEntity detailbill,int billID) {
			return detailBillDao.TotalBill(detailbill, billID);
		}
		
		public Integer InsertDetailBill(DetailBillEntity detailbill) {
			return detailBillDao.InsertDetailBill(detailbill);
		}
		
		public Integer DeleteDrinkIDDetailBill(String drinkID) {
			return detailBillDao.DeleteDrinkIDDetailBill(drinkID);
		}
}
