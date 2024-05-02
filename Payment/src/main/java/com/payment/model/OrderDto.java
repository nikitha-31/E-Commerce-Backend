package com.payment.model;

public class OrderDto {
	
	private long orderId;
	private long productId;
	private int quantity;
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
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public OrderDto(long orderId, long productId, int quantity, long userId) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.userId = userId;
	}
	
	public OrderDto() {
		super();
	}
	@Override
	public String toString() {
		return "OrderDto [orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + ", userId="
				+ userId + "]";
	}
	
	

}
