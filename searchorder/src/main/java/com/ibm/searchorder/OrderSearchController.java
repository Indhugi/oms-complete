package com.ibm.searchorder;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.searchorder.entity.Order;
import com.ibm.searchorder.service.OrderService;

@RestController
public class OrderSearchController {
	@Autowired // is used for Dependency Injection-call the dependency service in a dependent
				// controller
	OrderService orderService;

	@GetMapping("/order")
	List<Order> getOrder() {
		return orderService.getOrders();
	}

	@GetMapping("/order/{id}")
	Optional<Order> getOrderById(@PathVariable("id") String orderId) {
		return orderService.getOrderById(orderId);
	}

}
