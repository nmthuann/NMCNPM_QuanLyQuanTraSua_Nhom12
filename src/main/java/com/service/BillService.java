package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BillDao;
import com.entity.BillEntity;

@Service
public class BillService {
	@Autowired
	BillDao billDao;
	
	
	public List<BillEntity> BillList(){
		return billDao.BillList() ;
	}
	
	//ThemHD
	public Integer InsertBill(BillEntity bill){
		return billDao.InsertBill(bill);
	}
	
	//
	public Integer EditBill(BillEntity bill) {
		return billDao.EditBill(bill);
	}
	
	
	public Integer DeleteBill(int billID) {
		return billDao.DeleteBill(billID);
	}
	
	public BillEntity GetByBillID(int Id) {
		return billDao.GetByBillID(Id);
	}
	
//	public Date getCreateBillDayNow(Date CreateBillDayNow) {
//		return billDao.getCreateBillDayNow(CreateBillDayNow);
//	}
	
	public Integer getByBillIdLast() {
		return billDao.getByBillIdLast();
	}
}
