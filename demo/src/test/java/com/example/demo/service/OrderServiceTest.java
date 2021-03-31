package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.entity.Order;
import com.example.demo.repo.OrderRepository;

class OrderServiceTest {

	@Test
	void testCreateOrder() {
	//	fail("Not yet implemented");
		OrderService orderService=new OrderService();
		OrderRepository dummyRepo=new DummyOrderRepository();
		orderService.setOrderRepository(dummyRepo);
		Order order=new Order();
		String orderId=orderService.createOrder(order);
		assertNotNull(orderId);
	}

	@Test
	void testGetOrders() {
		//fail("Not yet implemented");
	}

	@Test
	void testGetOrder() {
		//fail("Not yet implemented");
	}

	@Test
	void testUpdateOrder() {
		//fail("Not yet implemented");
	}

	@Test
	void testDeleteOrder() {
		//fail("Not yet implemented");
	}

}
