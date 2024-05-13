package com.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class DetailBillKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(name="BillID")
	private int billID;

	@Column(name="DrinkID")
	private String drinkID;

	public DetailBillKey() {
		// TODO Auto-generated constructor stub
	}

	public int getBillID() {
		return billID;
	}

	public void setBillID(int billID) {
		this.billID = billID;
	}

	public String getDrinkID() {
		return drinkID;
	}

	public void setDrinkID(String drinkID) {
		this.drinkID = drinkID;
	}

	public DetailBillKey(int billID, String drinkID) {
		super();
		this.billID = billID;
		this.drinkID = drinkID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(billID, drinkID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetailBillKey other = (DetailBillKey) obj;
		return billID == other.billID && Objects.equals(drinkID, other.drinkID);
	}

	

}
