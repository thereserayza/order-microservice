package com.ibm.ojt;

//import java.time.LocalDate;
//import java.util.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

@RepositoryRestResource(collectionResourceRel="orderdetail", path="order")
public interface OrderRepository extends MongoRepository<Order, String>{
	
	List<Order> findByOrderDateGreaterThanEqual(@Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime date); //negotiable www
	List<Order> findByCustomerId(@Param("custid") String customerId);
}
