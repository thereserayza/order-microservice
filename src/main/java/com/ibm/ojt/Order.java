package com.ibm.ojt;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.json.simple.JSONObject;
import org.springframework.data.annotation.Id;

public class Order {
	
	@Id
	private String orderId;
	private String orderDate = new Date().toString();
	private String customerId;
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	private double totalPrice;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
