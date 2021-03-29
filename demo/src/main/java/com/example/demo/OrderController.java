package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

@RestController // Bean
public class OrderController { // frontend
	@Autowired // is used for Dependency Injection-call the dependency service in a dependent controller
	OrderService orderService;

	@PostMapping("/order")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createOrder(@RequestBody @Valid Order order, BindingResult bindingResult) {
		validateModel(bindingResult);
		System.out.println(order);
		return orderService.createOrder(order);
	}
	@GetMapping("/order")
	List<Order> getOrder() {
		return orderService.getOrders();
	}
	/**
	 * method to search for an order
	 * @param orderId
	 * @return zero or matching order
	 */
	@GetMapping("/order/{id}")
	Optional<Order> getOrder(@PathVariable("id")String orderId) {
		return orderService.getOrder(orderId);
	}

	//DRY
	private void validateModel(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong.Please Retry");
		}
	}	

	@PutMapping("/order/{id}")
	void updateOrder(@RequestBody @Valid Order order, BindingResult bindingResult, @PathVariable("id") String orderId) {
		validateModel(bindingResult);
		System.out.println(orderId);
		order.setId(orderId);
		orderService.updateOrder(order);
	}

	@DeleteMapping("/order/{id}")
	void deleteOrder(@PathVariable("id") String orderId) {
		System.out.println(orderId);
		orderService.deleteOrder(orderId);
	}
}
