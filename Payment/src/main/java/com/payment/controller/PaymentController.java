package com.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.payment.model.UserDto;
import com.payment.service.UserService;
import com.payment.model.OrderDto;
import com.payment.model.Payment;
import com.payment.service.OrderService;
import com.payment.service.PaymentServiceImpl;


@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	
	@Autowired
	private PaymentServiceImpl PaymentServiceImpl;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/make/payment")
	public ResponseEntity<Payment> makePayment(
			@RequestBody Payment payment,
			@RequestParam Long orderId
			)throws Exception{
		OrderDto order=orderService.getOrderByOrderId(orderId);
		Payment makePayment=PaymentServiceImpl.makePayment(payment,order.getOrderId(),order.getUserId());
		return ResponseEntity.status(HttpStatus.CREATED).body(makePayment);
	}
	
	@GetMapping("all/payments")
	private ResponseEntity<List<Payment>> getAllPayments(@RequestHeader("Authorization") String jwt)throws Exception{
		UserDto user=userService.getUserProfile(jwt);
		List<Payment> payment =PaymentServiceImpl.getAllPayments(user.getRole());
        return ResponseEntity.ok(payment);
	}
	

}
