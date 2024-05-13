package com.entity;

//import java.io.Serializable;
//import java.util.Objects;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;


import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
//import javax.persistence.FetchType;


//class DetailBillID implements Serializable{
//	
//	private static final long serialVersionUID = 1L;
//	
//	//@Column(name="MaHoaDon")
//	//@ManyToOne//(fetch=FetchType.LAZY)
//	//@JoinColumn(name="BillID")
//	protected  BillEntity bill;
//	
//	//@Column(name="MaDoUong")
//	//@ManyToOne//(fetch=FetchType.LAZY)
//	//@JoinColumn(name="DrinkID") 
//	protected DrinkEntity drink;
//
//
//	public DetailBillID(BillEntity bill, DrinkEntity drink) {
//		super();
//		this.bill = bill;
//		this.drink = drink;
//	}
//
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(bill, drink);
//	}
//
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		DetailBillID other = (DetailBillID) obj;
//		return Objects.equals(bill, other.bill) && Objects.equals(drink, other.drink);
//	}
//
//}

//@Embeddable
//class DetailBillID implements Serializable {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -2544562100149256862L;
//
////	@ManyToOne // (fetch=FetchType.LAZY)
////	@JoinColumn(name = "BillID")
//	@Column(name="BillID")
//	private Integer billId;
//
////	@ManyToOne // (fetch=FetchType.LAZY)
////	@JoinColumn(name = "DrinkID")
//	@Column(name="DrinkID")
//	private String drinkID;
//
//	public DetailBillID() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public Integer getBillId() {
//		return billId;
//	}
//
//	public void setBillId(Integer billId) {
//		this.billId = billId;
//	}
//
//	public String getDrinkID() {
//		return drinkID;
//	}
//
//	public void setDrinkID(String drinkID) {
//		this.drinkID = drinkID;
//	}
//
//	
//	
//	public DetailBillID(Integer billId, String drinkID) {
//		super();
//		this.billId = billId;
//		this.drinkID = drinkID;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(billId, drinkID);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		DetailBillID other = (DetailBillID) obj;
//		return Objects.equals(billId, other.billId) && Objects.equals(drinkID, other.drinkID);
//	}
//
//
//}

@Entity
@Table(name = "DetailBill")
public class DetailBillEntity {
//	@Id
//	//@Column(name="MaHoaDon")
//	@ManyToOne//(fetch=FetchType.LAZY)
//	@JoinColumn(name="BillID")
//	private BillEntity bill;
//		
//	@Id
//	//@Column(name="MaDoUong")
//	@ManyToOne//(fetch=FetchType.LAZY)
//	@JoinColumn(name="DrinkID")
//	private DrinkEntity drink;

	@EmbeddedId
	private DetailBillKey detailbillID;

	@ManyToOne
	@MapsId("billID")
	@JoinColumn(name = "BillID", nullable = false)
	private BillEntity bill;
	
	@ManyToOne
	@MapsId("drinkID")
	@JoinColumn(name = "DrinkID", nullable = false)
	private DrinkEntity drink;
	
	// size
	// @Column(name="Size")
	private boolean size;

	// soLuong
	private short quantity;

	

	public DetailBillKey getDetailbillID() {
		return detailbillID;
	}

	public void setDetailbillID(DetailBillKey detailbillID) {
		this.detailbillID = detailbillID;
	}

	public BillEntity getBill() {
		return bill;
	}

	public void setBill(BillEntity bill) {
		this.bill = bill;
	}

	public DrinkEntity getDrink() {
		return drink;
	}

	public void setDrink(DrinkEntity drink) {
		this.drink = drink;
	}

	public boolean isSize() {
		return size;
	}

	public void setSize(boolean size) {
		this.size = size;
	}

	public short getQuantity() {
		return quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

	


}
