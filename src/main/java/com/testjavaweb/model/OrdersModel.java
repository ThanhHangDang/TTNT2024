package com.testjavaweb.model;

public class OrdersModel extends AbstractModel<OrdersModel>{
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	private Integer userId;
	private Integer productId;
	private Integer number;
}