package com.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.model.OrderDto;
import com.payment.model.Payment;
import com.payment.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private OrderService orderService;
	
	
	@Override
	public Payment makePayment(Payment payment,long orderId, long userId)throws Exception {
		OrderDto order=orderService.getOrderByOrderId(orderId);
		if(order!=null) {
			payment.setOrderId(orderId);
			payment.setUserId(userId);
			
			return paymentRepository.save(payment);
		}
		throw new Exception("Order Not Found");
	}


	@Override
	public List<Payment> getAllPayments(String requestRole) throws Exception {
		if(!requestRole.equals(("Role_Admin"))) {
			throw new Exception("only admin can view orders");
		}
		return paymentRepository.findAll() ;
	}

}
