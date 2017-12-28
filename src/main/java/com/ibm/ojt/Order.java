package com.ibm.ojt;

//import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

public class Order {
	
	@Id
	private String orderId;
	@CreatedDate
	private LocalDateTime orderDate;
	private String customerId;
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	private double totalPrice;
	private String status;
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
