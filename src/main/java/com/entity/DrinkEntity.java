package com.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Drink")
public class DrinkEntity {
	//MaThucUong
		@Id
		@Column(name="DrinkID")
		private String drinkID;
		
		@OneToMany(mappedBy = "drink",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
		private Collection<DetailBillEntity>detailBills;
		
		//TenThucUong
		@Column(name="DrinkName")
		private String drinkName;
		
		//DonGia
		@Column(name="Price")
		private int price;
		
		//DonViTinh
		@Column(name="Unit")
		private String unit;

		public String getDrinkID() {
			return drinkID;
		}

		public void setDrinkID(String drinkID) {
			this.drinkID = drinkID;
		}

		public Collection<DetailBillEntity> getDetailBills() {
			return detailBills;
		}

		public void setDetailBills(Collection<DetailBillEntity> detailBills) {
			this.detailBills = detailBills;
		}

		public String getDrinkName() {
			return drinkName;
		}

		public void setDrinkName(String drinkName) {
			this.drinkName = drinkName;
		}

		

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public String getUnit() {
			return unit;
		}

		public void setUnit(String unit) {
			this.unit = unit;
		}
		
		
		
}
