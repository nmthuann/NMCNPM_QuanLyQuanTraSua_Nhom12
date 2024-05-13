package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DrinkDao;
import com.entity.DrinkEntity;
import com.entity.PositionEntity;

@Service
public class DrinkService {
	@Autowired
	DrinkDao drinkDao;

	// Check_id Drink
	public boolean CheckId(String id) {
		return drinkDao.CheckId(id);
	}
	
	//lấy id
	public DrinkEntity GetByDrinkId(String Id) {
		return drinkDao.GetByDrinkID(Id);
	}
	
	public List<DrinkEntity> SearchDrinkName(String name) {
		return drinkDao.SearchDrinkName(name);
	}
	
	// lay_name_drink
	public DrinkEntity getByDrinkName(String drinkName) {
		return drinkDao.getByDrinkName(drinkName);
	}

	// Drink_list
	public List<DrinkEntity> DrinkList() {
		return drinkDao.DrinkList();
	}

	public Integer InsertDrink(DrinkEntity drink) {
		return drinkDao.InsertDrink(drink);
	}

	//
	public Integer EditDrink(DrinkEntity drink) {
		return drinkDao.InsertDrink(drink);
	}

	public Integer DeleteDrink(String drinkID) {
		return drinkDao.DeleteDrink(drinkID);
	}
}
