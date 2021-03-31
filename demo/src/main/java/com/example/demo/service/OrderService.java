package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Order;
import com.example.demo.repo.OrderRepository;

@Service

public class OrderService { // Spring Beans//ServiceLayer
	@Autowired // is used for Dependency Injection-call the dependency repository in a
				// dependent service
	OrderRepository orderRepository;
	@Autowired
	RestTemplate getTaxesTemplate;
	@Transactional
	public String createOrder(Order order) {
		// call getTaxes
//		Float tax = getTaxesTemplate.getForObject("http://localhost:8081/getTaxes?price={price}", Float.class,
//				order.getPrice());
//		System.out.println(tax);
//		order.setTax(tax);
		Order savedOrder = orderRepository.save(order);
//		if (order!=null)
//			throw new RuntimeException();
		return savedOrder.getId();
		// return "Order Created";
	}

	public List<Order> getOrders() {
		// return new ArrayList<Order>(); //implementation before repository interface
		// was created
		return orderRepository.findAll();
	}

	public Optional<Order> getOrder(String orderId) {
		// return new Order();
		return orderRepository.findById(orderId);
	}

	public void updateOrder(Order order) {
		orderRepository.save(order);
	}

	public void deleteOrder(String orderId) {
		orderRepository.deleteById(orderId);
	}

	public OrderRepository getOrderRepository() {
		return orderRepository;
	}

	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
}
