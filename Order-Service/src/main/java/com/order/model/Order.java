package com.order.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ordered-items")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long orderId;
	private long productId;
	private int quantity;
	private String customerName;
	private String adress;
	private String pincode;
	private String contachNumber;
	private long userId;
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getContachNumber() {
		return contachNumber;
	}
	public void setContachNumber(String contachNumber) {
		this.contachNumber = contachNumber;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Order(long orderId, long productId, int quantity, String customerName, String adress, String pincode,
			String contachNumber, long userId) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.customerName = customerName;
		this.adress = adress;
		this.pincode = pincode;
		this.contachNumber = contachNumber;
		this.userId = userId;
	}
	public Order() {
		super();
	}
	

}
