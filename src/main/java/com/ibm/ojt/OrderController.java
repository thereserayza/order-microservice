package com.ibm.ojt;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@GetMapping
	public List<Order> findAllOrder() {
		return mongoTemplate.findAll(Order.class, "order");
	}
	
	@GetMapping("/user/{customerId}")
	public List<Order> findByCustomerId(@PathVariable String customerId) {
		Query query = new Query().addCriteria(Criteria.where("customerId").is(customerId).and("status").ne("CA"));
		return mongoTemplate.find(query, Order.class, "order");
	}
	
	@GetMapping("/{customerId}/{orderDate}")
	public List<Order> findByCustomerIdAndOrderDate(@PathVariable String customerId, 
			@PathVariable @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)LocalDate orderDate) {
		Query query = new Query().addCriteria(Criteria.where("customerId").is(customerId).and("orderDate").gte(orderDate).and("status").ne("CA"));
		return mongoTemplate.find(query, Order.class, "order");
	}
	
	@GetMapping("/{orderId}")
	public Order findByOrderId(@PathVariable String orderId){
		Query query = new Query().addCriteria(Criteria.where("orderId").is(orderId).and("status").ne("CA"));
		return mongoTemplate.findOne(query, Order.class, "order");
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public Order createOrder(@RequestBody Order order) {
		order.setStatus("CL");
		mongoTemplate.save(order, "order");
		return order;
	}
	
	@PutMapping("/{orderId}")
	public void cancelOrder(@PathVariable String orderId) {
		Query query = new Query().addCriteria(Criteria.where("orderId").is(orderId));
		Order _order = mongoTemplate.findOne(query, Order.class, "order");
		if (_order != null) {
			Update update = new Update().set("status", "CA");
			mongoTemplate.findAndModify(query, update, Order.class, "order");
		}
	}
}
