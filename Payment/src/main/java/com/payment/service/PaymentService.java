package com.payment.service;

import java.util.List;

import com.payment.model.Payment;


public interface PaymentService {
	
	Payment makePayment(Payment payment,long orderId, long userId)throws Exception;
	
	List<Payment> getAllPayments(String requestRole)throws Exception;

}
