package com.foodexpress.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Restarants" ,
		uniqueConstraints = {@UniqueConstraint(columnNames= "rName"),
							 @UniqueConstraint(columnNames = "rId")})
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="rId" , nullable =false)
	private int rId;
	@Column(name="rName" , nullable = false)
	private String rName;
	@Column(name="rId" , nullable = false)
	private String rAddress;
	@Column(name="rMobile" , nullable = false)
	private int rMobileNo;
	
	public Restaurant() {
		this.rAddress= rAddress;
		this.rId=rId;
		this.rMobileNo=rMobileNo;
		this.rName=rName;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public String getrAddress() {
		return rAddress;
	}

	public void setrAddress(String rAddress) {
		this.rAddress = rAddress;
	}

	public int getrMobileNo() {
		return rMobileNo;
	}

	public void setrMobileNo(int rMobileNo) {
		this.rMobileNo = rMobileNo;
	}
		
}

