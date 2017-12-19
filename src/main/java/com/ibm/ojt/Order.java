package com.ibm.ojt;

//import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.json.simple.JSONObject;
import org.springframework.data.annotation.Id;

public class Order {
	
	@Id
	private String orderId;
	private Date orderDate;
	private String customerId;
	private List<Object> orderItems;
//	private List<Object> orderItems; //to be decided
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
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public List<Object> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<Object> orderItems) {
		this.orderItems = orderItems;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
