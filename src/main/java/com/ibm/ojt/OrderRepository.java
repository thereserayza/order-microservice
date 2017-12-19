package com.ibm.ojt;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="orderdetail", path="order")
public interface OrderRepository extends MongoRepository<Order, String>{
	
	List<Order> findByOrderDate(@Param("date") Date date); //negotiable www
	List<Order> findByCustomerId(@Param("custid") String customerId);
}
