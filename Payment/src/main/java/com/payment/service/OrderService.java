package com.payment.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.payment.model.OrderDto;

@FeignClient(name="ORDER-SERVICE", url="http://localhost:8002")
public interface OrderService {
	
	@GetMapping("/api/orders/order/{orderId}")
	public OrderDto getOrderByOrderId(@PathVariable Long orderId);

}
