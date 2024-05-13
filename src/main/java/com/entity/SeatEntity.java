package com.entity;

import java.util.Collection;

import javax.persistence.Column;
//
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Seat")
public class SeatEntity {
	//maBa_PKtangDan
			@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
			@Column(name="SeatID")
			private int SeatID;
			
			//SoGhe
			@Column(name="SeatNum")
			private short seatNum;
			
			// TrangTháingồi
			@Column(name="SeatStatus")
			private boolean seatStatus;
			
			@OneToMany(mappedBy = "seat",fetch = FetchType.EAGER)
			private Collection<BillEntity>bills;

			public int getSeatID() {
				return SeatID;
			}

			public void setSeatID(int seatID) {
				SeatID = seatID;
			}

			public short getSeatNum() {
				return seatNum;
			}

			public void setSeatNum(short seatNum) {
				this.seatNum = seatNum;
			}

			public boolean isSeatStatus() {
				return seatStatus;
			}

			public void setSeatStatus(boolean seatStatus) {
				this.seatStatus = seatStatus;
			}

			public Collection<BillEntity> getBills() {
				return bills;
			}

			public void setBills(Collection<BillEntity> bills) {
				this.bills = bills;
			}

			
			
}
